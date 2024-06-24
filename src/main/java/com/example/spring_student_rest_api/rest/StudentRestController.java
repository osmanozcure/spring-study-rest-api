package com.example.spring_student_rest_api.rest;

import com.example.spring_student_rest_api.entity.Student;
import com.example.spring_student_rest_api.service.StudentService;
import com.example.spring_student_rest_api.service.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students/{id}")
    public Student findStudent(@PathVariable int id) {
        return studentService.findById(id);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0);
        Student dbStudent = studentService.save(student);
        return studentService.save(dbStudent);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> result = Optional.ofNullable(studentService.findById(id));
        if(result.isEmpty()) {
            throw new RuntimeException("Student id not found - " +id);
        }

        // set the id for the new student
        Student dbStudent =  result.get();
        dbStudent = student;
        dbStudent.setId(id);
        // save the new student
        return studentService.save(student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.delete(id);
    }

}
