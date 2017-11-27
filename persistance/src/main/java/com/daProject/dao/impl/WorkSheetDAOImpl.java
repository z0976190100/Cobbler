package com.daProject.dao.impl;

import com.daProject.dao.WorkSheetDAO;
import com.daProject.dao.entity.WorkSheet;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;

import static com.daProject.dao.entity.Errors.workSheetStringGlobalState;

public class WorkSheetDAOImpl implements WorkSheetDAO {

    @Override
    public void saveWorkSheet(WorkSheet workSheet) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(workSheet);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
            //MUST be dan
        } finally {
            if (session != null & session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public WorkSheet getWSheetById(long id) throws SQLException {
        WorkSheet ws = new WorkSheet();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM WorkSheet WHERE id =:paramId");
            query.setParameter("paramId", id);
            ws = (WorkSheet) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ws;
    }

    @Override
    public boolean getIsChekedByOpTagId(String operationTagId) {

       boolean result = workSheetStringGlobalState;
        WorkSheet wsTD = null;
        String hql = "FROM WorkSheet WHERE operationTagId =:clue";

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("clue", operationTagId);
            wsTD = (WorkSheet) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (wsTD.getChecked() != null)
                result = wsTD.getChecked();
        }catch (NullPointerException e){
            result = false  ;
        }
        return result;
    }

    @Override
    public void updateIsChekedByOpTagId(String operationTagId, boolean state, long initiator) throws SQLException {

    }
}
