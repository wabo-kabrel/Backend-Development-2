// Creating a Minimal Hello World REST App

// The easiest way to create a Spring Boot project is by using Spring
// Initializr. This is a web-based tool that acts as a project generator. 
// It helps you quickly set up a project structure with all the necessary dependencies.


// Step 1: Generate project using Spring Initializr
// Go to https://start.spring.io
// Select:
// - Project: Maven
// - Language: Java
// - Spring Boot: (Latest stable version)
// - Dependencies: Spring Web
// - Group: com.example
// - Artifact: hello
// - Package Name: com.example.hello
// Download and unzip


// Step 2: Project structure
/*

hello/
 ├── src/
 │    ├── main/
 │    │    ├── java/com/example/hello/
 │    │    │    ├── HelloApplication.java
 │    │    └── resources/
 │    │         ├── application.properties
 │    └── test/
 ├── pom.xml

*/ 


// Step 3:  Main application file
// HelloApplication.java
/*
package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
 */
 
// Explanation:
// - @SpringBootApplication → Tells Spring Boot: "This is the starting point."
// - SpringApplication.run() → Launches an embedded server (Tomcat by default).
// - No need to install Tomcat separately — it’s built-in.


// Step 4: Create a REST Controller
// HelloController.java
/*
package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this as a REST API controller
public class HelloController {

    @GetMapping("/hello") // Maps GET requests to /hello
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
*/


// Step 5: Run the application
// - Open a terminal in the project directory
// - Run the command: `mvn spring-boot:run`
// - Or run HelloApplication.java in your IDE.
// - Visit http://localhost:8080/hello
// - You should see: Hello, Spring Boot!



// Common Beginner Mistakes
// - Forgetting to add the right dependency (e.g., spring-boot-starter-web for web apps).
// - Not putting controller classes in the same or sub-package as the main app class (Spring
//   Boot scans packages from the main class’s package downwards).
// - Trying to install Tomcat separately (Spring Boot already includes one).