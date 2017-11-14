package com.daProject.manager.executable;

import com.daProject.dao.entity.TechOperationGeneral;

import com.daProject.dao.hibernateFactory.Factory;

import java.math.BigInteger;
import java.sql.SQLException;

public class EntityManager {

    static boolean DBfillerStatus = false;

    public static boolean dataBaseFiller() throws SQLException{

        if(DBfillerStatus) return DBfillerStatus;

        TechOperationGeneral to1 = new TechOperationGeneral();
        TechOperationGeneral to2 = new TechOperationGeneral();
        TechOperationGeneral to3 = new TechOperationGeneral();
        TechOperationGeneral to4 = new TechOperationGeneral();

        to1.setTitle("Приклейка");
        to1.setCost(BigInteger.valueOf(22l));
        to2.setTitle("Отклейка");
        to2.setCost(BigInteger.valueOf(11l));
        to3.setTitle("Затяжка");
        to3.setCost(BigInteger.valueOf(80l));
        to4.setTitle("Фен");
        to4.setCost(BigInteger.valueOf(10l));

        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to1);
        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to2);
        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to3);
        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to4);



        DBfillerStatus = true;
        System.out.println("DB filling proccess is done " + DBfillerStatus);

        return DBfillerStatus;
    }
}
