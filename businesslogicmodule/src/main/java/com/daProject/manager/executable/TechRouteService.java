package com.daProject.manager.executable;

import com.daProject.dao.entity.TechRoute;
import com.daProject.dao.impl.TechRouteDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechRouteService {

    String opsList;
    TechRouteDAOImpl trimp = new TechRouteDAOImpl();

    public String getOpsList(String modelArt) {

        opsList = trimp.getOpsListByModelArt(modelArt);
        System.out.println("_____----------____------------- tech route for " + modelArt +
        " is " + opsList);
        return opsList;
    }

    public Map<String, String> getAllTechRoutsArticles(){

            List<TechRoute> alArts = new ArrayList<>();
            Map<String, String> allArts = new HashMap<>();

            try {
                alArts = trimp.getAllTechRoutsArticles();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (TechRoute trr : alArts) {
                allArts.put(String.valueOf(trr.getId()), trr.getModelArt());
            }

        return allArts;
    }
}
