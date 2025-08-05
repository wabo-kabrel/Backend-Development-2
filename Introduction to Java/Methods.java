/* A method(similar to a function) is a block of code designed to perform a particular task.

For example, our app can have methods like login(), logout(), convert(), etc.

The println() that we use for output is also a method. 

You can define your own methods to perform your desired tasks.

Here is an example:

static void welcome() {
  System.out.println("Welcome");
  System.out.println("I am a method");
  System.out.println("End of method");
  

- static is needed to be able to use the method in main. You will learn about the static keyword in more advanced lessons.

- void means that this method does not have a return value. You will learn more about return values later in this module.

- welcome is the name of the method.

After defining the method, we can use it in our program by "calling" it.

To call a method, type its name followed by a set of parentheses. E.g.

public class Demo {
    static void welcome() { 
        System.out.println("Welcome"); 
        System.out.println("I am a method"); 
        System.out.println("End of method"); 
    }
    public static void main(String[] args) {
        welcome();
    }
}
    
}*/
