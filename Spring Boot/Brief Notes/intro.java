//1. What is SPring Boot?
// At its core, Spring Boot is an extension of the Spring Framework 
// that simplifies the creation of production-grade, standalone applications. 

// While the Spring Framework provides a powerful foundation, it can sometimes be
// complex to set up due to extensive configuration. Spring Boot aims to solve this
// by providing an "opinionated" approach, meaning it makes smart, sensible defaults for you.

// Instead of:
// - Writing 20 configuration files,
// - Manually managing dependencies,
// - Configuring every tiny bean yourself

// Spring Boot says:
// "Let me guess the right setup for you based on what you want to do. 
// If you disagree, you can override it."

// Why it exists
// Before Spring Boot (just Spring Framework):
// - You had to do a lot of XML/Java config just to start.
// - It took longer to get a simple “Hello World” web app running.
// - Choosing and configuring dependencies was painful (“dependency hell”).

// Spring Boot solved this with:
// - Starters – Bundles of dependencies for specific tasks.
// - Auto-configuration – Picks defaults based on what’s in your project.
// - Embedded servers – Run apps without installing Tomcat/Jetty separately.
// - Production-ready tools – Health checks, metrics, logging, etc.

/*
 * Real-world analogy
Imagine building a car:

Old way (Spring Framework): You get an engine, tires, steering, bolts — and a manual. You assemble it all.

Spring Boot way: You get a fully assembled car that runs. If you want to swap the tires or add a spoiler, you can — but you don’t start from scratch.
 */

