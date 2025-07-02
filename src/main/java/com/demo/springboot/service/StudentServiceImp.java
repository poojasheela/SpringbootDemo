package com.demo.springboot.service;

import com.demo.springboot.Student;
import com.demo.springboot.dto.CreateStudentDto;
import com.demo.springboot.dto.StudentDto;
import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.repository.StudentRepository;
//import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;
  /*  @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }*/
  @Override
  public StudentDto addStudent(CreateStudentDto createDto) {
      Student student = modelMapper.map(createDto, Student.class);
      Student saved = studentRepository.save(student);
      return modelMapper.map(saved, StudentDto.class);
  }

    @Override
    public StudentDto getStudentDtoById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return null;
        return new StudentDto(student.getId(), student.getName(), student.getCourse());
    }


   /* @Override
   public List<StudentDto> getAllStudents(int id) {
        Student student=this.studentRepository.findById(id).get();
       StudentDto studentDto=this.modelMapper.map(student,StudentDto.class);
       return Collections.singletonList(studentDto);

        return Collections.singletonList(StudentMapper.mapper.mapToStudentDto(student));

    }*/

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
