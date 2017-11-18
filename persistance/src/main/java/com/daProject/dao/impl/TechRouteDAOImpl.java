package com.daProject.dao.impl;

import com.daProject.dao.entity.TechRoute;
import com.daProject.dao.TechRouteDAO;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

public class TechRouteDAOImpl implements TechRouteDAO {

    @Override
    public void saveTechRoute(TechRoute tr) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tr);
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
    public String getOpsListByModelArt(String modelArt) {
        TechRoute tr  = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery(" FROM TechRoute WHERE modelArt =:param");
            query.setParameter("param", modelArt);
            tr = (TechRoute) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tr.getOpsList();
    }
}
