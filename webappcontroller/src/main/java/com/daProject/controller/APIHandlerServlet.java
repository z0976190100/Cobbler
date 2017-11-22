package com.daProject.controller;

import com.daProject.controller.utils.EntityHandler;
import com.daProject.controller.utils.JSON;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.daProject.controller.utils.JSONResponses.ERROR_INCORRECT_REQUEST;
import static com.daProject.manager.executable.EntityManager.dataBaseFiller;
import static com.daProject.manager.executable.EntityManager.roleIdentifier;

/**
 * Created by Nataliya on 28.02.2017.
 */
public class APIHandlerServlet extends HttpServlet {
    public abstract static class APIRequestHandler {

        protected abstract JSONStreamAware processRequest(HttpServletRequest request) throws Exception;

    }



  private static Map<String, APIRequestHandler> apiRequestHandlers = new HashMap<>();

    static {
        Map<String, APIRequestHandler> map = new HashMap<>();

        map.put("dbInit", EntityHandler.getInstance());
        map.put("login", LoginServlet.getInstance());
        map.put("registration", RegistrationServlet.getInstance());
        map.put("getTechRouteByModel", TechRouteServlet.getInstance());
        map.put("getAllUsers", DminHandler.getInstance());
        map.put("destroyUser", DminHandler.getInstance());
        map.put("getAllTechRoutsArticles", TechRouteServlet.getInstance());

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


    public static Map<String, APIRequestHandler> getApiRequestHandlers() {
        return apiRequestHandlers;
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setDateHeader("Expires", 0);

        JSONStreamAware response = JSON.emptyJSON;

        HttpSession session = req.getSession();

       Cookie[] cookies = req.getCookies();
        for (Cookie cook : cookies
             ) {
            System.out.println(cook.getName());
        }





        try {
            long startTime = System.currentTimeMillis();
            String requestType = req.getParameter("requestType");
            System.out.println("get request");

            if (requestType == null) {
                response = ERROR_INCORRECT_REQUEST;
                return;
            }

            APIRequestHandler apiRequestHandler = getApiRequestHandlers().get(requestType);

            if (apiRequestHandler == null) {
                response = ERROR_INCORRECT_REQUEST;
                return ;
            }

            System.out.println("Get servlet process");
            response = apiRequestHandler.processRequest(req);
            if (response instanceof JSONObject) {
                ((JSONObject) response).put("requestProcessingTime", System.currentTimeMillis() - startTime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.addCookie(roleIdentifier);
            resp.setContentType("text/plain; charset=UTF-8");
            try (Writer writer = resp.getWriter()) {
                response.writeJSONString(writer);//.append((CharSequence)((JSONObject) response).get("operation_list")));
            }
        }

    }

}
