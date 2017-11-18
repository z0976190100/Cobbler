/*
package com.daProject.dao.impl;

import com.daProject.dao.TOpsTRoutsDAO;
import com.daProject.dao.entity.TOpsTRouts;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;

public class TOpsTRoutsDAOImpl implements TOpsTRoutsDAO {
    @Override
    public void addTOpsTRouts(TOpsTRouts totr) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(totr);
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
*/
