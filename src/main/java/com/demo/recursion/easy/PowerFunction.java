package com.demo.recursion.easy;

/**
 * Demonstrates calculating exponentiation using both linear recursive
 * and optimized logarithmic recursive approaches.
 *
 * <p><b>Linear Approach Time Complexity:</b> O(P), where P is the power.<br>
 * <b>Optimized Approach Time Complexity:</b> O(log P) using Exponentiation by Squaring.<br>
 * <b>Auxiliary Space Complexity:</b> O(log P) or O(P) due to call stack depth.</p>
 */
public class PowerFunction {

    /**
     * Entry point of the program. Tests the optimized power function calculation.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        int number = 4;
        int power = 3;
        long result = powerFunctOptimized(number, power);

        System.out.printf("The value of %d to the power %d is %d%n", number, power, result);
    }

    /**
     * Calculates {@code number} raised to {@code power} using linear recursion.
     *
     * <p><b>Base Case:</b> If {@code power <= 0}, returns {@code 1}.<br>
     * <b>Recursive Case:</b> Returns {@code number * powerFunct(number, power - 1)}.</p>
     *
     * <p><b>Time Complexity:</b> O(P) — makes P linear recursive calls.<br>
     * <b>Space Complexity:</b> O(P) — requires P stack frames on the call stack.</p>
     *
     * @param number the base value
     * @param power the exponent value (must be non-negative)
     * @return {@code number} raised to the power of {@code power}
     * @throws IllegalArgumentException if {@code power} is negative
     */
    private static long powerFunct(int number, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power cannot be negative: " + power);
        }
        if (power == 0) {
            return 1;
        }
        return number * powerFunct(number, power - 1);
    }

    /**
     * Calculates {@code number} raised to {@code power} using Exponentiation by Squaring.
     *
     * <p><b>Base Case:</b> If {@code power <= 0}, returns {@code 1}.<br>
     * <b>Recursive Case:</b> Divides power by 2, calculates half result, squares it,
     * and multiplies by {@code number} if power is odd.</p>
     *
     * <p><b>Time Complexity:</b> O(log P) — halves the power problem size at each step.<br>
     * <b>Space Complexity:</b> O(log P) — stack memory depth is proportional to log<sub>2</sub>(P).</p>
     *
     * @param number the base value
     * @param power the exponent value (must be non-negative)
     * @return {@code number} raised to the power of {@code power}
     * @throws IllegalArgumentException if {@code power} is negative
     */
    private static long powerFunctOptimized(int number, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power cannot be negative: " + power);
        }
        if (power == 0) {
            return 1;
        }

        // Divide problem size in half (O(log P))
        long half = powerFunctOptimized(number, power / 2);
        long result = half * half;

        if (power % 2 != 0) {
            result *= number;
        }

        return result;
    }
}