//1. Packaging Your Application 
// Spring Boot creates self-contained executable JAR files (fat JARs) that include all dependencies.
// To build a JAR:
    // - Using Maven:
        /*
        `bash`
        
        mvn clean package
        */
    // - Using Gradle:
        /*
        `bash`
        
        ./gradlew clean build
         */
    // This produces a JAR (e.g., myapp-0.0.1-SNAPSHOT.jar) in the target or build/libs folder.


//2. Running the Packaged Application
// Run the JAR anywhere with Java installed:
/*
`bash` 
 
java -jar myapp-0.0.1-SNAPSHOT.jar
*/
// You can pass config overrides via CLI:
    /*
    `bash`
    
    java -jar myapp.jar --server.port=9090
     */


//3. Common Deployment Targets
// - Cloud Platforms: AWS Elastic Beanstalk, Google Cloud Run, Azure App Service
// - Containers: Docker images deployed to Kubernetes or Docker Swarm
// - Traditional Servers: VPS, dedicated servers running Linux or Windows


//4. Creating a Docker Image (Optional but Recommended)
// Docker helps package your app with the exact runtime environment.
// Sample Dockerfile:
/*
`dockerfile` 
 
FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
*/
// Build and run:
    /*
    `bash`
    
    docker build -t myapp .
    docker run -p 8080:8080 myapp
    */


//5. Environment-Specific Configurations
// Use Spring profiles to load different config per environment.
// At runtime, specify active profile:
/*
`bash`

java -jar app.jar --spring.profiles.active=prod
*/
// Or set environment variables.


//6. Best Practices for Deployment
// ✅ Use externalized configuration for secrets and environment-specific settings.
// ✅ Enable health checks and monitoring (e.g., Actuator).
// ✅ Use HTTPS and secure your app (Spring Security).
// ✅ Automate deployment with CI/CD pipelines.
// ✅ Use logging and metrics to monitor app health.


//7. Real-World Use Case
// You build a Spring Boot app locally, containerize it with Docker, push it to a container 
// registry, and deploy it on AWS Elastic Kubernetes Service (EKS) for scalability.


//8. Practice Exercises
//i. Package your app into an executable JAR.
//ii. Run the app locally using the JAR.
//iii. Create a Docker image for your app and run it.
//iv. Simulate different environments by running with different Spring profiles.
//v. (Optional) Research deploying Spring Boot apps to a cloud platform of your choice.
