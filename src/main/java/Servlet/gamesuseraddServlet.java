package Servlet;

import Resultinfo.ResultInfo;
import Service.service;
import Service.serviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import face.Allgames;
import face.Game;
import face.gamesanduser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/gamesuseraddservlet")
public class gamesuseraddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map=request.getParameterMap();
        Allgames games=new Allgames();
        try {
            BeanUtils.populate(games,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session= request.getSession();
        Object u=session.getAttribute("usernames");
        gamesanduser gu=new gamesanduser();
        gu.setUsername((String)u);
        service se=new serviceimpl();
        boolean a=se.gamesadd(games,gu);
        ResultInfo info=new ResultInfo();
        if(a){
            info.setFlag(true);
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
