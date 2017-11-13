package com.daProject.dao;

import com.daProject.dao.entity.TechOperationGeneral;

import java.sql.SQLException;

public interface TechOperationGeneralDAO {

    void addTechOperation(TechOperationGeneral to) throws SQLException;
}
