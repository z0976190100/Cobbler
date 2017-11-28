package com.daProject.dao;

import com.daProject.dao.entity.TechRoute;
import java.sql.SQLException;
import java.util.List;

public interface TechRouteDAO {

    void saveTechRoute(TechRoute tr);
    String getOpsListByModelArt(String modelArt);
    List<TechRoute> getAllTechRoutsArticles() throws SQLException;
}
