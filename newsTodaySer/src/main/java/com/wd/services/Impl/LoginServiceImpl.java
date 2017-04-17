package com.wd.services.Impl;

import com.wd.dao.LoginDao;
import com.wd.model.LoginEntity;
import com.wd.services.LoginService;
import com.wonders.hs.pd.basic.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by aaa on 2017/4/8.
 */
@Service
@Component("loginService")
public class LoginServiceImpl extends GenericServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    public String handleLogin(String userMess) {
        return loginDao.handleLogin(userMess);
    }

    public String userSign(String userName, String passwd, String phoneCode) {
        return loginDao.userSign(userName, passwd, phoneCode);
    }
}
