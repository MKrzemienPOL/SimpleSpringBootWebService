package com.springboot.lanceapp.utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String userrole;

    public Role(){
    }

    public Role(String username, String userRole){
        this.username = username;
        this.userrole = userRole;
    }
}
