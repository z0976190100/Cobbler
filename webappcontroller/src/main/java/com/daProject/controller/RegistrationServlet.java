package com.daProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nataliya on 28.02.2017.
 */
public class RegistrationServlet extends APIHandlerServlet.APIRequestHandler {

    public static final RegistrationServlet instance = new RegistrationServlet();


    public static RegistrationServlet getInstance() {
        return instance;
    }

    private RegistrationServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       /* User user = new User();
        user.setEmail(email);
        user.setName(login);
        user.setPassword(password);
        Factory.getInstance().getUserDAO().addUser(user);
*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", login);
        System.out.println("login: " + login + "; email: " + email + "; password: " + password);
       //ObjectMapper mapper = new ObjectMapper();
       // JSONStreamAware lougin = mapper.readValue(tr, JSONStreamAware.class);
        return jsonObject;
    }
}