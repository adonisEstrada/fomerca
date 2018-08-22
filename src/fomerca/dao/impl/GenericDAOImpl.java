/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import fomerca.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Adonis
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    Session session;
    Transaction transaction;
    SessionFactory sessionFactory;

    public GenericDAOImpl() {
        if (session == null) {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
        } else {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
        }
    }

    @Override
    public void save(T t) {
        transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
    }

}
