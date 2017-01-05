/*
 * Copyright © 2016, DJI. All rights reserved.
 * 
 * Author: xiangwei.wang@dji.com
 */
package com.example.resources;

import com.example.entity.Mission;
import com.example.service.MissionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author xiangwei.wang@dji.com
 */

@Component
@Path("/mission")
public class MissionResource {
    private static Logger logger = Logger.getLogger(MissionResource.class);
    
    @Autowired
    private MissionService missionService;
    
    @Path("{uuid}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response loadMission(@Context SecurityContext securityContext, @PathParam("uuid") String uuid) {
        logger.info("load mission:" + uuid);
        Mission mission = missionService.findMissionById(uuid);
        return Response.ok(mission).build();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes("application/x-www-form-urlencoded")
    public Response saveMission(@Context SecurityContext securityContext, @PathParam("uuid") String uuid) {
        logger.info("load mission:" + uuid);
        Mission mission = missionService.findMissionById(uuid);
        return Response.ok(mission).build();
    }
}
