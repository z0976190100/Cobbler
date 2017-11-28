package com.daProject.manager.executable;


import com.daProject.dao.entity.TechRoute;
import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;

import java.sql.SQLException;


public class DBInitService {



   private static boolean DBinitialisationStatus = false;

    public static boolean dataBaseInitialise() throws SQLException {

        if (DBinitialisationStatus) return DBinitialisationStatus;

        User dmin = new User();
        dmin.setFirstName("Сергей");
        dmin.setSurName("Бурцев");
        dmin.setPhoneNumber("+380976190100");
        dmin.setPassword("zhst");
        dmin.setRole("admin");

        Factory.getInstance().getUserDAO().saveUser(dmin);

        String tOpsGen;
        TechRoute tr = new TechRoute();
        TechRoute tr2 = new TechRoute();
        TechRoute tr3 = new TechRoute();
        TechRoute tr4 = new TechRoute();
        tOpsGen = "Набивка стельки," +
                "Набивка верха," +
                "ЗНК," +
                "Намазка стельки," +
                "Геленок," +
                "ЗПК," +
                "Выемка гвоздей," +
                "Доводка на фене," +
                "Обрезка фалд," +
                "Разметка," +
                "Взьерошивание," +
                "Промазка подошвы," +
                "Приклейка подошвы";


        tr.setModelArt("857");
        tr.setOpsList(tOpsGen);

        tOpsGen = "Набивка стельки," +
                "Набивка верха," +
                "ЗНК," +
                "Намазка стельки," +
                "Геленок," +
                "ЗПК," +
                "Выемка гвоздей," +
                "Доводка на фене," +
                "Обрезка фалд," +
                "Разметка-Взьерошивание," +
                "Промазка подошвы," +
                "Приклейка подошвы";
        tr2.setModelArt("444");
        tr2.setOpsList(tOpsGen);
        tr3.setModelArt("444-1");
        tr3.setOpsList(tOpsGen);
        tr4.setModelArt("488");
        tr4.setOpsList(tOpsGen);
        Factory.getInstance().getTechRouteDAO().saveTechRoute(tr);
        Factory.getInstance().getTechRouteDAO().saveTechRoute(tr2);
        Factory.getInstance().getTechRouteDAO().saveTechRoute(tr3);
        Factory.getInstance().getTechRouteDAO().saveTechRoute(tr4);


        DBinitialisationStatus = true;
        System.out.println("DB filling proccess is done " + DBinitialisationStatus);

        return DBinitialisationStatus;
    }
}
