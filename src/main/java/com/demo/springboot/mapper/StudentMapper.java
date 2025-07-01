package com.demo.springboot.mapper;

import com.demo.springboot.Student;
import com.demo.springboot.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper mapper= Mappers.getMapper(StudentMapper.class);
    StudentDto mapToStudentDto(Student student);

}
