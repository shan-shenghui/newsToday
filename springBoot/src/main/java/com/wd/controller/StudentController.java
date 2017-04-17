package com.wd.controller;

import com.wd.domain.Student;
import com.wd.services.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aaa on 2017/4/14.
 */
@RestController
@RequestMapping("studentController")
public class StudentController {
    private final static Log logging = LogFactory.getLog(StudentController.class);
    @Autowired
    private StudentService studentService;

    @RequestMapping("/getStu")
    public List getStu() {
        logging.info("从数据库读取Student集合");
        return studentService.getList();
    }

    @RequestMapping("/insertTo")
    public void insertTo() {
        logging.info("从数据库插入Student数据");
        studentService.insertTo();
    }

    @RequestMapping("/deleteMs")
    public void deleteMs() {
        logging.info("从数据库删除Student数据");
        studentService.deleteMs();
    }
}
