package com.github.diseng.dao.impl;

import com.github.diseng.dao.UserDao;
import com.github.diseng.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dengqinglin on 14-4-4.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        return query.list();
    }

    @Override
    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
