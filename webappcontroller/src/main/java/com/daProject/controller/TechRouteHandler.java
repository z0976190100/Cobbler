package com.daProject.controller;

import com.daProject.manager.executable.TechRouteService;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.daProject.controller.APIHandlerServlet.multiplayer;

public class TechRouteHandler extends APIHandlerServlet.APIRequestHandler {
    public static final TechRouteHandler instance = new TechRouteHandler();

    public static TechRouteHandler getInstance() {
        return instance;
    }

    private TechRouteHandler() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        TechRouteService trm = new TechRouteService();
        JSONObject responseJSON = new JSONObject();
        String target = request.getParameter("requestType");
        if (!multiplayer) multiplayer = true;

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
