/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service.impl;

import com.example.dao.AccessTokenDao;
import com.example.dao.UserDao;
import com.example.entity.AccessToken;
import com.example.entity.User;
import com.example.service.UserService;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author xiangweiwang
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AccessTokenDao accessTokenDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userDao.findByName(username);
        if(user == null) {
            throw new UsernameNotFoundException("no user fond for name:" + username);
        }
        return user;
    }

    @Override
    public AccessToken createAccessToken(User user) {
        AccessToken accessToken = new AccessToken(user, UUID.randomUUID().toString());
        this.accessTokenDao.save(accessToken);
        return accessToken;
    }

    @Override
    public AccessToken findToken(String token) {
        return accessTokenDao.findToken(token);
    }
}
