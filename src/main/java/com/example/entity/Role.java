/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author xiangweiwang
 */
public enum Role implements GrantedAuthority
{
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String authority;

    Role(String authority)
    {
        this.authority = authority;
    }

    @Override
    public String getAuthority()
    {
        return this.authority;
    }
}