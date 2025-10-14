package com.springapi.springapi.controller;

import com.springapi.springapi.dto.StudentDto;
import com.springapi.springapi.entity.StudentEntity;
import com.springapi.springapi.repository.StudentRepository;
import com.springapi.springapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }
}
