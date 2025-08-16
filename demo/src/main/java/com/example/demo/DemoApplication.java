package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


        // Getting the methods/functions of class A. B and C

        A functionA = context.getBean(A.class);
        // B functionB = context.getBean(B.class); // Error -> not marked as @Component so no bean has been created for class B.
        C functionC = context.getBean(C.class);

        functionA.getMessage();
        functionC.getMessage();

        MyClass myClass = context.getBean(MyClass.class);
        myClass.run();
	}

}
