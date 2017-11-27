package com.daProject.dao.hibernateFactory;


import com.daProject.dao.*;
import com.daProject.dao.entity.TechOperationGeneral;
import com.daProject.dao.impl.*;

public class Factory {

    private static UserDAO userDAO = null;
    private static ValiDataDAO valiDataDAO = null;
    private static TechOperationGeneralDAO tODAO = null;
    private static TechRouteDAO tRDAO = null;
   // private static TOpsTRoutsDAO totsDAO = null;
    private static Factory instance = null;
    private static WorkSheetDAO workSheetDAO = null;

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

    public TechOperationGeneralDAO getTechOperationGeneralDAO() {
        if (tODAO == null) {
            tODAO = new TechOperationGeneralDAOImpl();
        }
        return tODAO;
    }

    public TechRouteDAO getTechRouteDAO() {
        if (tRDAO == null) {
            tRDAO = new TechRouteDAOImpl();
        }
        return tRDAO;
    }

/*
    public TOpsTRoutsDAO getTOpsTRoutsDAO() {
        if (totsDAO == null) {
            totsDAO = new TOpsTRoutsDAOImpl();
        }
        return totsDAO;
    }

*/
public WorkSheetDAO getWorkSheetDAO(){
    if(workSheetDAO == null){
        workSheetDAO =new WorkSheetDAOImpl();
        }
        return workSheetDAO;
    }




    public ValiDataDAO getValiDataDAO() {
        if (valiDataDAO == null) {
            valiDataDAO = new ValiDataDAOImpl();
        }
        return valiDataDAO;
    }
}


