package com.example.demo;

public class Car {
    private Engine engine;

    // Constructor injection
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        System.out.println("Driving" + engine.startEngine());
    }
}
