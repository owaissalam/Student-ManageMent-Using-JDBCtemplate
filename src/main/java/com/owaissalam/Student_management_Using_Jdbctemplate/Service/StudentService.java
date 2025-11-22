package com.owaissalam.Student_management_Using_Jdbctemplate.Service;

import com.owaissalam.Student_management_Using_Jdbctemplate.Model.Student;
import com.owaissalam.Student_management_Using_Jdbctemplate.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;


    public void addStudent(Student s) throws SQLException {
        repo.save(s);
    }
    public Student getStudent(int id) throws SQLException {
        return repo.get(id);

    }
    public List<Student> getAllStudents() throws SQLException {
        return repo.getAll();
    }
    public void deleteStudent(int id) throws SQLException {
        repo.delete(id);
    }
    public void updateMarks(int id, int newMarks) throws SQLException {
        repo.updateMarks(id, newMarks);
    }
    public void changeName(int id, String newName) throws SQLException {
        repo.updateName(id, newName);
    }
}
