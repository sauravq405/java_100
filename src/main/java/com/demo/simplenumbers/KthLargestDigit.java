package com.demo.simplenumbers;

public class KthLargestDigit {
    // Method to find the kth largest digit in a number
    public static int findKthLargest(int number, int k) {
        // Step 1: Clarify the problem - handle negatives and validate k
        number = Math.abs(number);
        if (k <= 0) return -1; // Invalid k

        // Step 2 & 3: Use an array to track k largest digits
        int[] kLargest = new int[k];
        int length = 0; // Track how many elements are actually used

        // Extract digits and process
        while (number > 0) {
            int digit = number % 10;
            number /= 10;

            // Step 6 & 7: Update the k largest digits
            if (length < k) {
                // Array not full, add digit
                kLargest[length] = digit;
                length++;
                if (length == k) {
                    sortDescending(kLargest, length); // Sort once full
                }
            } else if (digit > kLargest[k - 1]) {
                // Array full, new digit larger than smallest
                insertAndShift(kLargest, digit, k);
            }
            // If digit <= smallest, ignore it
        }

        // Step 9: Handle edge cases
        if (length < k) {
            return -1; // Fewer than k digits
        }

        // Step 11: Return the kth element (index k-1 since 0-based)
        return kLargest[k - 1];
    }

    // Helper to sort array in descending order
    private static void sortDescending(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Helper to insert digit in right spot and shift
    private static void insertAndShift(int[] arr, int digit, int k) {
        for (int i = 0; i < k; i++) {
            if (digit > arr[i]) {
                // Shift elements right from i
                for (int j = k - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i] = digit;
                break;
            }
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test cases
        int[][] tests = {
                {3521, 3},   // Expect 2
                {987654, 3}, // Expect 7
                {3322, 2},   // Expect 2
                {12, 3},     // Expect -1 (too few digits)
                {5, 1},      // Expect 5
                {1111, 2}    // Expect -1 (no distinct 2nd)
        };

        for (int[] test : tests) {
            int number = test[0];
            int k = test[1];
            int result = findKthLargest(number, k);
            System.out.println("Number: " + number + ", k: " + k + ", kth Largest Digit: " + result);
        }
    }
}
