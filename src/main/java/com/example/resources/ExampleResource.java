/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.resources;


import com.example.entity.Example;
import com.example.resources.auth.AuthenticationEndpoint;
import com.example.resources.auth.Secured;
import com.example.service.ExampleService;
import java.security.Principal;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author xiangweiwang
 */
@Component
@Path("/example")
public class ExampleResource {
    
    private static Logger logger = Logger.getLogger(ExampleResource.class);
    @Autowired ExampleService exampleService;
      
    @GET
    @Produces("text/html")
    public String hello() {
        return "<html><body>Hello GSPro<br><form method=post><input type=submit name=Create></form></body></html>";
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/json")
    @Secured
    public Example exampleAsJson(@Context SecurityContext securityContext) {
        logger.info(securityContext.getUserPrincipal().getName());
        return new Example();
    }
    
    @POST
    @Produces("text/plain")
    public String save() {
        return "Hello " + exampleService.getName();
    }
}
