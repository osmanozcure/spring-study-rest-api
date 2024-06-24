package com.example.spring_student_rest_api.service;

import com.example.spring_student_rest_api.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student save(Student student);

    Student findById(int id);

    List<Student> findAll();

    String delete(int id);


}
