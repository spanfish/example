/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.service;

import com.example.entity.Mission;

/**
 *
 * @author xiangwei.wang@dji.com
 */
public interface MissionService {
    
    Mission findMissionById(String uuid);
    
    void save(Mission mission);
}
