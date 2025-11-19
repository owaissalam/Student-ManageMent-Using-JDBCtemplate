package com.owaissalam.Student_management_Using_Jdbctemplate.Repository;

import ch.qos.logback.classic.boolex.StubEventEvaluator;
import com.owaissalam.Student_management_Using_Jdbctemplate.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public RowMapper<Student> mapper() {
        return (ResultSet rs, int rowNum) -> {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        };
    }


    public void save(Student s) {
        String sql = "insert into student values(?,?,?)";
        int ans = jdbc.update(sql, s.getId(), s.getName(), s.getMarks());
        if (ans > 0) System.out.println("Added to db");
    }

    public Student get(int id) {

        String sql = "select * from student where id=?";
        return jdbc.queryForObject(sql, new Object[]{id}, mapper());
    }
}