public class Operators {
    public static void main(String[] args) {
        // Arithmetic Operators
        int a = 7;
        int b = 5;

        int c = a + b;
        System.out.println("Sum: " + c);

        int d = a - b;
        System.out.println("Difference: " + d);

        int e = a * b;
        System.out.println("Product: " + e);

        double f = (double) a / b;      // Convert a to double to avoid integer division.
        System.out.println("Quotient: " + f);   // Normal quotient division. Output will be 1.4.

        int f2 = a / b;
        System.out.println("Integer Quotient: " + f2);  // Integer division. Output will be 1

        float a2 = 2.0f; // Define a float variable
        float b2 = 3.0f; // Define another float variable
        float f3 = a2 / b2;
        System.out.println("Float Quotient: " + f3);  // Float division. Output will be 1

        int g = a % b;
        System.out.println("Remainder: " + g);


        // Assignment Operators
        int h = 10;

        h += 5; // h = h + 5
        System.out.println("h: " + h);

        h -= 3; // h = h - 3
        System.out.println("h: " + h);

        h *= 2; // h = h * 2
        System.out.println("h: " + h);

        h /= 4; // h = h / 4
        System.out.println("h: " + h);

        h %= 3; // h = h % 3
        System.out.println("h: " + h);

         // Logical Operators
        /*
        * &&       Logical AND
        * !        Logical NOT
        * ||       Logical OR
        */
        a = 6;
        b = 9;
        System.out.println(a > 5 && b < 10); // true
        System.out.println(a > 5 || b > 10); // true
        System.out.println(!(a > 5));        // false

        // Relational Operators
        /*
        * ==       Equal to
        * !=       Not equal to
        * >        Greater than
        * <        Less than
        * >=       Greater than or equal to
        * <=       Less than or equal to
        */
        System.out.println(a == b); // false
        System.out.println(a != b); // true
        System.out.println(a > b);  // false
        System.out.println(a < b);  // true
        System.out.println(a >= b); // false
    }
     
}
