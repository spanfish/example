/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author xiangwei.wang@dji.com
 */
@Entity
@Data
@EqualsAndHashCode(of = {"uuid"})
public class Mission implements Serializable {

    @Id
    private String uuid;

    @OneToOne
    @JoinColumn(name="uuid")
    private MissionParameter parameter;
    
    @Column
    private String name;

    @Column
    private int type;

    @Column
    private int flightType;

    @Column
    private int pointMode;

    @Column
    private double startLatitude;

    @Column
    private double startLongitude;
    
    @Column
    private double mapMinLongitude;
    
    @Column
    private double mapMaxLatitude;
    
    @Column
    private double mapMaxLongitude;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Column
    private int deleteFlag;
    
    @Version
    private int version;

}
