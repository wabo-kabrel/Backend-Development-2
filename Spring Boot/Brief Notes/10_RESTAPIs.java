//1. What is a REST API?
// - A REST API (Representational State Transfer) is a way for applications to 
// communicate over HTTP using:
// - Resources (like /users, /products)
// - HTTP Methods to define actions:
    // - GET → Retrieve
    // - POST → Create
    // - PUT → Update
    // - DELETE → Remove
// - In Spring Boot, REST APIs are created using:
    // - Controllers (@RestController)
    // - Request mappings (@GetMapping, @PostMapping, etc.)
    // - JSON serialization (automatically handled by Jackson)


//2. Creating a Simple REST Controller
/*
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello, Spring Boot REST API!";
    }
}
 */
// - @RestController → Tells Spring that this class handles HTTP requests and returns JSON (or text).
// - @RequestMapping("/hello") → Base URL path for all methods inside.


//3.  Returning JSON Data
// Spring Boot automatically converts Java objects to JSON using Jackson.
/*
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<String> getUsers() {
        return List.of("Alice", "Bob", "Charlie");
    }
}
 */
// Output (JSON):
    /*
    ["Alice", "Bob", "Charlie"]
     */


//4. Handling Path Variables
// -Use @PathVariable for dynamic URLs.
/*
@GetMapping("/{id}")
public String getUserById(@PathVariable int id) {
    return "User with ID: " + id;
}  
*/
// Request: GET /users/5 → Response: "User with ID: 5"


//5. Handling Query Parameters
// Use @RequestParam for URL parameters.
/*
@GetMapping("/search")
public String searchUser(@RequestParam String name) {
    return "Searching for user: " + name;
}  
 */
// Request: GET /users/search?name=Alice → "Searching for user: Alice"


//6. Handling POST Requests (JSON Input)
/* 
@PostMapping
public String createUser(@RequestBody User user) {
    return "User created: " + user.getName();
} 
*/

// POST Request (JSON Body):
/* 
{
  "name": "Alice",
  "email": "alice@example.com"
}
 */


//7. Integrating with the Database 
// We can connect our previous Spring Data JPA example here.
/*
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }
} 
 */
// This now stores and retrieves data from the database.


//8. Error Handling
// Use @ExceptionHandler for custom error responses.
/*
@ResponseStatus(code = HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User not found with ID " + id);
    }
}

@RestController
@RequestMapping("/users")
class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
} 
*/

// If user not found →
/*
*json*
{
  "timestamp": "2025-08-09T15:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "User not found with ID 3",
  "path": "/users/3"
}
 */

//9. Best Practices
// ✅ Always validate input (@Valid + validation annotations).
// ✅ Use proper HTTP status codes (201 for created, 404 for not found, 400 for bad request).
// ✅ Group related endpoints in the same controller.
// ✅ Never expose sensitive data in API responses.
// ✅ Use DTOs for API input/output to avoid exposing entity directly.


//10. Common Pitfalls
// ⚠ Forgetting @RequestBody → Spring won’t parse JSON input.
// ⚠ Not setting content type in requests (application/json).
// ⚠ Returning entities with lazy-loaded fields → may cause JSON serialization errors.
// ⚠ Not handling exceptions → ugly stack traces in response.


//11. Real-World Use Case
// In a banking application:
    // - GET /accounts → List accounts
    // - POST /accounts → Open new account
    // - GET /accounts/{id} → Get account details
    // - DELETE /accounts/{id} → Close account
// The controller methods use Spring Data JPA for DB access, and Spring Boot automatically
// handles JSON conversion.


//12. Practice Exercises
//i. Create a Product entity with fields: id, name, price.
//ii. Create a ProductRepository and ProductController.
//iii. Add:
        // - GET /products → list all products
        // - POST /products → add new product
        // - GET /products/{id} → get product by ID (throw 404 if not found)
//iv. Test using Postman or curl.



