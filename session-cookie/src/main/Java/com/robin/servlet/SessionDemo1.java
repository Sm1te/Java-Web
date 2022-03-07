package com.robin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset = uft-8");

        //get session
        HttpSession session = req.getSession();

        //store something
        session.setAttribute("name", "Yijian Li");

        //Get id
        String id = session.getId();

        //is it a new id?
        if(session.isNew()){
            resp.getWriter().write("Successfully created, id: "+ id);
        }else{
            resp.getWriter().write("is has already been stored with id: " + id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
