package com.daProject.dao;

import com.daProject.dao.entity.User;

import java.sql.SQLException;



    public interface UserDAO {
        public void addUser(User user) throws SQLException;
        public void updateUser(User user) throws SQLException;
        public User getUserByFirstName(String name) throws SQLException;
        public void deleteUser(User user) throws SQLException;
        public Long getUserIdByFirstName(String name) throws SQLException;
        public User getUserById(long id)throws SQLException;
    }

