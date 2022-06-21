package com.example.student.studentApp;

//import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            /*Student st1 = new Student(
                "iko",
                "iko@gmail.com",
                LocalDate.of(2000,2,20));
            
            Student st2 = new Student(
                    "iko2",
                    "iko2@gmail.com",
                    LocalDate.of(2005,2,21));*/
            //studentRepository.saveAll(List.of(st1,st2));
        };
    }
}
