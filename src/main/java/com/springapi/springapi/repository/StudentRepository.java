package com.springapi.springapi.repository;


import com.springapi.springapi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<StudentEntity,Long> {
}
