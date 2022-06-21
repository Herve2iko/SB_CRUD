package com.example.student.cours;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class coursServices {
    
    private final coursRepository repoCours;

    @Autowired
    public coursServices(coursRepository repoCours) {
        this.repoCours = repoCours;
    }


    public List<cour> listCours(){
        return repoCours.findAll();
    }


    public cour oneCour(Long id) {
        Optional <cour> courId = repoCours.findById(id);
        if(!courId.isPresent()){
            throw new IllegalStateException("cours avec id :"+id+" est introuvable");
        }
        cour cr = courId.get();
        return cr;
    }

    public void addCour(cour cr) {
        if(cr.getNom()==null && cr.getNom().length()<2){
            throw new IllegalStateException("Le cour doit avoir un nom");
        }
        if(cr.getDescription()==null && cr.getDescription().length()<5){
            throw new IllegalStateException("Le cour doit avoir un Description");
        }
        repoCours.save(cr);
    }


    public ResponseEntity <cour> modifiyCour(Long id, cour cr) {
        Optional <cour> courId = repoCours.findById(id);
        if(courId.isPresent()){
            cour _cr = courId.get();
            if(cr.getNom()!=null && cr.getNom().length()>2 && !Objects.equals(_cr.getNom(), cr.getNom())){
                _cr.setNom(cr.getNom());
            }
            if(cr.getDescription()!=null && cr.getDescription().length()>5 && !Objects.equals(_cr.getDescription(), cr.getDescription())){
                _cr.setDescription(cr.getDescription());
            }
            return new ResponseEntity<>(repoCours.save(_cr),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<cour> deleteOneCour(Long id) {
        Optional <cour> cr = repoCours.findById(id);
        if(cr.isPresent()){
            cour _cr = cr.get();
            repoCours.delete(_cr);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public void deleteAllCours() {
        repoCours.deleteAll();
    }
}
