/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.entity.AccessToken;
import com.example.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author xiangweiwang
 */
public interface UserService extends UserDetailsService {
    AccessToken createAccessToken(User user);
    
    AccessToken findToken(String token);
}
