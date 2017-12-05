package com.daProject.dao;

import java.sql.SQLException;

public interface GeneralInter <T extends Enteties>{

    void saveSmth(T shitToSave) throws SQLException;

    T getT(T t) throws SQLException;

    long getSmthByAnyting(General<? extends Object> field) throws SQLException;

    String getFieldByFlag(T entity, String field, String flag, String param) throws SQLException;


}
