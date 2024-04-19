package Servlet;

import Resultinfo.ResultInfo;
import Service.service;
import Service.serviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import face.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registservlet")
public class registServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]>map=request.getParameterMap();
        User use=new User();
        try {
            BeanUtils.populate(use,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        service s=new serviceimpl();
        boolean i=s.findusernameandpassword(use);
        ResultInfo info=new ResultInfo();
        if(i){
            //用户注册成功
            info.setFlag(true);
        }
        else{
            info.setFlag(false);
            info.setErrorMsg("用户注册失败");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        //2.将json对象返回客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);


    }
}
