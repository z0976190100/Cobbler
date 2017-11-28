package com.daProject.controller;


import com.daProject.manager.executable.RegistrationService;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;


public class RegistrationHandler extends APIHandlerServlet.APIRequestHandler {

    public static final RegistrationHandler instance = new RegistrationHandler();
    public static RegistrationHandler getInstance() {
        return instance;
    }

    private RegistrationHandler() {}

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        RegistrationService registration = new RegistrationService();

        return registration.registrationAct(request);
    }
}