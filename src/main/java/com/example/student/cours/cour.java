package com.example.student.cours;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class cour{
    @Id
    @GeneratedValue
    private long id;

    private String nom;
    private String description;

    
    public cour() {
    }

    public cour(long id, String nom,String descr){
        this.id = id;
        this.nom = nom;
        this.description = descr;
    }

    public String getNom(){
        return this.nom;
    }
    public String getDescription(){
        return this.description;
    }
    public Long getId(){
        return this.id;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String toString(){
        return "nom :"+this.nom+"Déscription :"+this.description;
    }
}
