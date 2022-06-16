package com.example.student.cours;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<cours>listCours(){
        return this.crService.listCours();
    }
}
