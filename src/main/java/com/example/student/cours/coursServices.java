package com.example.student.cours;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class coursServices {

    public List<cours>listCours(){
        return List.of(new cours(1L,"informatique","programation"));
    }
}
