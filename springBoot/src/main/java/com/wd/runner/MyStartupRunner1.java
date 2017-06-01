package com.wd.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by aaa on 2017/4/14.
 * 服务启动加载一些数据
 * 实现接口CommandLineRunner
 */
@Component
@Order(value = 1)
public class MyStartupRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.print("加载一些数据1111111111111"+"\n");
    }
}
