public class Arrays{
    public static void main(String[] args) {

        // Declaring and initializing an array of integers
        /* There are two ways:
         * dataType[] arrayName = {value1,...,valueN} 
         * dataType arrayName[] = {value1,...,valueN}
        */
        int[] numbers = {1, 2, 3, 4, 5};


        // Using the new keyword to create an array
        int[] arrayName = new int[5];     // creates space for 5 integers, all set to 0 by default


        // Accessing elements of the array
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);


        // Modifying elements of the array
        numbers[0] = 10;
        System.out.println("First element: " + numbers[0]);
        

        // Looping through the array
        for (int i = 0; i < numbers.length; i++) {  // i = 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            System.out.println("Element at index " + i + ": " + numbers[i]); // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        }

        // Finding an array length
        System.out.println("Length of the array: " + numbers.length);

        // Arrays of other types
        String[] names = {"John", "Jane", "Bob"};
        double[] prices = {1.99, 2.99, 3.99};
        boolean[] booleans = {true, false, true};

        
        // Multidimensional Arrays
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // Access elements
        System.out.println("First element: " + matrix[0][0]);
        System.out.println("Last element: " + matrix[2][2]);

        // Loop through
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Looping using an enhanced for (for each) loop
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}