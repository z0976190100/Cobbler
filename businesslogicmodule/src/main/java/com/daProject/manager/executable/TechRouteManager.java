package com.daProject.manager.executable;

import com.daProject.dao.impl.TechRouteDAOImpl;

public class TechRouteManager {

    String opsList;

    public String getOpsList(String modelArt) {
        TechRouteDAOImpl trimp = new TechRouteDAOImpl();
        opsList = trimp.getOpsListByModelArt(modelArt);
        System.out.println("_____----------____------------- tech route for " + modelArt +
        " is " + opsList);
        return opsList;
    }
}
