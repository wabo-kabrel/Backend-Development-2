//1. Why Test?
// - Catch bugs early
// - Verify that your code behaves as expected
// - Prevent regressions when adding new features
// - Increase confidence before deployment


//2. Spring Boot Testing Basics
// Spring Boot provides great support for testing with the spring-boot-starter-test
// dependency, which includes:
   // - JUnit 5 (testing framework)
   // - Spring TestContext Framework (loads Spring context for integration tests)
   // - Mockito (mocking framework)
   // - AssertJ (fluent assertions)
   // - MockMvc (test your controllers without a real server)


//3. Adding Testing Dependency
// If using Maven, add this (usually included by default in Spring Boot starter projects):
/*
*xml* 
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
 */


 //4. Unit Testing a Service Class
 // Unit tests focus on testing a single class in isolation, mocking any dependencies.
 // Example: Unit test for UserService (mocking UserRepository)
    /*
    *java*  
    import static org.mockito.Mockito.*;
    import static org.assertj.core.api.Assertions.*;

    import java.util.List;
    import java.util.Arrays;

    import org.junit.jupiter.api.Test;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.junit.jupiter.MockitoExtension;

    import org.junit.jupiter.api.extension.ExtendWith;

    @ExtendWith(MockitoExtension.class)
    public class UserServiceTest {

        @Mock
        private UserRepository repo;

        @InjectMocks
        private UserService service;

        @Test
        void testGetAllUsers() {
            List<User> users = Arrays.asList(
                new User(1L, "Alice", "alice@example.com"),
                new User(2L, "Bob", "bob@example.com")
            );
            
            when(repo.findAll()).thenReturn(users);

            List<User> result = service.getAllUsers();

            assertThat(result).hasSize(2);
            assertThat(result.get(0).getName()).isEqualTo("Alice");
            verify(repo).findAll();
        }
    }
    */
    // - @Mock creates a mock instance.
    // - @InjectMocks injects mocks into the tested class.
    // - when...thenReturn defines mock behavior.
    // - assertThat verifies expectations.


//5. Integration Testing with Spring Boot
// Integration tests load the Spring application context and test the interaction 
// between components (like controllers and repositories).
// Example: Testing a REST Controller with an in-memory database
/*
*java*
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUsers() throws Exception {
        mockMvc.perform(get("/users"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());
    }
}  
 */
// - @SpringBootTest loads the full application context.
// - @AutoConfigureMockMvc sets up MockMvc to test controllers without starting a real server.
// - mockMvc.perform() sends a fake HTTP request.
// - andExpect() checks status and JSON response.


//6. Using an In-Memory Database for Testing
// Spring Boot automatically configures an H2 in-memory database for tests 
// if no other DB is configured. This keeps tests fast and isolated.
// Add this to your application-test.properties if needed:
/*
*properties*
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=create-drop
 */


//7. Testing Tips and Best Practices
// ✅ Write tests for both happy path and error cases.
// ✅ Use Mockito to isolate units in service layer tests.
// ✅ Use MockMvc for testing controllers and API endpoints.
// ✅ Keep tests small, focused, and readable.
// ✅ Run tests often during development.
// ✅ Use profiles to separate test configurations.


//8. Common Pitfalls
// ⚠ Not loading Spring context properly → tests fail or don’t behave as expected.
// ⚠ Not cleaning database state between tests → flaky tests.
// ⚠ Testing too many things in one test → harder to diagnose failures.
// ⚠ Ignoring exception cases → missing edge case coverage.


//9. Practice Exercises
//i. Write a unit test for your BookService class mocking the BookRepository.
//ii. Write an integration test for BookController using MockMvc that tests the /books GET endpoint.
//iii. Configure an in-memory H2 database for your tests and verify data persistence.
//iv. Write tests that verify behavior when a resource is not found (e.g., GET /books/{id} with 
//    invalid id).

