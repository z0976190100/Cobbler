package com.daProject.dao.impl;

import com.daProject.dao.entity.ValiData;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import com.daProject.dao.ValiDataDAO;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;

public class ValiDataDAOImpl implements ValiDataDAO {


    @Override
    public void addValiData(ValiData valData) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(valData);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
            //MUST be dan
        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }


    }

    @Override
    public void updateValiData(ValiData valData) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(valData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //MUST be dan
        }finally {
            if (session != null & session.isOpen()){
                session.close();
            }
        }

    }

    @Override
    public void deleteValiData(ValiData valData) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(valData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public Long getIdByLogin(String login) throws SQLException {
        return null;
    }

    @Override
    public ValiData getLoginById(long id) throws SQLException {
        return null;
    }
}
