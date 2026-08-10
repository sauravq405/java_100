package com.demo.recursion.easy;

/**
 * Demonstrates two recursive approaches for determining whether a number
 * is prime, along with a recursive-independent implementation of the
 * square-root calculation using Newton's method.
 *
 * <p>A number is prime if it is greater than 1 and has no divisor other
 * than 1 and itself. To determine whether a number is prime, it is
 * sufficient to test divisors up to the square root of that number.
 */
public class PrimeNumber {

    /**
     * Determines the acceptable error when calculating a square root
     * using Newton's method.
     */
    private static final double EPSILON = 0.001;

    public static void main(String[] args) {
        int number = 25;

        double sqrt = sqrt(number);

        System.out.println(
                "Number " + number + " is prime number? "
                        + isPrime(number, sqrt, 2)
        );
    }

    /**
     * Determines whether a number is prime using recursion.
     *
     * <p>The method tests every possible divisor starting from 2 and
     * continues until the divisor exceeds the square root of the number.
     *
     * <p>Why is it sufficient to check only up to {@code sqrt(number)}?
     * If a number has a factor greater than its square root, its matching
     * factor must be smaller than the square root. Therefore, that smaller
     * factor would already have been discovered.
     *
     * <p>For example, for 31, the square root is approximately 5.56,
     * so only 2, 3, 4 and 5 need to be checked.
     *
     * <p><b>Time Complexity:</b> O(√n) in the worst case, because the
     * method may need to test every integer divisor from 2 through √n.
     *
     * <p><b>Space Complexity:</b> O(√n) in the worst case because each
     * recursive call creates a new stack frame.
     *
     * @param number  the number to check
     * @param sqrt    the square root of {@code number}
     * @param divideBy the current divisor being tested
     * @return {@code true} if the number is prime, otherwise {@code false}
     */
    private static boolean isPrime(int number, double sqrt, int divideBy) {

        // No divisor was found up to √n.
        if (divideBy > sqrt) {
            return true;
        }

        // A remainder of zero means the number is evenly divisible
        // by the current divisor and therefore is not prime.
        int checkDivisibility = number % divideBy;

        if (checkDivisibility == 0) {
            return false;
        }

        // Try the next possible divisor.
        return isPrime(number, sqrt, divideBy + 1);
    }

    /**
     * Determines whether a number is prime using an optimized recursive
     * approach.
     *
     * <p>This version avoids unnecessary work by handling even numbers
     * separately. Once an even number greater than 2 has been eliminated,
     * only odd divisors need to be tested.
     *
     * <p>The stopping condition:
     *
     * <pre>
     * divideBy * divideBy > number
     * </pre>
     *
     * is mathematically equivalent to:
     *
     * <pre>
     * divideBy > √number
     * </pre>
     *
     * This eliminates the need to calculate and pass the square root
     * separately.
     *
     * <p>After checking 2, the method tests only:
     *
     * <pre>
     * 3 → 5 → 7 → 9 → 11 → ...
     * </pre>
     *
     * <p><b>Time Complexity:</b> O(√n) in the worst case. Although the
     * asymptotic complexity remains O(√n), approximately half of the
     * divisor checks are eliminated because even divisors are skipped.
     *
     * <p><b>Space Complexity:</b> O(√n) in the worst case because the
     * algorithm is recursive and may create O(√n) stack frames.
     *
     * @param number   the number to check
     * @param divideBy the current odd divisor being tested
     * @return {@code true} if the number is prime, otherwise {@code false}
     */
    private static boolean isPrimeOptimized(int number, int divideBy) {

        // Numbers below 2 are not prime.
        if (number < 2) {
            return false;
        }

        // 2 is the only even prime number.
        if (number == 2) {
            return true;
        }

        // Any other even number is not prime.
        if (number % 2 == 0) {
            return false;
        }

        /*
         * Instead of calculating √number and passing it through
         * every recursive call, compare the square of the divisor
         * directly with the number.
         *
         * divideBy * divideBy > number
         *
         * is mathematically equivalent to:
         *
         * divideBy > √number
         */
        if (divideBy * divideBy > number) {
            return true;
        }

        // A zero remainder means divideBy is a factor of number.
        if (number % divideBy == 0) {
            return false;
        }

        // Only odd divisors need to be tested.
        return isPrimeOptimized(number, divideBy + 2);
    }

    /**
     * Calculates the square root of a number using Newton's method.
     *
     * <p>Newton's method repeatedly improves an initial guess using:
     *
     * <pre>
     * newGuess = (guess + number / guess) / 2
     * </pre>
     *
     * <p>The process stops when the difference between two consecutive
     * guesses is smaller than {@link #EPSILON}.
     *
     * <p>For example, calculating √20 starts with a guess of 1:
     *
     * <pre>
     * 1
     * → 10.5
     * → 6.2024
     * → 4.7136
     * → 4.4727
     * → 4.4721
     * </pre>
     *
     * <p><b>Time Complexity:</b> Approximately O(log log n) iterations
     * for a fixed precision once Newton's method enters its quadratic
     * convergence region. Each iteration performs a constant number of
     * arithmetic operations.
     *
     * <p><b>Space Complexity:</b> O(1), because the calculation is
     * iterative and uses only a fixed number of variables.
     *
     * @param number the number whose square root is required
     * @return the approximate square root of {@code number}
     * @throws IllegalArgumentException if {@code number} is negative
     */
    private static double sqrt(int number) {

        if (number < 0) {
            throw new IllegalArgumentException(
                    "Cannot find square root of a negative number: " + number
            );
        }

        if (number == 0) {
            return 0.0;
        }

        // Initial approximation.
        double guess = 1.0;

        while (true) {

            // Newton's formula:
            // x(n+1) = 1/2 * (x(n) + number / x(n))
            double newGuess = (guess + number / guess) / 2.0;

            // Stop when consecutive guesses are sufficiently close.
            if (Math.abs(newGuess - guess) < EPSILON) {
                return newGuess;
            }

            // Use the improved guess for the next iteration.
            guess = newGuess;
        }
    }
}
