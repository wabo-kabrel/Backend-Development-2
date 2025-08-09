//1. What is a Starter?
// A starter in Spring Boot is a pre-package set of dependencies that
// you can add to your project to enable a specific feature without manually
// searching for and configuring each library yourself.

// Think of it as a combo meal:
// - Instead of ordering bread, meat, cheese, and sauce separately, you just 
//   order a "Burger Meal" and it comes with everything in the right quantity.
// - In coding terms: Instead of adding Tomcat, Jackson, and Spring MVC one-by-one,
//   you just add spring-boot-starter-web.


//2. Why Starters Exist
// Before starters:
// - You had to find compatible versions of libraries.
// - If one library version didn’t work with another, you were in dependency hell.
// - You needed to write a lot of boilerplate configuration.

// After starters:
// - You just add one dependency.
// - Spring Boot pulls in all required libraries and versions that work well together.
// - Auto-configuration kicks in to set everything up.


//3.  Popular Starters
// spring-boot-starter-data-jpa: For database access using JPA & Hibernate.
// spring-boot-starter-security: Adds authentication & authorization support.
// spring-boot-starter-thymeleaf: For HTML templating with Thymeleaf.
// spring-boot-starter-test: For unit & integration testing (JUnit, Mockito, Spring Test).
// spring-boot-starter-mail: For sending emails.
// spring-boot-starter-actuator: For monitoring & metrics.
// spring-boot-starter-web: For building web apps & REST APIs (includes Spring MVC, Tomcat,
// JSON support via Jackson).

// NB: All starters start with spring-boot-starter-*.


//4.  Example: Adding a Starter
// Let’s say you want to build a REST API.
// In your pom.xml (Maven):
/*
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

 */
// This single line:
// - Pulls in Spring MVC
// - Pulls in Tomcat (embedded server)
// - Pulls in Jackson for JSON
// - Configures it automatically


//5.  Combining Starters
// - You can add multiple starters to your app.
// - Example for a REST API with database:
/*
<dependencies>
    <!-- Web API support -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Database access -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
 */


//6. Common Beginner Mistakes
// - Forgetting to remove unused starters → This can make your app heavier.
// - Mixing versions → Always let Spring Boot manage versions; don’t manually
//   set them unless necessary.
// - Adding starters for features you’re not using → e.g., adding 
//   spring-boot-starter-thymeleaf when you’re building a pure REST API.


//7. Real-World Example
// Let’s say you’re building an online bookstore:
// You’ll need to:
    // - Serve REST endpoints → spring-boot-starter-web
    // - Store data in MySQL → spring-boot-starter-data-jpa
    // - Secure endpoints → spring-boot-starter-security
    // - Write tests → spring-boot-starter-test
// Just four dependencies, and 90% of the configuration is done for you.

//8. Practice Task:
// - Create a Spring Boot project with:
        // - Spring Web
        // - Spring Data JPA
        // - Spring Boot Test
// - Create a REST controller with endpoint /status returning {"status": "running"}.
// - Add a dependency you don’t use (e.g., spring-boot-starter-mail), run the app, then
//   remove it — see how the app size changes in logs.
// - Open the pom.xml and inspect what dependencies spring-boot-starter-web brought in.