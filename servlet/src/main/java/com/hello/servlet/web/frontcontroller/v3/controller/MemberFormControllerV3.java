package com.hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import com.hello.servlet.web.frontcontroller.ModelView;
import com.hello.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // TODO Auto-generated method stub
        return new ModelView("new-form");
    }
    
}
