package com.wd.dao;


import com.wonders.hs.pd.basic.dao.GenericDao;

/**
 * Created by aaa on 2017/4/8.
 */
public interface LoginDao extends GenericDao{
    String handleLogin(String userMess);
    String userSign(String userName, String passwd, String phoneCode);
}
