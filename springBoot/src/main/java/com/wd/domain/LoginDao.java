package com.wd.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aaa on 2017/4/17.
 */
public interface LoginDao extends JpaRepository<LoginEntity, Integer> {
    @Modifying
    @Query(value = "select t.*  from Score t", nativeQuery = true)
    List<LoginEntity> handleLogin();

    @Transactional
    @Modifying
    @Query(value = "insert into  userLogin (userId,userName,passWord,phoneCode) values (?1,?2,?3,?4) ", nativeQuery = true)
    int userSign(String userId, String userName, String passWord, String phoneCode);
}
