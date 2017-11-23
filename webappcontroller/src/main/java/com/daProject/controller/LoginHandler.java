package com.daProject.controller;

import com.daProject.manager.executable.LoginService;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class LoginHandler extends APIHandlerServlet.APIRequestHandler {

    public static final LoginHandler instance = new LoginHandler();

    public static LoginHandler getInstance() {
        return instance;
    }

    private LoginHandler() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) {
        LoginService loginService = new LoginService();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = loginService.loginController(request);
        }catch(Exception e){
            e.printStackTrace();
        }

        return jsonObject;
    }
}
