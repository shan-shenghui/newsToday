package com.wd.services;


import com.wd.model.LoginEntity;
import com.wonders.hs.pd.basic.service.GenericService;

/**
 * Created by aaa on 2017/4/8.
 */
public interface LoginService extends GenericService{
    String handleLogin(String userMess);
    String userSign(String userName,String passwd,String phoneCode);
}
