package Servlet;

import Resultinfo.ResultInfo;
import Service.service;
import Service.serviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import face.Game;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/checkgamesservlet")
public class checkgamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map=request.getParameterMap();
        Game games=new Game();
        try {
            BeanUtils.populate(games,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        service se=new serviceimpl();
        Game g=se.find(games);
        ResultInfo info=new ResultInfo();
        if(g!=null){
            info.setFlag(true);
            info.setGa(g);
        }
        else{
            info.setFlag(false);
            info.setErrorMsg("查询失败");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        //2.将json对象返回客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }
}
