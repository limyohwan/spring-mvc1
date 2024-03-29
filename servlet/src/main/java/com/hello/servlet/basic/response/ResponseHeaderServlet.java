package com.hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns ="/response-header")
public class ResponseHeaderServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setStatus(HttpServletResponse.SC_OK);

        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("myheader", "hello");
        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }
    
}
