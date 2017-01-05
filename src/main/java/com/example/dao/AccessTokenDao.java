/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.entity.AccessToken;

/**
 *
 * @author xiangweiwang
 */
public interface AccessTokenDao {

    /**
     * 新生成用户token
     * @param token 
     */
    void save(AccessToken token);

    /**
     * 查找token
     * @param token
     * @return 
     */
    AccessToken findToken(String token);
}
