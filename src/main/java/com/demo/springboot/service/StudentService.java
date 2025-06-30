package com.demo.springboot.service;

import com.demo.springboot.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(int id, Student updatedStudent);

    void deleteStudent(int id);
}
