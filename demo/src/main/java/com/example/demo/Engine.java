package com.example.demo;

// This is a POJO -> A POJO (Plain Old Java Object) is a simple Java object that is not bound by any special restrictions or requirements. It is used to increase the readability and reusability of a program, typically representing data with fields and encapsulating it with getters and setters. The term was coined to describe ordinary Java objects that do not require any specific framework or adhere to any particular design pattern.

public class Engine {

    // Constructor of Engine class
    public Engine() {
        System.out.println("Engine has been created successfully.");
    }

    // Created a method
    public String startEngine() {
        return "Engine has started";
    }
}
