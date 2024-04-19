package Servlet;

import Resultinfo.ResultInfo;
import Service.service;
import Service.serviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import face.Game;
import face.speaking;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/speakingservlet")
public class speakingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> map=request.getParameterMap();
        speaking speak=new speaking();
        try {
            BeanUtils.populate(speak,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        HttpSession session= request.getSession();
        Object usernames=session.getAttribute("usernames");
        String use=(String) usernames;
        speak.setUsernames(use);
        service se=new serviceimpl();
//        System.out.println(game.getGamesname());
        boolean g=se.Speaking(speak);
//          System.out.println(g);
        ResultInfo info=new ResultInfo();
        if(g){
            //删除成功
            info.setFlag(true);
        }
        else{
            info.setFlag(false);
            info.setErrorMsg("评论失败");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);


    }
}
