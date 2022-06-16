package com.example.student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;;

@SpringBootApplication
@RestController
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@GetMapping
	public String hello(){
		return "Hello world";
	}
	// @GetMapping("/students")
    // public List<Student>listStudent(){
    //     return List.of(new Student(1l,"iko","iko@gmail.com",2));
    // }

}
