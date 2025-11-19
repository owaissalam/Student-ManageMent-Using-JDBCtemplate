package com.owaissalam.Student_management_Using_Jdbctemplate.Repository;

import com.owaissalam.Student_management_Using_Jdbctemplate.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student s){
        String sql = "insert into student values(?,?,?)";
        int ans = jdbc.update(sql, s.getId(), s.getName(), s.getMarks());
        if(ans > 0) System.out.println("Added to db");
    }

}
