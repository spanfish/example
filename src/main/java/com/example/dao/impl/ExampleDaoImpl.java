/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao.impl;

import com.example.dao.ExampleDao;
import com.example.entity.Example;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author xiangweiwang
 */
@Repository("exampleDao")
public class ExampleDaoImpl implements ExampleDao {

    private static Logger logger = Logger.getLogger(ExampleDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    @Override
    @Transactional
    public void createEntity(Example example) {
        logger.info("createEntity");
        example.setDesc("abcdef");
        this.sessionFactory.getCurrentSession().save(example);
    }
}
