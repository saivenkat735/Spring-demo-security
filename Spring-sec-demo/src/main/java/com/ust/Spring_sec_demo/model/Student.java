package com.ust.Spring_sec_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    private int id;
    private String name;
    private String tech;

//    public Student(int id, String name, String tech) {
//        this.id=id;
//        this.name=name;
//        this.tech=tech;
//    }
}
