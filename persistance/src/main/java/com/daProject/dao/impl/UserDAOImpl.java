package com.daProject.dao.impl;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import com.daProject.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.daProject.dao.entity.Errors.errorMessage;



public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error I/O", JOptionPane.ERROR_MESSAGE);
            //MUST be dan
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public User getUserByPhonenumber(String pn) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE phoneNumber =:paramName");
            query.setParameter("paramName", pn);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Long getUserIdByFirstName(String name) {
        Long idUser = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT id FROM User WHERE firstName =:paramName");
            query.setParameter("paramName", name);
            idUser = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idUser;
    }

    public User getUserById(long id) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE id =:paramId");
            query.setParameter("paramId", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String getRoleByFlag(User user, String flag, String param) throws SQLException {
        User userTD = null;
        String hql;
        switch (flag) {
            case "phoneNumber":
                errorMessage = "No such tel or user";
                hql = "FROM User WHERE phoneNumber =:clue";
                break;
            default:
                return null;
        }
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("clue", param);
            userTD = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userTD != null) {
            if (userTD.getRole() != null) return userTD.getRole();
        }

        return errorMessage;
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getUserIdBySurname(String surname) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from User");
            allUsers = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }
}


