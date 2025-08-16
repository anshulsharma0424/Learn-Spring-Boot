package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class C {

    public C(){
        System.out.println("Class C constructor called");
    }

    public void getMessage(){
        System.out.println("Message from C");
    }
}
