package com.demo.springboot.service;

import com.demo.springboot.Student;
import com.demo.springboot.dto.StudentDto;
import com.demo.springboot.repository.StudentRepository;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
   public Student addStudent(StudentDto studentDto) {
        Student student = new Student();
        //student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
      return studentRepository.save(student);
   }


    // get using object mapping
    @Override
    public StudentDto getStudentDtoById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }
        return new StudentDto(student.getId(), student.getName(), student.getCourse());
    }

    @Override
    public Student updateStudent(int id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setPassword(updatedStudent.getPassword());
            student.setCourse(updatedStudent.getCourse());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {

        studentRepository.deleteById(id);
    }
}
