package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class LoginService {

    public JSONObject loginController(HttpServletRequest request) throws Exception {

        JSONObject response = new JSONObject();
        User currentUser = null;
        String cause = request.getParameter("case");
        String phonenumber = request.getParameter("phonenumber");

        switch (cause) {
            case "login":

                String secret = request.getParameter("secret");


                try {
                    currentUser = Factory.getInstance().getUserDAO().getUserByPhonenumber(phonenumber);
                } catch (SQLException e) {
                    System.err.println("No DB connection");
                    e.printStackTrace();
                } finally {
                    if (currentUser != null) {
                        String tempPassword = currentUser.getPassword();
                        if (secret.equals(tempPassword)) {
                            response.put("auth", "win");
                            response.put("role", String.valueOf(currentUser.getRole()));
                            response.put("firstName", String.valueOf(currentUser.getFirstName()));

                            currentUser.setLogged(true);
                            Factory.getInstance().getUserDAO().updateUser(currentUser);

                            return response;
                        }
                    }
                }
            case "logout":
                try {
                    currentUser = Factory.getInstance().getUserDAO().getUserByPhonenumber(phonenumber);
                } catch (SQLException e) {
                    System.err.println("No DB connection");
                    e.printStackTrace();
                } finally {
                    if (currentUser != null) {

                        currentUser.setLogged(false);
                        Factory.getInstance().getUserDAO().updateUser(currentUser);
                        response.put("auth", "closed");
                        return response;
                    }
                }

        }

        response.put("auth", "fail");
        return response;
    }
}