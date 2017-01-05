/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.entity.Example;

/**
 *
 * @author xiangweiwang
 */
public interface ExampleService {
    void createEntity(Example example);
    
    String getName();
}
