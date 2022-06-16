package com.example.student.studentApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StudentServices {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository repos){
      this.studentRepository = repos;
    }

    public List<Student> getStudents(){
      return this.studentRepository.findAll();
    }

    public void addStudent(Student std){
      Optional<Student>studentOptional = studentRepository.findStudentByEmail(std.getEmail());

      if(studentOptional.isPresent()){
        throw new IllegalStateException("Email exist");
      }
      studentRepository.save(std);
    }
    public void deleteStudent(Long id){
      Boolean studentCurrent = studentRepository.existsById(id);

      if(!studentCurrent){
        throw new IllegalStateException("student "+id+" not exist");
      }
      studentRepository.deleteById(id);
    }
    public List<Student> getStudentById(Long id){
      return studentRepository.findAllById(id);
    }

    @Transactional
    public void updateStudent(Long id,String name,String email){

      Student std = studentRepository.findStudentById(id).orElseThrow(
        ()-> new IllegalStateException("student with id : "+id+" not exist")
      );
      if(name!=null && name.length()>0 && !Objects.equals(name, std.getNom())){
        std.setNom(name);
      }
      if(name!=null && name.length()>0 && !Objects.equals(email, std.getEmail())){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(std.getEmail());
        
        if(!studentOptional.isPresent()){
          throw new IllegalStateException("email alread taken");
        }
        std.setEmail(email);
        
      }
    }
}
