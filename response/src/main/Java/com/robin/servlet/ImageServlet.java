package com.robin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //how to enable browser to refresh per 5 secs
        resp.setHeader("refresh", "3");

        //create an image in ram
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //get image
        Graphics2D g = (Graphics2D) image.getGraphics();//pen
        //set background color
        g.setColor(Color.BLUE);
        g.fillOval(0,0,80,20);
        //write data
        g.setColor(Color.GREEN);
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);

        //tell the browser to open this pic with response
        resp.setContentType("image/jpeg");
        //do not let browser cache
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", " no-cache");
        resp.setHeader("Pragma", "no-cache");

        //write this pic to browser
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(99999) + "";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 5 - num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString() + num;//make sure you have 5 digit, kind like fill out the space
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
