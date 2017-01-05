/*
 * 
 * Copyright © 2016, DJI. All rights reserved.
 * 
 */
package com.example.resources.auth;

import com.example.entity.AccessToken;
import com.example.entity.User;
import com.example.service.UserService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * 用户认证。
 * 客户端必需已POST方式提交username和password到Path指定的路径,该程序利用Spring Security
 * 来进行用户名,密码认证,如果认证通过,会返回Token给客户端,此后的请求可在header里包含此Token。
 * @author xiangwei.wang@dji.com
 */
@Path("/authentication")
public class AuthenticationEndpoint {

    private static Logger logger = Logger.getLogger(AuthenticationEndpoint.class);

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
//    @POST
//    @Produces("application/json")
//    @Consumes("application/x-www-form-urlencoded")
//    public Response authenticateUser(@FormParam("username") String username, 
//                                     @FormParam("password") String password) {
//        return null;
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(@QueryParam("username") String username,
            @QueryParam("password") String password) {
        logger.info("authenticateUser:" + username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        //SecurityContextHolder.getContext().setAuthentication(authentication);

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            throw new WebApplicationException(401);
        }
        logger.info("authenticate succeed");

        AccessToken token = this.userService.createAccessToken((User) principal);

        return Response.ok(token).build();
    }
}
