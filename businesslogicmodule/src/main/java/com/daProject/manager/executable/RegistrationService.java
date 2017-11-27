package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;
import com.daProject.dao.impl.UserDAOImpl;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class RegistrationService {

    private boolean validationAct(HttpServletRequest request) throws SQLException {

        UserDAOImpl userDAOImpl = new UserDAOImpl();
        JSONObject validationResult = new JSONObject();
        boolean check = true;
        List<User> users = userDAOImpl.getAllUsers();

        for (User user : users) {

            if (user.getPhoneNumber().equals(request.getParameter("phonenumber"))) {
                validationResult.put("phonenumber", false);
                check = false;
            }
            if (user.getPassword().equals(request.getParameter("secret"))) {
                validationResult.put("secret", false);
                check = false;
            }

        }
        validationResult.put("phonenumber", true);
        validationResult.put("secret", true);


        return check;
    }


    public JSONObject registrationAct(HttpServletRequest request) throws SQLException {

        JSONObject registrationResponse = new JSONObject();
        registrationResponse.put("registration", "fail");

        if (validationAct(request)) {
            User userToAct = new User();
            userToAct.setPhoneNumber(request.getParameter("phonenumber"));
            userToAct.setPassword(request.getParameter("secret"));
            userToAct.setFirstName(request.getParameter("name"));
            userToAct.setSurName(request.getParameter("surname"));
            userToAct.setEmployment(request.getParameter("employment"));
            userToAct.setRole(request.getParameter("role"));
            Factory.getInstance().getUserDAO().saveUser(userToAct);
            registrationResponse.put("registration", "win");
        }
        return registrationResponse;
    }

}
