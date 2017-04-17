package com.wd.controllers;

import com.wd.model.LoginEntity;
import com.wd.services.LoginService;
import com.wd.untils.createUUIdUntil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ssh
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {
    private static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    /*
    * 登陆
    * */
    @ResponseBody
    @RequestMapping(value = "/login")
    public String handleLogin(String user,String password) {
        String result = loginService.handleLogin(user);
        return result;
    }

    /*
    * 注册
    * */
    @ResponseBody
    @RequestMapping(value = "/userSign")
    public String userSign(String userName,String passwd, String phoneCode) {
        String result = loginService.userSign(userName,passwd,phoneCode);
        return result;
    }
}
