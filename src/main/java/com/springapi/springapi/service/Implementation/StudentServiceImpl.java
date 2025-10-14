package com.springapi.springapi.service.Implementation;

import com.springapi.springapi.dto.StudentDto;
import com.springapi.springapi.entity.StudentEntity;
import com.springapi.springapi.repository.StudentRepository;
import com.springapi.springapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public List<StudentDto>  getAllStudents(){
        List<StudentEntity> students  = studentRepository.findAll();

        return students
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
    }

    public StudentDto findStudentById(Long id){
        Optional<StudentEntity> student = studentRepository.findById(id);

        return  modelMapper.map(student,  StudentDto.class);
    }
}
