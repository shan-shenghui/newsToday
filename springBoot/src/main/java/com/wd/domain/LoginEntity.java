package com.wd.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ssh on 2017/4/8.
 */
@Entity
@Table(name = "userLogin")
public class LoginEntity implements Serializable {

    @Id
    @Column(name = "userId")
    public String userId;

    @Column(name = "userName")
    public String userName;

    @Column(name = "passWord")
    public String passWord;
    @Column(name = "phoneCode")
    public String phoneCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public LoginEntity() {

    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }

    public LoginEntity(String userId, String userName, String passWord, String phoneCode) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneCode = phoneCode;
    }
}
