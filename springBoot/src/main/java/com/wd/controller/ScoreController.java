package com.wd.controller;

import com.wd.domain.Score;
import com.wd.services.IScoreDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scoreController")
public class ScoreController {
    private static final Log log = LogFactory.getLog(ScoreController.class);
    @Autowired
    private IScoreDao score;

    @RequestMapping("/updata")
    public void FromJPA() {
        log.info("更新数据库数据");
        log.info("更新数据库数据行数" + score.updateScore(99, 1));
        score.updateScore(99, 1);
    }

    @RequestMapping("/getData")
    public List<Score> getData() {
        log.info("查询数据库" + score.getList());
        return score.getList();
    }

}
