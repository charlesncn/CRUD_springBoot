package com.cn.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue

    private int id;

    private String Name;
    private String Email;
    private String Password;
    
}
