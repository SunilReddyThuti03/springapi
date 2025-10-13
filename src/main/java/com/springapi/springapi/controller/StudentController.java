package com.springapi.springapi.controller;

import com.springapi.springapi.dto.StudentDto;
import com.springapi.springapi.entity.StudentEntity;
import com.springapi.springapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<StudentEntity> getStudent(){
        return studentRepository.findAll();
    }
}
