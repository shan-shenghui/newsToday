package com.wd.controller;

import com.wd.domain.LoginEntity;
import com.wd.services.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//        if (result != "") {
//            log.info("登陆成功！");
//        } else {
//            log.info("登陆失败！");
//        }
        return "";
    }

    /*
   * 注册
   * */
    @RequestMapping(value = "/sign")
    public String userSign(String userName, String passwd, String phoneCode) {
        Integer result = loginService.userSign(userName, passwd, phoneCode);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }

    }

}
