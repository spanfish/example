/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.resources;

import com.example.entity.AccessToken;
import com.example.entity.User;
import com.example.service.UserService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author xiangweiwang
 */

@Component
@Path("/user")
public class UserResource {
    
    private static Logger logger = Logger.getLogger(UserResource.class);
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    
    @Path("authenticate")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public AccessToken authenticate(@FormParam("username") String username, @FormParam("password") String password) {
//        
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccessToken authenticate(@QueryParam("username") String username, @QueryParam("password") String password) {
        logger.debug("authenticate username:" + username + ", password:" + password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            throw new WebApplicationException(401);
        }
        logger.info("authenticate succeed");
       
        AccessToken token = this.userService.createAccessToken((User) principal);
        User user = (User) principal;
//        user.setToken(token.getToken());
        return token;
    }
}
