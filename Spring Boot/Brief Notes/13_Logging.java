//1. Why Logging?
    // - Track app behavior and flow 
    // - Debug issues and errors
    // - Audit actions and security events
    // - Monitor performance and usage


//2. Default Logging in Spring Boot 
// Spring Boot uses Logback as the default logging framework out of the box.
// You don't need to add dependencies manually; Spring Boot configures Logback automatically.


//3. Logging Levels 
// Logging can be configured to filter messages by level:
/*
----------------------------------------
| Level | Description                  |
| ----- | ---------------------------- |
| ERROR | Serious problems             |
| WARN  | Potential issues             |
| INFO  | General runtime events       |
| DEBUG | Detailed debugging info      |
| TRACE | Most detailed (fine-grained) |
----------------------------------------
*/ 


//4. Logging Configuration File 
// You can customize logging via:
    // application.properties
    // or Logback config files like logback-spring.xml


//5. Configuring Logging Levels in application.properties
// Set log levels for packages/classes:
/*
`properties`

logging.level.root=INFO
logging.level.org.springframework.web=DEBUG
logging.level.com.yourpackage=TRACE
*/


//6. Writing Log Messages in Code 
// Use org.slf4j.Logger and LoggerFactory
// Example: 
/*
`java`  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void process() {
        logger.info("Process started");
        try {
            // business logic
            logger.debug("Processing data");
        } catch (Exception e) {
            logger.error("Error occurred", e);
        }
        logger.info("Process finished");
    }
}
*/


//7. Log Output Destinations 
// By default, logs go to the console.
// You can configure to also log to a file:
/*
`properties`

logging.file.name=app.log
logging.file.path=/var/logs/myapp
*/


//8. Advanced Log Configuration (Optional)
// Using logback-spring.xml for advanced patterns, rolling files, 
// or multiple appenders.


//9. Best Practices 
// - ✅ Use appropriate log levels to avoid flooding logs.
// - ✅ Don’t log sensitive data like passwords.
// - ✅ Add context in logs to help debugging (user ID, request ID).
// - ✅ Use structured logging if possible (e.g., JSON format for log aggregation).
// - ✅ Rotate and archive logs to manage disk space.


//10. Practice Exercise
//i. Add logging to your UserService methods with info, debug, and error levels.
//ii. Change logging level for your package to DEBUG in application.properties.
//iii. Configure logs to be saved to a file named app.log.
//iv. Experiment with logging an exception stack trace
