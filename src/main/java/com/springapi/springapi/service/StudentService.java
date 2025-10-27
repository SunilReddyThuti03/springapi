package com.springapi.springapi.service;

import com.springapi.springapi.dto.StudentDto;
import com.springapi.springapi.dto.StudentEntryDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto findStudentById(Long id);
    StudentDto createNewStudent(StudentEntryDto studentEntryDto);
    void deleteStudent(Long id);
    StudentDto updateStudent(Long id, StudentEntryDto studentEntryDto);
}
