package com.demo.springboot.service;

import com.demo.springboot.Student;
import com.demo.springboot.dto.CreateStudentDto;
import com.demo.springboot.dto.StudentDto;

import java.util.List;

public interface StudentService {

    //Student addStudent(Student student);
    StudentDto addStudent(CreateStudentDto createDto);

    StudentDto getStudentDtoById(int id);

//    List<StudentDto> getAllStudents(int id);

    Student updateStudent(int id, Student updatedStudent);

    void deleteStudent(int id);
}
