package Servlet;

import Resultinfo.ResultInfo;
import Service.service;
import Service.serviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import face.Allgames;
import face.gamesanduser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/findmygamesservlet")
public class findmygamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        Object msg=session.getAttribute("usernames");
        //调用service
        service se=new serviceimpl();
        List<gamesanduser> gau=se.mygames((String)msg);
        System.out.println(gau);
        ResultInfo info=new ResultInfo();
        if(gau!=null){
            info.setFlag(true);
            info.setGamesanduser(gau);
        }else{
            info.setFlag(false);
        }
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        //字符输出流
        response.getWriter().write(json);

    }
}
