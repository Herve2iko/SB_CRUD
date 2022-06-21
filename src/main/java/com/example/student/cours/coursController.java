package com.example.student.cours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/cours")
public class coursController {
    private final coursServices crService;

    @Autowired
    public coursController(coursServices cr){
        this.crService = cr;
    }

    @GetMapping
    public List<cour> listCours(){
        return this.crService.listCours();
    }
    @GetMapping(path = "/{id}")
    public cour singleCour(@PathVariable Long id){
        return this.crService.oneCour(id);
    }
    @PostMapping
    public void createCour(@RequestBody cour cr){
        this.crService.addCour(cr);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<cour> deleteSingleCour(@PathVariable Long id){
        return this.crService.deleteOneCour(id);
    }
    @DeleteMapping
    public void deleteAllCour(){
        this.crService.deleteAllCours();
    }
    @PutMapping(path = "mod/{id}")
    public ResponseEntity<cour> updateCour(@PathVariable Long id, @RequestBody cour cr){
       return this.crService.modifiyCour(id,cr);
    }
}
