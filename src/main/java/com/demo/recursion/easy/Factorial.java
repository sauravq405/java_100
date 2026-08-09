package com.demo.recursion.easy;

/**
 * Demonstrates calculating the factorial of a non-negative integer
 * using linear recursion and range-based divide-and-conquer recursion.
 *
 * <p>Factorial of a number <i>n</i> (denoted as <i>n!</i>) is the product of all
 * positive integers less than or equal to <i>n</i>.</p>
 */
public class Factorial {

    /**
     * Entry point of the program. Tests factorial calculations.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        int number = 6;
        long result = factorialOptimized(number);

        System.out.printf("Factorial of %d is : %d%n", number, result);
    }

    /**
     * Calculates the factorial of a non-negative integer using linear recursion.
     *
     * <p><b>Base Case:</b> If {@code n <= 1}, returns {@code 1}.<br>
     * <b>Recursive Case:</b> Returns {@code n * factorial(n - 1)}.</p>
     *
     * <p><b>Time Complexity:</b> O(n) — performs n linear recursive multiplications.<br>
     * <b>Space Complexity:</b> O(n) — requires n call stack frames.</p>
     *
     * @param n the number for which factorial is to be calculated (must be non-negative)
     * @return the factorial of {@code n} as a {@code long}
     * @throws IllegalArgumentException if {@code n} is negative
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers: " + n);
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Calculates factorial using Range-Based Divide and Conquer (Binary Splitting).
     *
     * <p>Instead of squaring (which is mathematically invalid for factorials),
     * this splits the multiplication range [1, n] in half recursively.</p>
     *
     * <p><b>Time Complexity:</b> O(n) total multiplications.<br>
     * <b>Space Complexity:</b> O(log n) call stack memory (much more balanced than linear recursion).</p>
     *
     * @param n the number for which factorial is to be calculated (must be non-negative)
     * @return the factorial of {@code n} as a {@code long}
     * @throws IllegalArgumentException if {@code n} is negative
     */
    public static long factorialOptimized(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers: " + n);
        }
        if (n <= 1) {
            return 1;
        }
        return productRange(1, n);
    }

    /**
     * Helper method to compute the product of all integers in the range [start, end].
     *
     * <p><b>Base Case 1:</b> If {@code start > end}, returns {@code 1}.<br>
     * <b>Base Case 2:</b> If {@code start == end}, returns {@code start}.<br>
     * <b>Recursive Case:</b> Splits range at midpoint and multiplies sub-range products.</p>
     *
     * @param start upper or lower inclusive range bound
     * @param end upper or lower inclusive range bound
     * @return product of numbers in range
     */
    private static long productRange(long start, long end) {
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return start;
        }

        long mid = start + (end - start) / 2;
        return productRange(start, mid) * productRange(mid + 1, end);
    }
}