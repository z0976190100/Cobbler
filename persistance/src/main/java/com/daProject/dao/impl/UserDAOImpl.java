package com.daProject.dao.impl;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.HibernateSessionFactory;
import com.daProject.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.SQLException;


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
        public User getUserByFirstName(String name) {
            User user = null;
            try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
                Query query = session.createQuery("FROM User WHERE firstName =:paramName");
                query.setParameter("paramName", name);
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

    }


