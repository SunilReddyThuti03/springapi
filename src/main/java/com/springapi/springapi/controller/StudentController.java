package com.springapi.springapi.controller;

import com.springapi.springapi.dto.StudentDto;
import com.springapi.springapi.dto.StudentEntryDto;
import com.springapi.springapi.entity.StudentEntity;
import com.springapi.springapi.repository.StudentRepository;
import com.springapi.springapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
        //return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody StudentEntryDto studentEntryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(studentEntryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentEntryDto studentEntryDto){
        return ResponseEntity.ok(studentService.updateStudent(id,studentEntryDto));
    }
}
