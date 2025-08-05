/* What is Java?
 * Java is an object oriented programming language web applications, desktop applications,
 *  and mobile applications.
 */
    
 /* Why Java?
  * Java is a popular and well-established programming language.
  * Java is easy to learn and use.
  * Java is a platform-independent language.
  */

/* Setting up the Environment
    * To run a Java program, you need to have a Java development environment installed.
    * You can download the Java development environment from Oracle's website.
    * Once you have the development environment installed, you can start coding in Java.
    * You can use an integrated development environment (IDE) like Eclipse, NetBeans or VS Code.
    * You can also use a text editor like Notepad or Vim.
*/

/* Basic Concepts
    * A class is a template for creating objects.
    * An object is an instance of a class.
    * A method is a function inside a class.
    * A constructor is a special method that is called when an object is created.
    * A variable is a container for storing data.
    * A function is a block of code that performs a specific task.
    * A parameter is a variable that is passed to a function.
*/

/* Syntax
    * Java is a programming language that uses a syntax similar to C++ or Python.
    * Every Java program starts with a class and a main method.
    * Method names should start with a lowercase letter, and follow camelCase.
    * Class names should start with a capital letter, and follow PascalCase.
    * The name of the class must be the same as the name of the file.
    * Java is a case-sensitive language, so "Hello" and "hello" are different words.
    * Every statement must end with a ;
    * Blocks are enclosed in braces {}
    * // for single-line comments, /* for multi-line comments, and /** for Javadoc comments.
    * Java doesn't require indentation, but it's strongly recommended for readability
*/


 /* First Java Program 
  * Every Java program starts with a class and a main method.
  * Here's the most basic program:
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

/*
 * public class HelloWorld: This defines a class called HelloWorld. Java is an object-oriented
 * language, so everything must be inside a class. "public" is the access modifier that tells
 * Java that the class can be accessed from outside the class. Other access modifiers include 
 * "private" and "protected". Private classes can only be accessed from within the class itself.
 * Protected classes can be accessed from within the class and from subclasses.
 * 
 * public static void main(String[] args): This is the entry point of every Java program. 
 * The Java Virtual Machine (JVM) starts execution from here.
 * void is the return type of the main method/function, which means it doesn't return any value.
 * static means that the function can be accessed without an object of the class.
 * 
 * System.out.println("Hello, World!");: The standard output stream that prints the text to the console.
 * System is the class, while println is the function which prints the text to the console.
 * Note that each line of code ends with a semicolon (;).
 * 
 */

 /*NB:
  * Java is a case-sensitive language, so "Hello" and "hello" are different words.
  * The name of the class must be the same as the name of the file.
  * The name of the class must start with a capital letter.
  * The name of the main method must be "main".
  * The main method must have no parameters.
  * The main method must have a return type of void.
  */

  /* System.out.print() vs System.out.println()
   * The difference between System.out.print() and System.out.println() is that System.out.print() 
   * does not add a new line after the output, while System.out.println() adds a new line after the output.
   
    Ex1:

    * System.out.println("Hello");
    * System.out.println("World!");

    Output:
    * Hello
    * World!


    Ex2:
    * System.out.print("Hello");
    * System.out.print("World!");

    Output:
    * HelloWorld
   
   */