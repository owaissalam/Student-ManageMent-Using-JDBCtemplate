package com.owaissalam.Student_management_Using_Jdbctemplate.Repository;

import com.owaissalam.Student_management_Using_Jdbctemplate.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

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

    public List<Student> getAll(){
        String sql = "select * from student";
        return jdbc.query(sql, mapper());
    }

    public void delete(int id) {
        String sql = "delete from student where id=?";
        int ans = jdbc.update(sql, id);
        if (ans > 0) System.out.println("deleted from db");
    }

    public void updateMarks(int id, int newMarks) {
        String sql = "update student set marks=? where id=?";
        int ans = jdbc.update(sql, newMarks, id);
        if (ans > 0) System.out.println("updated marks");
    }

    public void updateName(int id, String newName) {
        String sql = "update student set name=? where id=?";
        int ans = jdbc.update(sql, newName, id);
        if (ans > 0) System.out.println("Added to db");
    }
}