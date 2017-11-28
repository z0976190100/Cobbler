package com.daProject.controller;

import com.daProject.controller.utils.JSON;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.daProject.controller.utils.JSONResponses.ERROR_INCORRECT_REQUEST;

public class APIHandlerServlet extends HttpServlet {

    public abstract static class APIRequestHandler {
        protected abstract JSONStreamAware processRequest(HttpServletRequest request) throws Exception;
    }

    private static Cookie roleIdentifier = new Cookie("roleIdentifier", "none");
    private static Map<String, APIRequestHandler> apiRequestHandlers = new HashMap<>();
    public static boolean multiplayer = false;

    static {
        Map<String, APIRequestHandler> map = new HashMap<>();

        map.put("dbInit", EntityHandler.getInstance());
        map.put("state", WorkSheetHandler.getInstance());
        map.put("auth", LoginHandler.getInstance());
        map.put("registration", RegistrationHandler.getInstance());
        map.put("getTechRouteByModel", TechRouteHandler.getInstance());
        map.put("getAllUsers", DminHandler.getInstance());
        map.put("destroyUser", DminHandler.getInstance());
        map.put("getAllTechRoutsArticles", TechRouteHandler.getInstance());

        apiRequestHandlers = Collections.unmodifiableMap(map);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private static Map<String, APIRequestHandler> getApiRequestHandlers() {
        return apiRequestHandlers;
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setDateHeader("Expires", 0);

        JSONStreamAware response = JSON.emptyJSON;

        try {
            long startTime = System.currentTimeMillis();
            String requestCase = req.getParameter("requestCase");

            if (requestCase == null) {
                response = ERROR_INCORRECT_REQUEST;
                return;
            }

            APIRequestHandler apiRequestHandler = getApiRequestHandlers().get(requestCase);

            if (apiRequestHandler == null) {
                response = ERROR_INCORRECT_REQUEST;
                return;
            }

            response = apiRequestHandler.processRequest(req);

            if (response instanceof JSONObject) {
                ((JSONObject) response).put("requestProcessingTime", System.currentTimeMillis() - startTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.setContentType("text/plain; charset=UTF-8");
            try (Writer writer = resp.getWriter()) {
                response.writeJSONString(writer);
            }
        }
    }
}
