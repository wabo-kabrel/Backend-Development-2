//1. What is Auto-Configuration?
// - Auto-Configuration is Spring Boot's automatic setup feature.
// When your application starts:
    // - Spring Boot looks at:
        //1. The libraries you’ve added via starters
        //2. Any custom configurations you’ve written
    // - Then it guesses sensible defaults and configures beans (components)
    // automatically.


//2. How it works
// - @EnableAutoConfiguration is the core annotation.
// - @SpringBootApplication actually contains:
    // - @Configuration → Marks this class as a source of bean definitions.
    // - @EnableAutoConfiguration → Tells Spring Boot to configure beans automatically.
    // - @ComponentScan → Scans the package for your components, services, controllers.

// So when you write:
/*
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
*/

// You’re telling Spring Boot:
    // - “Scan for my components, use your defaults where possible, but 
    //    let me override them if I provide my own beans.”


//3.  Example — Web Starter Auto-Config
// If you add:
/*
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
 */

 // Spring Boot:
    // - Sees you have Spring MVC in classpath.
    // - Creates a DispatcherServlet bean automatically.
    // - Starts Tomcat on port 8080.
    // - Sets JSON support with Jackson.

// Without auto-configuration, you’d have to:
    // - Manually declare a servlet bean.
    // - Configure URL mappings.
    // - Set up JSON converters.
    // - Configure server properties.


//4.  Overriding Auto-Configuration
// Spring Boot uses the "last one wins" rule:
    // - If you define a bean with the same type/name as an auto-configured bean, 
    //   your version replaces the default.
// Example — custom server port via application.properties:
/*
server.port=9090
 */

 // Now Tomcat runs on 9090 instead of 8080.


 //5. Seeing Auto-Configuration in Action
 // Run your app with:
 /*
mvn spring-boot:run -Dspring-boot.run.arguments=--debug
  */

// OR
/*
debug=true
 */
// in application.properties.
// You’ll see logs like:
/*
Positive matches:
-----------------
DispatcherServletAutoConfiguration matched
JacksonAutoConfiguration matched

Negative matches:
-----------------
DataSourceAutoConfiguration did not match
*/

// Positive match → Spring Boot applied that configuration.
// Negative match → It skipped it (e.g., no database dependency).


//6.  Real-World Analogy
// Imagine you’re in a hotel room:
// - You walk in with just your luggage (dependencies).
// - The hotel auto-sets AC to a comfortable temp, places water bottles, and tunes the TV.
// - If you don’t like it, you change the settings (override defaults).


//7. Common Beginner Mistakes
// - Expecting everything to auto-configure without adding the right starter — Auto-configuration
//   only works if the library is in your classpath.
// - Putting components in the wrong package — @ComponentScan starts scanning from 
//   your main app class’s package downward.
// - Overriding beans accidentally — Naming a bean the same as a default one without realizing it.\

//8. Practice Task:
// - Create a project with only spring-boot-starter-web.
// - Enable debug mode in application.properties:
/*
 debug=true
 */
// - Run the app and look at the auto-configuration report — identify at least 3 positive matches
//   and 2 negative matches.
// - Change the port using server.port and verify it overrides the default.
// - Add spring-boot-starter-data-jpa and see what new configurations get applied.




