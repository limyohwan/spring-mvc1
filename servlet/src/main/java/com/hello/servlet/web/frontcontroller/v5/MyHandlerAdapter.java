package com.hello.servlet.web.frontcontroller.v5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.servlet.web.frontcontroller.ModelView;

public interface MyHandlerAdapter {
    
    boolean suppoerts(Object handler);

    ModelView handle(HttpServletRequest request,HttpServletResponse response, Object handler) throws ServletException, IOException;
}
