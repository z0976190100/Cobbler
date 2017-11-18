package com.daProject.dao.impl;

import com.daProject.dao.TechOperationGeneralDAO;
import com.daProject.dao.entity.TechOperationGeneral;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;

public class TechOperationGeneralDAOImpl implements TechOperationGeneralDAO {

    @Override
    public void addTechOperation(TechOperationGeneral to) throws SQLException {

            Session session = null;
            try {
                session = HibernateSessionFactory.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(to);
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
    public TechOperationGeneral getTOGByTitle(String title) throws SQLException {
        TechOperationGeneral tog = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM TechOperationGeneral WHERE title =:paramName");
            query.setParameter("paramName", title);
            tog = (TechOperationGeneral) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            //MUST be dan
        }
        return tog;
    }
}

