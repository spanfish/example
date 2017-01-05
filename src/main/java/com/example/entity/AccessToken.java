/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author xiangweiwang
 */

@Entity
public class AccessToken implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String token;

    //TODO
    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @Column
    private Date expiry;

    protected AccessToken() {
        /* Reflection instantiation */
    }

    public AccessToken(User user, String token) {
        this.user = user;
        this.token = token;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        this.expiry = calendar.getTime();
    }

    public AccessToken(User user, String token, Date expiry) {
        this(user, token);
        this.expiry = expiry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
