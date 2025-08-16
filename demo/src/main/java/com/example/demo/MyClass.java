package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClass {

    private A newA;

    // Dependency injected through '@Autowired' annotation
    // @Autowired
    // private A newA;

    // Dependency injected through constructor injection
    public MyClass(A a){
        this.newA = a;
    }

    public void run(){
        newA.getMessage();
    }
}
