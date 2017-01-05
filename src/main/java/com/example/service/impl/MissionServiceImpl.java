/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.service.impl;

import com.example.dao.MissionDao;
import com.example.entity.Mission;
import com.example.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author xiangwei.wang@dji.com
 */
@Service("missionService")
public class MissionServiceImpl implements MissionService {

    @Autowired 
    private MissionDao missionDao;
    
    @Override
    public Mission findMissionById(String uuid) {
        return missionDao.findMissionById(uuid);
    }

    @Override
    public void save(Mission mission) {
        missionDao.save(mission);
    }
}
