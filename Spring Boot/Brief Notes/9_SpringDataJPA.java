//1. What is Spring Data JPA?
// Spring Data JPA is a framework that:
    // - Sits on top of JPA (Java Persistence API) — the Java standard for
    //   ORM (Object Relational Mapping).
    // - Works with Hibernate by default (most popular JPA implementation).
    // - Lets you work with Java objects instead of raw SQL queries.
// In plain terms:
    // It maps your database tables to Java classes so you can save(), find(), 
    // delete() without writing SQL.


//2. Why use it?
// ✅ Less boilerplate code
// ✅ Automatic SQL generation
// ✅ Works with many databases (MySQL, PostgreSQL, H2, etc.)
// ✅ Built-in CRUD (Create, Read, Update, Delete) operations
// ✅ Supports complex queries if needed


//3. Adding Spring Data JPA to Your Project
// - If you’re using Maven, add:
    /*
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
     */

// - For Gradle:
    /*
     implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
     runtimeOnly 'com.mysql:mysql-connector-j'  
     */


//4. Configuring Database Connection
// In application.properties (or .yml):
    /*
    spring.datasource.url=jdbc:mysql://localhost:3306/mydb
    spring.datasource.username=root
    spring.datasource.password=1234
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
     */

// Key settings:
    //i. spring.jpa.hibernate.ddl-auto
        // - update → automatically updates schema
        // - create → creates new tables every time (danger in prod)
        // - none → no automatic schema change
    //ii. spring.jpa.show-sql → prints SQL queries for debugging.
    

//5. Creating an Entity (Table Mapping)
// An Entity is a Java class that represents a database table.
/*
 import jakarta.persistence.*;

@Entity
@Table(name = "users") // Optional: custom table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
 */


//6. Creating a Repository
// Spring Data JPA generates CRUD methods automatically.
/*
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method example
    User findByEmail(String email);
}
 */


//7. Using the Repository in a Service
/*
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User createUser(User user) {
        return repo.save(user);
    }
}
 */

 //8. Using it in a Controller
 /*
 import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.createUser(user);
    }
}
  */

  
//9. Best Practices
// ✅ Use @Service to keep business logic separate from controllers.
// ✅ Keep @Entity classes clean (only fields, getters, setters).
// ✅ Always validate data before saving.
// ✅ For production, don’t use ddl-auto=update unless absolutely needed.
// ✅ Use DTOs (Data Transfer Objects) to avoid exposing your entity structure directly in APIs.


//10. Common Pitfalls
// ⚠ Forgetting @Id in an entity → Spring Boot won’t know the primary key.
// ⚠ Using ddl-auto=create in production → drops tables on restart.
// ⚠ Not matching property names in queries → leads to runtime errors.
// ⚠ Ignoring lazy loading → can cause LazyInitializationException.


//11. Real-World Use Case
// In an employee management system:
    // - Employee table mapped to Employee entity.
    // - EmployeeRepository handles CRUD.
    // - EmployeeService manages hiring, updating, firing employees.
    // - EmployeeController exposes REST API endpoints.



//12. Practice Exercises
//i. Create a new Book entity with fields: id, title, author, price.
//ii. Create a BookRepository that extends JpaRepository.
//iii. Create a BookService with:
    // - getAllBooks()
    // - addBook(Book book)
//iv. Create a BookController with:
    // - GET /books → returns all books
    // - POST /books → adds a new book
//v. Test with Postman or curl.
