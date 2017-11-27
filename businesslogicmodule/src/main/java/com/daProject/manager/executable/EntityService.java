package com.daProject.manager.executable;

//import com.daProject.dao.entity.TOpsTRouts;

import com.daProject.dao.entity.TechRoute;
import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;

import javax.servlet.http.Cookie;
import java.sql.SQLException;


public class EntityService {



    static boolean DBfillerStatus = false;

    public static boolean dataBaseFiller() throws SQLException {

        if (DBfillerStatus) return DBfillerStatus;

        User dmin = new User();
        dmin.setFirstName("Сергей");
        dmin.setPhoneNumber("+380976190100");
        dmin.setPassword("zhst");
        dmin.setRole("admin");

        Factory.getInstance().getUserDAO().saveUser(dmin);

        /*String tOpsGen = "Набивка стельки," +
                "Набивка верха," +
                "Шнуровка," +
                "ЗНК," +
                "Намазка стельки," +
                "Геленок," +
                "ЗПК," +
                "Выемка гвоздей," +
                "Доводка на фене," +
                "Обрезка фалд," +
                "Разметка-Взьерошивание," +
                "Протравка подошвы," +
                "Промазка подошвы," +
                "Приклейка подошвы";
        int count = 1;

        String[] res = tOpsGen.split(",");
        for (String str : res) {
            TechOperationGeneral tog = new TechOperationGeneral(str, BigInteger.valueOf(13l));
            Factory.getInstance().getTechOperationGeneralDAO().addTechOperation(tog);
        }

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
        count = 1;
        res = tOpsGen.split(",");
        for (String str : res) {

            TechOperationGeneral tog = Factory.getInstance().getTechOperationGeneralDAO().getTOGByTitle(str);
            TechRoute tr = new TechRoute(2, "857", tog, ++count);
           // tog.addTr(tr);
            Factory.getInstance().getTechRouteDAO().saveTechRoute(tr);
        }
        ArrayList<String> ops = new ArrayList<>();
        ops.add("");
        tOpsGen = "Набивка стельки," +
                "Набивка верха," +
                "ЗНК," +
                "Намазка стельки," +
                "Геленок," +
                "ЗПК," +
                "Выемка гвоздей," +
                "Обрезка фалд," +
                "Разметка-Взьерошивание," +
                "Промазка подошвы," +
                "Приклейка подошвы";
        count = 1;
        res = tOpsGen.split(",");
        for (String str : res) {

            TechOperationGeneral tog = Factory.getInstance().getTechOperationGeneralDAO().getTOGByTitle(str);
            TechRoute tr = new TechRoute(1, "444 ", tog, ++count);
            //tog.addTr(tr);
            Factory.getInstance().getTechRouteDAO().saveTechRoute(tr);

        }
*/
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


        DBfillerStatus = true;
        System.out.println("DB filling proccess is done " + DBfillerStatus);

        return DBfillerStatus;
    }
}
