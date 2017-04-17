package com.wd.controllers;

import com.wd.untils.getRemortIpUntil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aaa on 2017/4/11.
 */
@Controller
@RequestMapping("/getRemortIp")
public class getRemotIp {

    @ResponseBody
    @RequestMapping("/getRemortIpFun")
    public String getRemortIpFun(HttpServletRequest request, HttpServletResponse response) {
        return getRemortIpUntil.getRemortIpFun(request);
    }
}
