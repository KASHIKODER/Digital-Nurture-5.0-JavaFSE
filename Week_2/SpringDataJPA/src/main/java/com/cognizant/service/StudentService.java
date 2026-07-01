package com.cognizant.service;

import com.cognizant.entity.Student;
import com.cognizant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getByDepartment(String dept) {
        return studentRepository.findByDepartment(dept);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}