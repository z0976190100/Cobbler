package com.daProject.controller;

import com.daProject.manager.executable.TechRouteManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class TechRouteServlet extends APIHandlerServlet.APIRequestHandler {
    public static final TechRouteServlet instance = new TechRouteServlet();
    public static TechRouteServlet getInstance() {
        return instance;
    }

    private TechRouteServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        TechRouteManager trm = new TechRouteManager();
        String modelArt = request.getParameter("article");
        String result = trm.getOpsList(modelArt);
        JSONObject respJSON = new JSONObject();
        respJSON.put("operation_list", result);
        return respJSON;
    }

}
