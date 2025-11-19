package com.owaissalam.Student_management_Using_Jdbctemplate;

import com.owaissalam.Student_management_Using_Jdbctemplate.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class StudentManagementUsingJdbctemplateApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(StudentManagementUsingJdbctemplateApplication.class, args);
        StudentService service = context.getBean(StudentService.class);

        appMenu menu = new appMenu(service);
        menu.start();
//        System.out.println("Hello Owais");
	}

}
