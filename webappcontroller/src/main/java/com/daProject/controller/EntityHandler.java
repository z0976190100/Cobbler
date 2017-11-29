package com.daProject.controller;

import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static com.daProject.manager.executable.DBInitService.dataBaseInitialise;

public class EntityHandler extends APIHandlerServlet.APIRequestHandler {

    public static final EntityHandler instance = new EntityHandler();

    public static EntityHandler getInstance() {
        return instance;
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {

       /* try {
            dataBaseInitialise();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("init", "success");

        return responseJSON;
    }
}
