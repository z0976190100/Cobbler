package com.daProject.dao.impl;

import com.daProject.dao.TechOperationGeneralDAO;
import com.daProject.dao.entity.TechOperationGeneral;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;

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

    }

