// Spring Boot DevTools
//1.  What is DevTools?
// Spring Boot DevTools is a special development-only dependency that:
    // - Automatically restarts your app when code changes.
    // - Optionally reloads the browser for web apps.
    // - Gives you faster startup in development mode.
    // - Disables some caching so you can see changes instantly.
// 💡 Why it matters:
    // Without DevTools, every code change → stop the app → recompile → restart → reload browser.
    // With DevTools, Spring Boot restarts automatically when you save a file, and the restart
    // is much faster because of classloader tricks.


//2.  Adding DevTools
// In pom.xml (Maven):
/*
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
 */
// NB:
    // - Only add for development — Maven optional ensures it’s not included in production.
    // - If you deploy to production with DevTools, it won’t break things, but it’s unnecessary.



//3. Key Features:
//a. Automatic Restart
    // - Detects changes in classpath files (Java, resources).
    // - Restarts only the application context — not the whole JVM.
    // - Very fast because static resources (images, JS, CSS) don’t trigger a restart.
    // Example: 
        //1. Run your app.
        //2. Edit a controller method.
        //3. Save file → Spring Boot restarts automatically.
        //4. Refresh browser → Changes appear.

//b. LiveReload
    // - Refreshes your browser automatically after restart.
    // - Needs LiveReload browser extension.
    // - Works great for Thymeleaf or HTML templates.

//c. Disabling Template Caching
    // - In dev mode, Thymeleaf/Freemarker caches are turned off, so you see changes instantly
    //   without restarting.

//d. Remote DevTools
    // - You can enable DevTools on a remote server for debugging.
    // - Not recommended for production.
    // - You enable by adding `spring.devtools.remote.secret=mysecret` and connecting with the 
    //   DevTools client.


//4. Common Beginner Mistakes
// - Adding DevTools but expecting hot reload without saving → You must save the file for restart.
// - Editing non-classpath files (like README.md) → Won’t trigger restart.
// - Expecting it in production → DevTools is meant for local dev only.


//5. Real-World Example
// You’re building a REST API for a to-do app.
// Without DevTools:
    // - Edit code → Stop app → Restart → Wait 5s → Refresh browser.
// With DevTools:
    // Edit code → Save → App restarts in ~1s → Refresh (or auto-refresh) browser.
// Result: Less time waiting, more time coding.


//6. Practice Task
// - Create a Spring Boot project with:
    // spring-boot-starter-web
    // spring-boot-devtools
// - Create a /hello endpoint returning "Hello World".
// - Run the app and visit: http://localhost:8080/hello
// - Change the message in the controller to "Hello DevTools!" and save.
// - Check that the app restarts automatically and returns the updated message without manual restart.
// - (Optional) Install LiveReload extension and watch the browser refresh automatically.