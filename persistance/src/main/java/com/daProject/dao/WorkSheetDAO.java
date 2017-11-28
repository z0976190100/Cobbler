package com.daProject.dao;

import com.daProject.dao.entity.WorkSheet;

import java.sql.SQLException;

public interface WorkSheetDAO {

    void saveWorkSheet(WorkSheet workSheet) throws SQLException;
    WorkSheet getWSheetById(long id) throws SQLException;
    boolean getIsChekedByOpTagId(String operationTagId)throws SQLException;
    void updateIsChekedByOpTagId(String operationTagId, boolean state, long initiator)throws SQLException;

}
