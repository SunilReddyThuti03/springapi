package com.springapi.springapi.service.Implementation;

import com.springapi.springapi.dto.StudentDto;
import com.springapi.springapi.dto.StudentEntryDto;
import com.springapi.springapi.entity.StudentEntity;
import com.springapi.springapi.repository.StudentRepository;
import com.springapi.springapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
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

    @Override
    public StudentDto createNewStudent(StudentEntryDto studentEntryDto) {
        StudentEntity student = studentRepository.save(modelMapper.map(studentEntryDto,StudentEntity.class));
        return modelMapper.map(student, StudentDto.class) ;
    }

    @Override
    public void deleteStudent(Long id){
        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Student doesn't exist with id: "+id);

    }

    @Override
    public StudentDto updateStudent(Long id, StudentEntryDto studentEntryDto){
        StudentEntity student= studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id dosnt exist"));
        student = modelMapper.map(student, StudentEntity.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
