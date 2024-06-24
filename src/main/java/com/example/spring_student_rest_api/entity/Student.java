package com.example.spring_student_rest_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_surname")
    private String student_surname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

    @Column(name = "department")
    private String department;

    @Column(name = "GPA")
    private float GPA;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "student_name='" + student_name + '\'' +
                ", student_surname='" + student_surname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}
