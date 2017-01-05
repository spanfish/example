/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service.impl;

import com.example.dao.ExampleDao;
import com.example.entity.Example;
import com.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author xiangweiwang
 */

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    @Autowired private ExampleDao exampleDao;

    public void setExampleDao(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
    }
    
    @Override
    public void createEntity(Example example) {
        
    }
    
    @Override
    public String getName() {
        System.out.print("bbbbbbb");
        Example example = new Example();
        example.setDesc("hello dji");
        exampleDao.createEntity(example);
        System.out.print("aaaaaaaaaaaaaaaaaaa");
        return example.getDesc();
    }
}
