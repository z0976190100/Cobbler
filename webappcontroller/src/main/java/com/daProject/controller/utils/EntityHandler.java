package com.daProject.controller.utils;

import com.daProject.controller.APIHandlerServlet;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static com.daProject.manager.executable.EntityManager.dataBaseFiller;

public class EntityHandler extends APIHandlerServlet.APIRequestHandler {

    public static final EntityHandler instance = new EntityHandler();

    public static EntityHandler getInstance() {
        return instance;
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {

        try {
            dataBaseFiller();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("init", "success");

        return responseJSON;
    }
}
