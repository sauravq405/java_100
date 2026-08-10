package com.demo.recursion.easy;

/**
 * Class to calculate the square root of a given non-negative integer
 * using Newton's Method (Newton-Raphson Method).
 *
 * <p>Mathematical Formula for Newton's Method:
 * <pre>
 *   x_{n+1} = 1/2 * (x_n + N / x_n)
 * </pre>
 *
 * <p>Where:
 * <ul>
 *   <li>{@code N} is the target number whose square root is to be found.</li>
 *   <li>{@code x_n} is the current guess.</li>
 *   <li>{@code x_{n+1}} is the refined next guess.</li>
 * </ul>
 */
public class SquareRoot {

    /**
     * Epsilon value defines the convergence precision threshold.
     */
    private static final double EPSILON = 0.001;

    public static void main(String[] args) {
        int number = 25;

        // Testing recursive approach
        System.out.println("Square root (Recursive) of " + number + " is: " + sqrt(number, 1.0));

        // Testing optimized iterative approach
        System.out.println("Square root (Iterative) of " + number + " is: " + sqrtOptimized(number));
    }

    /**
     * Calculates square root recursively using Newton's Method.
     *
     * <p><b>Time Complexity:</b> O(log(Precision)) ≈ O(1) practical time due to quadratic convergence.
     * <br><b>Space Complexity:</b> O(log(Precision)) call-stack frames due to recursion.
     *
     * @param number   the non-negative integer to find the square root of
     * @param oldGuess the initial or previous guess value
     * @return the calculated square root accurate within the EPSILON precision
     */
    private static double sqrt(int number, double oldGuess) {
        // Apply Newton-Raphson iteration step
        double newGuess = (oldGuess + number / oldGuess) / 2.0;

        // Base case: Stop when the absolute difference between steps is below precision threshold
        if (Math.abs(newGuess - oldGuess) < EPSILON) {
            return newGuess;
        }

        // Recursive call with updated guess
        return sqrt(number, newGuess);
    }

    /**
     * Calculates square root iteratively using Newton's Method with robust input checks.
     *
     * <p><b>Time Complexity:</b> O(log(Precision)) ≈ O(1) practical time due to quadratic convergence.
     * <br><b>Space Complexity:</b> O(1) auxiliary space as it executes in place without recursion stack.
     *
     * @param number the integer to find the square root of
     * @return the calculated square root accurate within the EPSILON precision
     * @throws IllegalArgumentException if the input number is negative
     */
    private static double sqrtOptimized(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot find square root of a negative number: " + number);
        }

        if (number == 0) {
            return 0.0;
        }

        double guess = 1.0;

        while (true) {
            double newGuess = (guess + number / guess) / 2.0;

            // Convergence check
            if (Math.abs(newGuess - guess) < EPSILON) {
                return newGuess;
            }

            guess = newGuess;
        }
    }
}