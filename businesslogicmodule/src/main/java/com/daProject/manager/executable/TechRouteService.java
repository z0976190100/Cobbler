package com.daProject.manager.executable;

import com.daProject.dao.entity.TechRoute;
import com.daProject.dao.impl.TechRouteDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechRouteService {

    private TechRouteDAOImpl trimp = new TechRouteDAOImpl();

    public String getOpsList(String modelArt) {

        String opsList;
        opsList = trimp.getOpsListByModelArt(modelArt);
        return opsList;
    }

    public Map<String, String> getAllTechRoutsArticles() {

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
