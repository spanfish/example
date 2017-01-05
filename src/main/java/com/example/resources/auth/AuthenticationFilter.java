/*
 * 
 * Copyright © 2016, DJI. All rights reserved.
 * 
 */
package com.example.resources.auth;

import com.example.entity.AccessToken;
import com.example.entity.Role;
import com.example.service.UserService;
import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author xiangwei.wang@dji.com
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    private static final Logger logger = Logger.getLogger(AuthenticationFilter.class);

    @Autowired
    private UserService userService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

//        String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));;
//  
//        //Split username and password tokens
//        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
//        final String username = tokenizer.nextToken();
//        final String password = tokenizer.nextToken();
        // Check if the HTTP Authorization header is present and formatted correctly 
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.error("UNAUTHORIZED");
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        //The client should send the token on the standard HTTP Authorization header of the request. For example:
        //Authorization: Bearer <token-goes-here>
        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();
        logger.debug("client token:" + token);

        final AccessToken accessToken = userService.findToken(token);
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.debug(accessToken == null ? "null" : "not null");

        //TODO: check token expiry
        if (accessToken == null || accessToken.getUser() == null) {
            logger.error("principal is not User");
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        requestContext.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                return new Principal() {

                    @Override
                    public String getName() {
                        return accessToken.getUser().getUsername();
                    }
                };
            }

            @Override
            public boolean isUserInRole(String roleName) {
                boolean userInRole = false;
                if (accessToken.getUser().getRoles() != null) {
                    for (Role role : accessToken.getUser().getRoles()) {
                        if (StringUtils.equals(role.getAuthority(), roleName)) {
                            userInRole = true;
                            break;
                        }
                    }
                }

                return userInRole;
            }

            @Override
            public boolean isSecure() {
                return true;
            }

            @Override
            public String getAuthenticationScheme() {
                return "";
            }
        });
    }
}
