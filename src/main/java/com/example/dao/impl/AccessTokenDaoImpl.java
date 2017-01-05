/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao.impl;

import com.example.dao.AccessTokenDao;
import com.example.entity.AccessToken;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author xiangweiwang
 */
@Repository("accessTokenDao")
public class AccessTokenDaoImpl implements AccessTokenDao {

    private static Logger logger = Logger.getLogger(AccessTokenDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    @Transactional(readOnly = true)
    @Override
    public void save(AccessToken token) {
        logger.info("createEntity");
        this.sessionFactory.getCurrentSession().save(token);
    }

    @Transactional
    @Override
    public AccessToken findToken(String token) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AccessToken.class);
        criteria.add(Restrictions.eq("token", token));
        List<AccessToken> tokens = criteria.list();
        return tokens.isEmpty() ? null : tokens.get(0);
    }
    
}
