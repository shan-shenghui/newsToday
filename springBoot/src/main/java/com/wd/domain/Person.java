package com.wd.domain;

import java.io.Serializable;

/**
 * Created by aaa on 2017/4/13.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 1129427762696330158L;
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
