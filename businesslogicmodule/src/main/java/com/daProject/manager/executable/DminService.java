package com.daProject.manager.executable;

import com.daProject.dao.UserDAO;
import com.daProject.dao.entity.User;
import com.daProject.dao.impl.UserDAOImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DminService {

    public Map<String, String> getAllUsers(){

        UserDAOImpl user = new UserDAOImpl();
        List<User> alUsers = new ArrayList<>();
        Map<String, String> allUsers = new HashMap<>();

        try {
            alUsers = user.getAllUsers();
        }catch (SQLException e){
            e.printStackTrace();
        }

        for (User userr: alUsers) {
            allUsers.put(String.valueOf(userr.getId()), userr.getSurName());
        }

        return allUsers;
    }

}
