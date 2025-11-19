package com.owaissalam.Student_management_Using_Jdbctemplate;

import com.owaissalam.Student_management_Using_Jdbctemplate.Model.Student;
import com.owaissalam.Student_management_Using_Jdbctemplate.Service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class appMenu {
    private final StudentService service;
    private final Scanner sc;

    public appMenu(StudentService service){
        this.service = service;
        this.sc = new Scanner(System.in);
    }

    public void start() throws SQLException {
        while (true){
            System.out.println("1. Get student by id");
            System.out.println("2. Get all students");
            System.out.println("3. Add a new student");
            System.out.println("4. Update student marks");
            System.out.println("5. Change student name");
            System.out.println("6. Delete student");
            System.out.println("7. Exit !");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> get();
                case 2 -> getAll();
                case 3 -> add();
                case 4 -> update();
                case 5 -> changename();
                case 6 -> delete();
                case 7 -> {
                    System.out.println("Exiting....");
                    return;
                }
                default -> System.out.println("Invalid choice try again");
            }
        }
    }

    public void get() throws SQLException {
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println(service.getStudent(id));
    }

    public void getAll() throws SQLException {
        System.out.println(service.getAllStudents());
    }
    public void add() throws SQLException {
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        System.out.println("Enter name : ");
        String name = sc.next();
        System.out.println("Enter marks :");
        int marks = sc.nextInt();

        service.addStudent(new Student(id, name, marks));
    }

    public void update() throws SQLException {
        System.out.println("Enter id :");
        int id = sc.nextInt();
        System.out.println("Enter new marks :");
        int newMarks = sc.nextInt();

        service.updateMarks(id, newMarks);
    }
    public void changename() throws SQLException {
        System.out.println("Enter student id : ");
        int id = sc.nextInt();
        System.out.println("Enter new name : ");
        String newName = sc.next();

        service.changeName(id, newName);
    }
    public void delete() throws SQLException {
        System.out.println("Enter student id : ");
        int id = sc.nextInt();

        service.removeStudent(id);
    }
}
