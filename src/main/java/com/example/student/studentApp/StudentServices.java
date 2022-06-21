package com.example.student.studentApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

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
    public Student getStudentById(Long id){
      return studentRepository.findStudentById(id);
    }

    public ResponseEntity<Student>updateEleve(Long id,Student std){
      Optional<Student> studentData = studentRepository.findById(id);
      if(studentData.isPresent()){
        Student _Student = studentData.get();
        if(std.getNom()!=null && std.getNom().length()>0 && !Objects.equals(_Student.getNom(), std.getNom())){
          _Student.setNom(std.getNom());
        }
        if(std.getEmail()!=null && std.getEmail().length()>0 && !Objects.equals(_Student.getEmail(), std.getEmail())){
          Optional<Student> studentOptional = studentRepository.findStudentByEmail(std.getEmail());
          
          if(studentOptional.isPresent()){
            throw new IllegalStateException("email alread taken");
          }else{
            _Student.setEmail(std.getEmail());
          }
        }
        if(std.getNais()!=null && !Objects.equals(_Student.getNais(), std.getNais())){
          _Student.setNais(std.getNais());
        }
        return new ResponseEntity<>(studentRepository.save(_Student), HttpStatus.OK);

      }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }

    //@Transactional
    /*public void updateStudent(Long id,String name,String email){

      Student std = studentRepository.findStudentById(id);
      if(std!=null){
       throw new IllegalStateException("student with id : "+id+" not exist");
      }
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
    }*/
}
