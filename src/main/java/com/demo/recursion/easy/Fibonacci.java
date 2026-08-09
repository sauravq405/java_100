package com.demo.recursion.easy;

import java.util.Arrays;

/**
 * Demonstrates generating the Fibonacci sequence using both a naive recursive approach
 * and an optimized Top-Down Dynamic Programming (Memoization) approach.
 *
 * <p>The Fibonacci sequence is a series of numbers where each number is the sum
 * of the two preceding ones, starting from 0 and 1.</p>
 *
 * <p><b>Naive Approach:</b><br>
 * <b>Time Complexity:</b> O(2<sup>n</sup>)<br>
 * <b>Space Complexity:</b> O(n) call stack depth</p>
 *
 * <p><b>Memoized (DP) Approach:</b><br>
 * <b>Time Complexity:</b> O(n)<br>
 * <b>Space Complexity:</b> O(n) for memo array and recursion stack</p>
 */
public class Fibonacci {

    private static long[] memo;

    /**
     * Entry point of the program. Prints the first 50 numbers in the Fibonacci sequence.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        int terms = 50;

        // Initialize memoization array with -1 to differentiate uncomputed states from index 0
        memo = new long[terms + 1];
        Arrays.fill(memo, -1);

        for (int i = 0; i < terms; i++) {
            System.out.print(fibOptimized(i) + " ");
        }
        System.out.println();
    }

    /**
     * Calculates the n<sup>th</sup> Fibonacci number using naive recursion.
     *
     * <p><b>Base Case:</b> If {@code n <= 1}, returns {@code n} (F(0) = 0, F(1) = 1).<br>
     * <b>Recursive Case:</b> Returns {@code fib(n - 1) + fib(n - 2)}.</p>
     *
     * <p><b>Time Complexity:</b> O(2<sup>n</sup>) — exponential execution time as each call splits into two child calls.<br>
     * <b>Space Complexity:</b> O(n) — maximum recursion depth on the call stack.</p>
     *
     * @param n the zero-based index in the Fibonacci sequence (must be non-negative)
     * @return the n<sup>th</sup> Fibonacci number as a {@code long}
     * @throws IllegalArgumentException if {@code n} is negative
     */
    private static long fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative: " + n);
        }
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Calculates the n<sup>th</sup> Fibonacci number recursively using Top-Down Dynamic Programming
     * with Memoization.
     *
     * <p><b>Base Case:</b> If {@code n <= 1}, returns {@code n}.<br>
     * <b>Memoization Check:</b> Returns precomputed value if {@code memo[n] != -1}.<br>
     * <b>Recursive Case:</b> Computes {@code fibOptimized(n - 1) + fibOptimized(n - 2)},
     * caches the result, and returns it.</p>
     *
     * <p><b>Time Complexity:</b> O(n) — computes each Fibonacci value from 0 to n exactly once.<br>
     * <b>Space Complexity:</b> O(n) — requires O(n) array storage for cached results plus O(n) call stack depth.</p>
     *
     * @param n the zero-based index in the Fibonacci sequence (must be non-negative)
     * @return the n<sup>th</sup> Fibonacci number as a {@code long}
     * @throws IllegalArgumentException if {@code n} is negative
     */
    private static long fibOptimized(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative: " + n);
        }
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        memo[n] = fibOptimized(n - 1) + fibOptimized(n - 2);
        return memo[n];
    }
}