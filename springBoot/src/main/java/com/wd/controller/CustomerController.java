package com.wd.controller;

import com.wd.domain.Person;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaa on 2017/4/13.
 * 返回的数据类型有 string model list map list<map></>
 *
 */
@RestController
@RequestMapping("customerController")
public class CustomerController {
    private final Logger log = Logger.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/showPerson")
    public
    @ResponseBody
    Person showPerson() {
        return new Person("levinzhang", "levinzhang1981@gmail.com");
    }

    @RequestMapping("info")
    public Map<String, String> getInfo(@RequestParam String name) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        log.info("日志输出测试 Info");
        log.debug("日志输出测试 debug");
        return map;
    }

    @RequestMapping("/list")
    public List<Map<String, String>> getList() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 1; i <= 5; i++) {
            map = new HashMap<>();
            map.put("name", "ssh-" + i);
            list.add(map);
        }
        return list;
    }
}
