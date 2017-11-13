package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegistrationManager {

    public static void registrationAct(HttpServletRequest request) throws SQLException {
// data: {requestType: "registration","name":$name,"surname":$surname,"phonenumber":$phonenumber,"secret":$secret},

        User userToAct = new User();
        userToAct.setPhoneNumber(request.getParameter("phonenumber"));
        userToAct.setPassword(request.getParameter("secret"));
        userToAct.setFirstName(request.getParameter("name"));
        userToAct.setSurName(request.getParameter("surname"));
        Factory.getInstance().getUserDAO().addUser(userToAct);


    }

}
