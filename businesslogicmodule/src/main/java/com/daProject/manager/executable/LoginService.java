package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;


public class LoginService {

    public JSONObject loginController(HttpServletRequest request) throws Exception {
        JSONObject response = new JSONObject();
        String phonenumber = request.getParameter("phonenumber");
        String secret = request.getParameter("secret");
        User currentUser = null;
        try {
            currentUser = Factory.getInstance().getUserDAO().getUserByPhonenumber(phonenumber);
        } catch (SQLException e) {
            System.err.println("Enable to connect");
            e.printStackTrace();
        } finally {
            if (currentUser != null) {
                String tempPassword = currentUser.getPassword();
                if (secret.equals(tempPassword)) {
                    response.put("auth", "win");
                    response.put("role", String.valueOf(currentUser.getRole()));
                    return response;
                }
            }
        }
        response.put("auth", "fail");
        return response;
    }
}