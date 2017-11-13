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

        to1.setTitle("Glue");
        to1.setCost(BigInteger.valueOf(220l));
        to2.setTitle("Deglue");
        to2.setCost(BigInteger.valueOf(110l));
        to3.setTitle("Binding");
        to3.setCost(BigInteger.valueOf(800l));
        to4.setTitle("Clamping");
        to4.setCost(BigInteger.valueOf(100l));

        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to1);
        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to2);
        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to3);
        Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(to4);



        DBfillerStatus = true;
        System.out.println("DB filling proccess is done " + DBfillerStatus);

        return DBfillerStatus;
    }
}
