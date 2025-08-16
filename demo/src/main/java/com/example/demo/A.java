package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class A {

    public A(){
        System.out.println("Class A constructor called");
    }

    public void getMessage(){
        System.out.println("Message from A");
    }
}
