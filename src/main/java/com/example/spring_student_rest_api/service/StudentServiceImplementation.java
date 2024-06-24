package com.example.spring_student_rest_api.service;

import com.example.spring_student_rest_api.dao.StudentRepository;
import com.example.spring_student_rest_api.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceImplementation implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isEmpty()) {
            throw new RuntimeException("Student id not found - " +id);
        }
        return result.get();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public String delete(int id) {
        Optional<Student> result = studentRepository.findById(id);
        if(result.isEmpty()) {
            throw new RuntimeException("Student id not found - " +id);
        }
        Student student = result.get();
        studentRepository.delete(student);
        return "Student with the id " +id + " has been deleted";
    }
}
