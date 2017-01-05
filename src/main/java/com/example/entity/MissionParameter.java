/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author xiangwei.wang@dji.com
 */
@Data
@Entity
public class MissionParameter implements Serializable {

    @Id
    private String missionId;
    
    @Column
    private double speed;
    
    @Column
    private double altitude;
 
    @Column
    private int headingAction;
    
    @Column
    private int finishAction;
    
    @Column
    private int cameraHeading;
    
    @Column
    private int cameraModel;
    
    @Column
    private int photoMode;
    
    @Column
    private double photoInterval;
    
    @Column
    private double pixel;
    
    @Column
    private double overlapFront;
    
    @Column
    private double overlapSide;
    
    @Column
    private int routeMode;
    
    @Column
    private double disFront;
    
    @Column
    private double disSide;
    
    @Column
    private double angle;
    
    @Column
    private double margin;
    
    @Column
    private double overlapUpDown;
    
    @Column
    private double overlapFrontBehind;
    
    @Column
    private double minAltitude;
    
    @Column
    private double maxAltitude;
    
    @Column
    private double goHomeAltitude;
}
