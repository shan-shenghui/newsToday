package com.wd.services;

import com.wd.domain.LoginEntity;

import java.util.List;

/**
 * Created by aaa on 2017/4/18.
 */
public interface LoginService {
    List<LoginEntity> handleLogin();

    int userSign(String userName, String passwd, String phoneCode);
}
