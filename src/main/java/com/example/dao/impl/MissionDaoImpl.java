/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.dao.impl;

import com.example.dao.MissionDao;
import com.example.entity.Mission;
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
 * @author xiangwei.wang@dji.com
 */
@Repository("missionDao")
public class MissionDaoImpl implements MissionDao {

    private static Logger logger = Logger.getLogger(MissionDaoImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional(readOnly = true)
    @Override
    public Mission findMissionById(String uuid) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Mission.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        List<Mission> missions = criteria.list();
        return missions.isEmpty() ? null : missions.get(0);
    }

    @Transactional
    @Override
    public void save(Mission mission) {
        this.sessionFactory.getCurrentSession().save(mission);
    }

}
