package Servlet;

import Resultinfo.ResultInfo;
import Service.service;
import Service.serviceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import face.Allgames;
import face.speaking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/speakingareaservlet")
public class speakingareaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service se=new serviceimpl();
        List<speaking> speaking=se.speakarea();
        ResultInfo info=new ResultInfo();
        info.setSpeakarea(speaking);
        System.out.println(info.getSpeakarea());
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        //字符输出流
        response.getWriter().write(json);
    }
}
