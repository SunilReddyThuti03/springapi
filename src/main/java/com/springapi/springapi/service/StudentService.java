package com.springapi.springapi.service;

import com.springapi.springapi.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto findStudentById(Long id);
}
