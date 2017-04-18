package com.wd.services.Impl;

import com.wd.domain.LoginDao;
import com.wd.domain.LoginEntity;
import com.wd.services.LoginService;
import com.wd.until.createUUIdUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aaa on 2017/4/17.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Override
    public List<LoginEntity> handleLogin() {
        return loginDao.handleLogin();
    }

    @Override
    public int userSign(String userName, String passwd, String phoneCode) {
        String uuid = createUUIdUntil.createUUid();
        return loginDao.userSign(uuid, userName, passwd, phoneCode);
    }
}
