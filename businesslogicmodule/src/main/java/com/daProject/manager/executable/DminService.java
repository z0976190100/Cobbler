package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.impl.UserDAOImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DminService {

    protected UserDAOImpl user = new UserDAOImpl();

    public Map<String, String> getAllUsers() {

        List<User> alUsers = new ArrayList<>();
        Map<String, String> allUsers = new HashMap<>();

        try {
            alUsers = user.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (User userr : alUsers) {
            allUsers.put(String.valueOf(userr.getId()), userr.getSurName());
        }

        return allUsers;
    }


    public void destroyUser(long userIdTD) {

        User userTD = user.getUserById(userIdTD);
        user.deleteUser(userTD);

    }

}
