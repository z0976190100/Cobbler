package com.daProject.controller;


import com.daProject.manager.executable.RegistrationManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

import static com.daProject.dao.entity.Errors.multiplayerCheck;


public class RegistrationServlet extends APIHandlerServlet.APIRequestHandler {

    public static final RegistrationServlet instance = new RegistrationServlet();
    public static RegistrationServlet getInstance() {
        return instance;
    }

    private RegistrationServlet() {}

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        RegistrationManager registration = new RegistrationManager();
                                                                                    //  MULTIPLAYER COMBO
        /*JSONObject mpresponse = new JSONObject();
        String temp = request.getParameter("mp");
        if (temp.equals("get")) {
            System.out.println("_______ doing get ________________");
            mpresponse.put("mp", multiplayerCheck);
            System.out.println("sending____________" + mpresponse.get("mp"));

            return mpresponse;
        }
        //multiplaying checker
        multiplayerCheck = Boolean.parseBoolean(request.getParameter("mp"));
        System.out.println("+++++++++++++++++++++" + multiplayerCheck);
        System.out.println("________________________________________" + mpresponse.get("mp"));
*/
        return registration.registrationAct(request);
    }
}