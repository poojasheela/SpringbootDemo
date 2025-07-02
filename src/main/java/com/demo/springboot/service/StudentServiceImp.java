package com.demo.springboot.service;

import com.demo.springboot.Student;
import com.demo.springboot.dto.StudentDto;
import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.repository.StudentRepository;
//import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentMapper mapper= StudentMapper.instance;

    @Override
    public Student addStudent(StudentDto studentDto) {
        Student student = mapper.toEntity(studentDto);
        return studentRepository.save(student);

    }



    @Override
    public StudentDto getStudentDtoById(int id){
        Student student = studentRepository.findById(id).orElse(null);
        return mapper.toDto(student);
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
