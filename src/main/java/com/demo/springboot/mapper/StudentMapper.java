package com.demo.springboot.mapper;

import com.demo.springboot.Student;
import com.demo.springboot.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StudentMapper {

    StudentMapper instance = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);

}
