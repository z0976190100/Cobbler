package com.daProject.dao.impl;

import com.daProject.dao.Enteties;
import com.daProject.dao.General;
import com.daProject.dao.GeneralInter;
import com.daProject.dao.entity.WSStateKeeper;
import com.daProject.dao.hibernateFactory.Factory;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;

import java.sql.SQLException;


public class WSStateKeeperImpl implements GeneralInter {


  /*  public static void main(String[] arrgh) {
        WSStateKeeper hhh = new WSStateKeeper();
        try {
            Factory.getInstance().getGeneralInter().saveSmth(hhh);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }*/


    @Override
    public void saveSmth(Enteties shitToSave) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(shitToSave);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }

    }

    @Override
    public Enteties getT(Enteties enteties) throws SQLException {
        return null;
    }

    @Override
    public long getSmthByAnyting(General field) throws SQLException {
        return 0;
    }

    @Override
    public String getFieldByFlag(Enteties entity, String field, String flag, String param) throws SQLException {
        return null;
    }
}
