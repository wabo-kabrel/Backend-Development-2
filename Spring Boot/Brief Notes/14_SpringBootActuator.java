//1. What is Spring Boot Actuator?
// Spring Boot Actuator adds production-ready features to your app, including:
   // - Health checks
   // -  Metrics (CPU, memory, HTTP requests)
   // -  Info endpoints
   // -  Environment properties exposure
   // -  Application uptime and beans information
// It helps you monitor and manage your app in real time.


//2. Adding Actuator Dependency
// Add this to your pom.xml:
/*
`xml`
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
*/


//3. Available Actuator Endpoints
// Common endpoints include:
/*
| Endpoint            | Description                      | Default Access          |
| ------------------- | -------------------------------- | ----------------------- |
| `/actuator/health`  | Application health status        | Public                  |
| `/actuator/info`    | Custom application info          | Public                  |
| `/actuator/metrics` | Metrics on memory, CPU, requests | Secured (requires auth) |
| `/actuator/env`     | Environment properties           | Secured                 |
| `/actuator/loggers` | Logger levels                    | Secured                 |
 
 */


//4. Configuring Actuator Endpoints
// By default, only /health and /info are enabled.
// To enable all endpoints, add in application.properties:
/*
`properties`

management.endpoints.web.exposure.include=*
*/
// Or to expose specific endpoints:
/*
`properties`

management.endpoints.web.exposure.include=health,info,metrics
*/ 


//5. Customizing Health Checks
// You can add custom health indicators by implementing HealthIndicator:
/*
`java`

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        // Your custom health logic here
        boolean healthy = checkSomething();

        if (healthy) {
            return Health.up().withDetail("customCheck", "All good").build();
        } else {
            return Health.down().withDetail("customCheck", "Something is wrong").build();
        }
    }

    private boolean checkSomething() {
        // Logic here
        return true;
    }
} 
 */


//6. Securing Actuator Endpoints
// If Spring Security is enabled, actuator endpoints are protected by default.
// You can customize access in your security config: 
/*
`java`

http.authorizeHttpRequests(auth -> auth
    .requestMatchers("/actuator/health", "/actuator/info").permitAll()
    .requestMatchers("/actuator/**").hasRole("ADMIN")
    .anyRequest().authenticated()
);  
*/


//7. Real-World Use Case
// In production, your DevOps or monitoring tools (like Prometheus, Grafana) query
//  actuator endpoints to check:
    // - If your app is alive and healthy
    // - Performance metrics
    // - Environment info


//8. Practice Exercises
//i. Add Spring Boot Actuator to your app.
//ii. Enable all actuator endpoints.
//iii. Create a custom health indicator that checks a dummy condition.
//iv. Secure all actuator endpoints except /actuator/health and /actuator/info to be accessible only by ADMIN role.
//v. Use Postman or curl to test the endpoints.



