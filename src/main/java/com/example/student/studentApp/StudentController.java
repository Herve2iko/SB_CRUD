package com.example.student.studentApp;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    private final StudentServices stService;

	@Autowired
	public StudentController(StudentServices stService) {
		this.stService = stService;
	}
	@GetMapping
	public List<Student> getStudents(){
		return this.stService.getStudents();
	}
	@GetMapping(path="/{idstud}")
	public Student getStudents(@PathVariable("idstud") Long id){
		return this.stService.getStudentById(id);
	}
	@PostMapping
	public void registerStudent(@RequestBody Student std){
		this.stService.addStudent(std);
	}
	@DeleteMapping(path = "/{stdId}")
	public void deleteStudent(@PathVariable("stdId") Long id){
		this.stService.deleteStudent(id);
	}

	@PutMapping(path = "/update/{id}")
	public String updateStudent(@PathVariable Long id,@RequestBody Student student){
			if(id>0){
				this.stService.updateEleve(id, student);
				return "modifie avec succes"+id;
			}
			return "vyanse kabisa"+id;
	}
	
}
