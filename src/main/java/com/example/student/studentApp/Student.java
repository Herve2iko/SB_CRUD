package com.example.student.studentApp;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
    )
    long id;
    String nom;
    String email;
    LocalDate nais;
    @Transient
    int age;

    public Student(){}
    public Student(long id,String nom,String email){
        this.id = id;
        this.nom = nom;
        this.email = email;
    }
    public Student(String nom,String email,LocalDate nais){
        this.nais = nais;
        this.nom = nom;
        this.email = email;
    }
    
    public long getId() {
        return id;
    }
    public String getNom(){
        return this.nom;
    }
    public String getEmail(){
        return this.email;
    }
    

    public void setNais(LocalDate nais) {
        this.nais = nais;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setEmail(String email){
        this.email = email;
    }

    // public int getId(){
    //     return this.id;
    // }
    public int getAge(){
        return Period.between(this.nais, LocalDate.now()).getYears();
    }
    public LocalDate getNais(){
        return this.nais;
    }
    
    public String toString(){
        return "id: "+this.id+"nom"+this.nom+"email : "+this.email+"age :"+this.age;
    }
}
