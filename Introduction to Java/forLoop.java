public class ForLoop{
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
     

        // Enhanced for Loop (for each)
        String[] fruits = {"Apple", "Banana", "Orange"};

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Break Statement
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // exit the loop when i == 5
            }
            System.out.println(i);
        }

        // Continue Statement
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // skip printing 3
            }
            System.out.println(i);
        }
    }

    // Return Statement
    public static int square(int x) {
        return x * x;
    }
    
}

