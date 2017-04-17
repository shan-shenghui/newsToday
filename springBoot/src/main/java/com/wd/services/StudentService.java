package com.wd.services;

import com.wd.domain.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aaa on 2017/4/14.
 * <p>
 * Studeng Service
 */
@Service
public class StudentService {
    private static final Log log = LogFactory.getLog(StudentService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List getList() {   //查询
        /*
        * result2 、result 、注释掉的返回数据一样
        *
        * */
//2. 查询一行数据并将该行数据转换为Map返回
//        jdbcTemplate.queryForMap("select * from STUDENT where name='name5'");
//3.查询一行任何类型的数据，最后一个参数指定返回结果类型
//        jdbcTemplate.queryForObject("select count(*) from STUDENT", Integer.class);
//4.查询一批数据，默认将每行数据转换为Map
//        jdbcTemplate.queryForList("select * from STUDENT");
//5.只查询一列数据列表，列类型是String类型，列名字是name
//        jdbcTemplate.queryForList("select name from STUDENT where name = ? ", new Object[]{" name5 "}, String.class);
//6.查询一批数据，返回为SqlRowSet，类似于ResultSet，但不再绑定到连接上
//        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from test");


        String sql = "SELECT ID,NAME,SCORE_SUM,SCORE_AVG, AGE   FROM STUDENT";
        List result1 = jdbcTemplate.queryForList("SELECT NAME FROM STUDENT where NAME=?", new Object[]{"sshcx"}, String.class);
        List result2 = jdbcTemplate.queryForList(sql);

        List result = jdbcTemplate.query(sql, new ColumnMapRowMapper()); //ColumnMapRowMapper类返回一个List对象，对象中的每一个元素都是一个以列名为key的Map对象。
        return result2;
//        return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int i) throws SQLException {
//                Student stu = new Student();
//                stu.setId(rs.getInt("ID"));
//                stu.setAge(rs.getInt("AGE"));
//                stu.setName(rs.getString("NAME"));
//                stu.setSumScore(rs.getString("SCORE_SUM"));
//                stu.setAvgScore(rs.getString("SCORE_AVG"));
//                return stu;
//            }
//        });
    }

    public void insertTo() {  //插入
        String sql = "insert into student VALUES(6,'sshcx111','语文','数学',34)";
        jdbcTemplate.update(sql);
    }

    public void deleteMs() {  //删除
        String sql = "delete  from  student  where ID = 6";
        int id = jdbcTemplate.update(sql);
        if (id == 1) {
            log.info("删除成功");
        } else {
            log.info("删除失败");
        }
    }
}
