// A function (Method) is a block of code that performs a specific task

// Syntax:
/*
    returnType methodName(parameters) {
    method body
    return statement (if needed)
    }

 */
public class Functions {

    // Ex1: Method without return
    public static void greet() {
        System.out.println("Hello, welcome!");
    }

    // Ex2: Method with parameters
    public static void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        greet(); // calling the greet method twice
        greet();

        sayHello("John");
        sayHello("Jane");
    }
}
