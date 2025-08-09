//1. What is a Configuration in Spring Boot?
// In Spring Boot, configuration means external settings that control your
// application’s behavior — without changing the code.
// This lets you:
    // - Change server ports
    // - Switch database connections
    // - Enable/disable features
    // - Configure API keys
// 💡 The key idea:
    // Keep config outside the code, so you can deploy the same app to dev/test/prod 
    // with different settings.


//2. Ways to Provide Configuration
// Spring Boot supports multiple sources, in order of priority (highest wins):
    // - Command-line arguments 
    // - Java system properties (-Dserver.port=9090)
    // - Environment variables (SERVER_PORT=9090)
    // - application.properties / application.yml in src/main/resources
    // - Default values in code
// 📌 Spring Boot merges them and picks the one with the highest priority.


//3. application.properties vs application.yml
// Both are supported — choose one.
// application.properties
    /*
    server.port=8085
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=root
    spring.datasource.password=1234
     */
// application.yml
    /*
    server:
      port: 8085

    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/mydb
        username: root
        password: 1234
     */
// YAML is cleaner for nested configs, but properties are simpler for small files.


//4. Using @Value to Inject Config Values
// Example:
    /*
    @RestController
    public class GreetingController {

        @Value("${app.name}")
        private String appName;

        @GetMapping("/greet")
        public String greet() {
            return "Welcome to " + appName;
        }
    }
    */
    // In application.properties:
        /* 
        app.name=Spring Boot Learning App
        */
    // Visit /greet → returns:
        /*
        Welcome to Spring Boot Learning App
         */

         
//5. Profiles — Switching Configurations
// Profiles — Switching Configurations:
    // - Development (dev)
    // - Testing (test)
    // - Production (prod)
// Example:
    // application-dev.properties
    /*
    server.port=8081
    spring.datasource.url=jdbc:h2:mem:devdb
    */
    // application-prod.properties
    /*
    server.port=80
    spring.datasource.url=jdbc:mysql://prod-server:3306/proddb
    */


//6. Activating a Profile
// Options:
    // - In application.properties:
        /*
        spring.profiles.active=dev 
         */
    // - As a command-line argument:
        /*
        `mvn spring-boot:run -Dspring-boot.run.profiles=prod`
        */    
    // - As an environment variable:
        /*
        export SPRING_PROFILES_ACTIVE=prod
        */    
        

//7. Real-World Example
// Imagine your app uses:
    // - H2 in-memory DB in dev (fast, no install needed)
    // - MySQL in prod
// You can also have:
    // - application-dev.properties → H2 config
    // - application-prod.properties → MySQL config
    // Switch instantly by changing spring.profiles.active.


//8. Common Beginner Mistakes
// - Forgetting to switch profiles before deploying → accidentally using dev DB in prod.
// - Mixing dev/prod config in one file → makes deployments error-prone.
// - Overriding properties in multiple places without realizing → leads to confusion.


//9. Practice Task
//i. Create a new Spring Boot project with spring-boot-starter-web
//ii. In application.properties, set:
        /*
        app.name=My First Config App
        server.port=8082
         */
//iii. Create a controller /config that returns "App: {app.name}" using @Value.
//iv. Create application-dev.properties with:
        /*
        server.port=9000
        app.name=Development App
          */
//v. Run the app with `mvn spring-boot:run -Dspring-boot.run.profiles=dev`
//vi. Verify:
        // - In normal mode → runs on 8082
        // - In dev mode → runs on 9000
