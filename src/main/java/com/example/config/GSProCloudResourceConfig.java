/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 *
 * @author xiangweiwang
 */
@ApplicationPath("resources")
public class GSProCloudResourceConfig extends ResourceConfig {
    public GSProCloudResourceConfig() {
        super.packages("com.example.resources");
        super.register(RequestContextFilter.class);
    }
}
