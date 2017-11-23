package com.daProject.dao;

import com.daProject.dao.entity.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDAO {
         void addUser(User user) throws SQLException;
         void updateUser(User user) throws SQLException;
         User getUserByPhonenumber(String pn) throws SQLException;
         void deleteUser(User user) throws SQLException;
         Long getUserIdBySurname(String surname) throws SQLException;
         User getUserById(long id)throws SQLException;
         List<User> getAllUsers() throws SQLException;
         String getRoleByFlag(User user, String flag, String param) throws SQLException;
    }

