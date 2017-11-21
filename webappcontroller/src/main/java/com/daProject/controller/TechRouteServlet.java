package com.daProject.controller;

import com.daProject.manager.executable.TechRouteManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
        JSONObject responseJSON = new JSONObject();
        String target = request.getParameter("requestType");

        switch (target) {

            case "getTechRouteByModel":
            String modelArt = request.getParameter("article");
            String result = trm.getOpsList(modelArt);
            responseJSON.put("operation_list", result);
            break;

            case "getAllTechRoutsArticles":
                Map<String, String> gotcha = trm.getAllTechRoutsArticles();
                for (String key : gotcha.keySet()) {
                    responseJSON.put(key, gotcha.get(key));
                }


        }
        return responseJSON;
    }

}
