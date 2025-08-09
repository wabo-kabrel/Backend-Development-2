//1. What is Spring Security?
// Spring Security is a powerful and highly customizable framework that provides
//  authentication (verifying who you are) and authorization (controlling what you can do) for 
// Spring applications.


//2. Adding Spring Security to Your Project
// Add the dependency (Maven):
/*
`xml`

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency> 
 */


//3. Default Security Behavior
// - Once Spring Security is on the classpath, all HTTP endpoints are secured by default.
// - You must log in with a generated default username and password (shown in console at startup).
// - This behavior protects your app out-of-the-box but is usually customized.


//4. Basic Configuration — Securing Endpoints
// Create a Security configuration class:
/*
 `java`

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // allow public access
                .anyRequest().authenticated()             // secure others
            )
            .formLogin();  // enable form login
        
        return http.build();
    }
}
*/


//5. In-Memory Authentication (Users in Code)
// Add users for authentication in your config:
/*
`java`

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;

@Bean
public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("password")
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user);
} 
*/


//6. Password Encoding — Best Practice
// - Never store plain-text passwords.
// - Spring Security supports password encoders e.g., BCrypt:
/*
`java`

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
*/
// Use this encoder to hash passwords.


//7. Secure REST APIs
// For REST APIs, form login is often replaced by HTTP Basic auth or token-based authentication.
// Enable HTTP Basic:
/*
`java`

http
  .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
  .httpBasic();
*/


//8. Restricting Access by Roles 
/*
`java`

http
  .authorizeHttpRequests(auth -> auth
    .requestMatchers("/admin/**").hasRole("ADMIN")
    .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
    .anyRequest().authenticated()
  )
  .httpBasic();
 */


 //9. Handling Unauthorized Access 
 // Customize access denied responses: 
 /*
 `java`
 
 http.exceptionHandling()
    .accessDeniedPage("/access-denied");
 */
// Or use REST-friendly responses with AuthenticationEntryPoint.


//10. Real-World Use Case
// Imagine an e-commerce app:
    // - Public pages like /products open to all.
    // - Customer profile pages under /user/** require logged-in users.
    // - Admin panel /admin/** restricted to admins only
    
    
//11. Practice Exercises
//i. Add Spring Security to your existing app and secure all endpoints except /public/**
//ii. Create two in-memory users: one with role USER and another with ADMIN.
//iii. Secure /admin/** URLs to ADMIN only, /users/** to USER or ADMIN
//iv. Test with HTTP Basic authentication using Postman or curl.