package com.wd.controller;

import com.wd.domain.LoginEntity;
import com.wd.services.LoginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaa on 2017/4/17.
 */
@RestController
@RequestMapping("/loginController")
public class loginController {
    private static final Log log = LogFactory.getLog(loginController.class);

    @Autowired
    LoginService loginService;

    /*
    * 登陆
    * */
    @RequestMapping(value = "/login")
    public String handleLogin(String user, String password) {
        List<LoginEntity> result = loginService.handleLogin();
        Boolean userContain = false;
        for (LoginEntity entity : result) {
            if(user.equals(entity)){
                userContain = true;
            }else {
                return "";
            }
        }

        return "";
    }

    /*
   * 注册
   * */
    @RequestMapping(value = "/sign")
    public List userSign(String userName, String passwd, String phoneCode) {
        Integer result = loginService.userSign(userName, passwd, phoneCode);

        List list = new ArrayList();
        if (result == 1) {
            list.add("success");
            return list;
        } else {
            list.add("error");
            return list;
        }

    }

}
