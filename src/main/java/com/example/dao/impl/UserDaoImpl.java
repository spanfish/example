/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author xiangweiwang
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    @Override
    @Transactional(readOnly = true)
    public User findByName(String username) {
        logger.debug("find user by name:" + username);
        Criteria criteial = sessionFactory.getCurrentSession().createCriteria(User.class);
        
        List<User> users = criteial.list();
        if(users.isEmpty()) {
            logger.debug("no user found");
            return null;
        }
        logger.debug("User found");
        return users.get(0);
    }
}
