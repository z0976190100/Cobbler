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


public class UserDAOImpl implements UserDAO {
        @Override
        public void addUser(User user) throws SQLException {
            Session session = null;
            try {
                session = HibernateSessionFactory.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(user);
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
        public void updateUser(User user) {
            try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                //MUST be dan
            }
        }


        @Override
        public User getUserBySurame(String surname) {
            User user = null;
            try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
                Query query = session.createQuery("FROM User WHERE surName =:paramName");
                query.setParameter("paramName", surname);
                user = (User) query.uniqueResult();
            } catch (Exception e) {
                e.printStackTrace();
                //MUST be dan
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
                //MUST be dan
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


