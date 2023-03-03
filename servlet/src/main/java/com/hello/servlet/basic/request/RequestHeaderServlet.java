package com.hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="requestHeaderServlet", urlPatterns =  "/request-header")
public class RequestHeaderServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("-------헤더 편의조회 start--------");
        System.out.println("server port");
        System.out.println("getServerName : " + req.getServerName() );
        System.out.println("getServerPort : " + req.getServerPort() );

        System.out.println("Locale");
        req.getLocales().asIterator()
        .forEachRemaining(locale -> System.out.println("Locale = " + locale));

        System.out.println("getLocale : " + req.getLocale() );

        System.out.println("cookie");
        if(req.getCookies() != null){
            for(Cookie cookie : req.getCookies()){
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }

        System.out.println("Content");
        System.out.println("getContentType : " + req.getContentType());
        System.out.println("getContentLength : " + req.getContentLength());
        System.out.println("getCharacterEncoding : " + req.getCharacterEncoding());

        System.out.println("-------헤더 편의조회 end--------");

    }

    private void printStartLine(HttpServletRequest request){
        System.out.println("-------req start--------");

        System.out.println("getMethod : " + request.getMethod() );
        System.out.println("getProtocol : " + request.getProtocol() );
        System.out.println("getScheme : " + request.getScheme() );
        System.out.println("getRequestURL : " + request.getRequestURL() );
        System.out.println("getRequestURI : " + request.getRequestURI() );
        System.out.println("getQueryString : " + request.getQueryString() );
        System.out.println("isSecure : " + request.isSecure() );

        System.out.println("-------req end--------");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("---------header start -----------");

        request.getHeaderNames().asIterator()
        .forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));
        System.out.println("---------header end -----------");
        System.out.println();
    }
    
}
