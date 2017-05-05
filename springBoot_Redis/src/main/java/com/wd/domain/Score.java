package com.wd.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by aaa on 2017/4/14.
 */
@Entity
@Table(name = "Score")
public class Score implements Serializable {

    private static final long serialVersionUID = 7162462777388629715L;

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = true, name = "SCORE")
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
