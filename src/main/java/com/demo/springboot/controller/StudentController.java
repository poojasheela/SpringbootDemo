package com.demo.springboot.controller;

import com.demo.springboot.Student;
import com.demo.springboot.dto.StudentDto;
import com.demo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/post")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/get/{id}")
    public StudentDto getStudentById(@PathVariable int id) {
        return studentService.getStudentDtoById(id);
    }

    /*
    public List<StudentDto> getAllStudents(@PathVariable int id) {
        List<StudentDto> studentDto=this.studentService.getAllStudents(id);
        return studentDto;
    }
*/
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
