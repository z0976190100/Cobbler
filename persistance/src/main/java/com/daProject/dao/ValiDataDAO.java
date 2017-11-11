package com.daProject.dao;

import com.daProject.dao.entity.ValiData;

import java.sql.SQLException;

public interface ValiDataDAO {



    public Long getIdByLogin(String login) throws SQLException;
    public ValiData getLoginById(long id)throws SQLException;


   public void addValiData(ValiData valData);
   public void updateValiData(ValiData valData);
    public void deleteValiData(ValiData valData);

}
