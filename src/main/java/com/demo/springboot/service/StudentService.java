package com.demo.springboot.service;

import com.demo.springboot.Student;
import com.demo.springboot.dto.StudentDto;

public interface StudentService {

    //Student addStudent(Student student);
    Student addStudent(StudentDto studentDto);

    StudentDto getStudentDtoById(int id);

//    List<StudentDto> getAllStudents(int id);

    Student updateStudent(int id, Student updatedStudent);

    void deleteStudent(int id);
}
