package com.daProject.dao;

import java.sql.SQLException;

public abstract class General<T extends Enteties> {

    abstract void saveSmth(T shitTosave) throws SQLException;

    abstract T getT(T t) throws SQLException;

    abstract long getSmthByAnyting(General<? extends Object> field) throws SQLException;

    abstract String getFieldByFlag(T entity, String field, String flag, String param) throws SQLException;

}
