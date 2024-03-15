package Practise;

public class PractiseSwap {

    public static void main(String[] args) {

        int[] array = new int[] { 25, 600 };

        printArray(array);
        swap(array);
        printArray(array);
    }

    private static void swap(int[] array) {
        int a = array[0];
        int b = array[1];

        a = a + b;
        b = a - b;
        a = a - b;

        array[0] = a;
        array[1] = b;

        /*
         * This code is a common way to swap the values of two variables (a and b)
         * without using a temporary variable. Let's break down the logic step by step:
         *
         * a = a + b;: In this step, the value of a is updated to the sum of its
         * original value and the value of b. Essentially, a now holds the sum of the
         * original a and b.
         *
         * b = a - b;: Now, b is updated to the difference between the new value of a
         * (which is the sum of the original a and b) and the original value of b. This
         * effectively assigns the original value of a to b.
         *
         * a = a - b;: Finally, a is updated to the difference between its new value
         * (which is the sum of the original a and b) and the new value of b (which is
         * the original value of a). This assigns the original value of b to a.
         *
         * After these three steps, a will hold the original value of b, and b will hold
         * the original value of a, effectively swapping their values without using an
         * additional temporary variable.
         */
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
