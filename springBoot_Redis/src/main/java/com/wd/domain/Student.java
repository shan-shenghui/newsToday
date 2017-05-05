package com.wd.domain;

import java.io.Serializable;

/**
 * Created by aaa on 2017/4/14.
 * <p>
 * 实体类 Student
 */

public class Student implements Serializable {

    private static final long serialVersionUID = -5985059937012700250L;

    private int id;
    private String name;
    private String sumScore;
    private String avgScore;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSumScore() {
        return sumScore;
    }

    public void setSumScore(String sumScore) {
        this.sumScore = sumScore;
    }

    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
