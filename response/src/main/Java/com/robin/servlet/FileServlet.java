package com.robin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //path
        String realPath = this.getServletContext().getRealPath("/Users/liyijian/IdeaProjects/servlet_proj1/response/src/main/Resources/screenshot.png");
        //name
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //Set our browser could support what we need to download
        resp.setHeader("Content-disposition","attachment;filename"+ URLEncoder.encode(fileName, "UTF-8"));
        //InputSteam
        FileInputStream in = new FileInputStream(realPath);
        //IO buffer
        int len = 0;
        byte[] buffer = new byte[1024];
        //get OutputStream
        ServletOutputStream out = resp.getOutputStream();
        //use FileOutputSteam to write into buffer
        while((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
