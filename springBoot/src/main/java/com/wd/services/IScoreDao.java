package com.wd.services;

import com.wd.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aaa on 2017/4/14.
 */
public interface IScoreDao extends JpaRepository<Score, Integer> {

    //修改、新增、删除操作，则必须要在接口上面或者对应的方法上面添加 @Transactional 注解，否则会抛出异常。
    @Transactional
    @Modifying
    @Query(value = "update Score  set score = ?1 where id = ?2", nativeQuery = true)
    int updateScore(int score, int id);

    @Modifying
    @Query(value = "select t.* from Score t ", nativeQuery = true)
    List<Score> getList();

    @Transactional
    @Query(value = "insert into Score(id,score) value(?1,?2)", nativeQuery = true)
    @Modifying
    void insertOrder(int id, int score);
}
