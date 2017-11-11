package com.daProject.dao.hibernateFactory;


import com.daProject.dao.impl.UserDAOImpl;
import com.daProject.dao.impl.ValiDataDAOImpl;
import com.daProject.dao.UserDAO;
import com.daProject.dao.ValiDataDAO;

public class Factory {

    private static UserDAO userDAO = null;
    private static ValiDataDAO valiDataDAO = null;

    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }


    public ValiDataDAO getValiDataDAO() {
        if (valiDataDAO == null) {
            valiDataDAO = new ValiDataDAOImpl();
        }
        return valiDataDAO;
    }
}


