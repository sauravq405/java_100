package com.demo.recursion.easy;

/**
 * Demonstrates calculating the sum of the first N natural numbers recursively.
 *
 * <p><b>Overall Time Complexity:</b> O(N), where N is the upper bound.<br>
 * <b>Overall Auxiliary Space Complexity:</b> O(N) due to recursion stack depth.</p>
 */
public class NaturalNumberSum {

    /**
     * Entry point of the program. Calculates and prints the sum of natural numbers
     * up to a specified range.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        int range = 100;
        long totalSum = sumUpTo(range);

        System.out.printf("Sum for first %d numbers is: %d%n", range, totalSum);
    }

    /**
     * Calculates the sum of natural numbers from 1 up to {@code range} recursively.
     *
     * <p><b>Base Case:</b> If {@code range <= 1}, returns {@code range}.<br>
     * <b>Recursive Case:</b> Returns {@code range + sumUpto(range - 1)}.</p>
     *
     * <p><b>Time Complexity:</b> O(N) — makes N recursive calls for a given range N.<br>
     * <b>Space Complexity:</b> O(N) — uses N stack frames on the call stack.</p>
     *
     * @param range the upper limit number (must be non-negative)
     * @return the sum from 1 up to {@code range} as a {@code long}
     * @throws IllegalArgumentException if {@code range} is negative
     */
    private static long sumUpTo(int range) {
        if (range < 0) {
            throw new IllegalArgumentException("Range cannot be negative: " + range);
        }
        if (range <= 1) {
            return range;
        }
        return range + sumUpTo(range - 1);
    }
}