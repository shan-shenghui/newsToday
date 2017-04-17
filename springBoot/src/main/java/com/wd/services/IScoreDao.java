package com.wd.services;

import com.wd.domain.Score;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aaa on 2017/4/14.
 */
public interface IScoreDao extends CrudRepository<Score, Integer> {
    @Transactional
    //修改、新增、删除操作，则必须要在接口上面或者对应的方法上面添加 @Transactional 注解，否则会抛出异常。
    @Modifying
    @Query("update Score t set t.score = :score where t.id = :id")
    int updateScore(@Param("score") int score, @Param("id") int id);

    @Query("select t from Score t ")
    List<Score> getList();
}
