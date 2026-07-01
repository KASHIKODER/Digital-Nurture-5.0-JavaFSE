package com.cognizant;

import com.cognizant.entity.Student;
import com.cognizant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("\n=== Spring Data JPA Demo ===\n");

        // CREATE
        System.out.println("--- Saving Students ---");
        studentService.saveStudent(new Student("Suyash Giri", "suyash@kiit.ac.in", "CSE"));
        studentService.saveStudent(new Student("Karan Sharma", "karan@kiit.ac.in", "CSE"));
        studentService.saveStudent(new Student("Priya Singh", "priya@kiit.ac.in", "ECE"));

        // READ ALL
        System.out.println("\n--- All Students ---");
        List<Student> all = studentService.getAllStudents();
        all.forEach(System.out::println);

        // READ BY ID
        System.out.println("\n--- Student by ID 1 ---");
        Student s = studentService.getStudentById(1L);
        System.out.println(s);

        // READ BY DEPARTMENT
        System.out.println("\n--- Students in CSE ---");
        studentService.getByDepartment("CSE").forEach(System.out::println);

        // DELETE
        System.out.println("\n--- Deleting Student ID 3 ---");
        studentService.deleteStudent(3L);
        System.out.println("After delete — total students: " +
            studentService.getAllStudents().size());

        System.out.println("\n=== Spring Data JPA Complete! ===");
    }
}