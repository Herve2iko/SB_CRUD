package com.example.student.studentApp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findStudentByEmail(String em);
    Optional<Student> findStudentById(Long id);
    List<Student> findAllById(Long id);
    
}
