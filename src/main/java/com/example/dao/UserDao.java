/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.entity.User;

/**
 *
 * @author xiangweiwang
 */
public interface UserDao {

    /**
     * 根据用户名查找用户.
     * @param username 用户名
     * @return 用户
     */
    User findByName(String username);
}
