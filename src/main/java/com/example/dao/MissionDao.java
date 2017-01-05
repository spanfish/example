/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.dao;

import com.example.entity.Mission;

/**
 *
 * @author xiangwei.wang@dji.com
 */
public interface MissionDao {
    Mission findMissionById(String uuid);
    
    void save(Mission mission);
}
