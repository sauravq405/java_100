package com.demo.recursion.easy;

/**
 * Demonstrates palindrome checking and string reversal using recursive helper methods.
 *
 * <p><b>Overall Time Complexity:</b> O(N), where N is the length of the string.<br>
 * <b>Overall Auxiliary Space Complexity:</b> O(N) due to recursion stack depth and StringBuilder usage.</p>
 */
public class Palindrome {

    /**
     * Entry point of the program. Reverses a sample string and checks if it is a palindrome.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        String input = "Book";
        String reversed = reverse(input);
        boolean palindrome = isPalindrome(input);

        System.out.printf("Reverse of string \"%s\" is \"%s\"%n", input, reversed);
        System.out.printf("Is \"%s\" a palindrome? %b%n", input, palindrome);
    }

    /**
     * Checks whether a string reads the same forwards and backwards, ignoring case.
     *
     * <p><b>Time Complexity:</b> O(N) — requires reversing the string O(N)
     * and comparing characters O(N).<br>
     * <b>Space Complexity:</b> O(N) — stores a reversed copy of the string in memory.</p>
     *
     * @param input the string to evaluate
     * @return {@code true} if the input string is a palindrome, {@code false} otherwise
     */
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        return input.equalsIgnoreCase(reverse(input));
    }

    /**
     * Reverses the given string using recursion.
     *
     * <p><b>Time Complexity:</b> O(N) — iterates through all N characters recursively.<br>
     * <b>Space Complexity:</b> O(N) — uses O(N) recursion stack frames and O(N) StringBuilder buffer.</p>
     *
     * @param input the string to be reversed
     * @return the reversed string, or {@code null} if the input is {@code null}
     */
    public static String reverse(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder reversed = new StringBuilder();
        reverse(reversed, input.length() - 1, input);
        return reversed.toString();
    }

    /**
     * Helper method that recursively appends characters to a {@link StringBuilder}
     * in reverse order.
     *
     * <p><b>Base Case:</b> If {@code index < 0}, the method returns.<br>
     * <b>Recursive Case:</b> Appends character at {@code index} and calls itself with {@code index - 1}.</p>
     *
     * <p><b>Time Complexity:</b> O(N) — executes N recursive calls for length N.<br>
     * <b>Space Complexity:</b> O(N) call stack overhead.</p>
     *
     * @param reversed the {@link StringBuilder} accumulating the reversed characters
     * @param index current character position to append (starts at {@code input.length() - 1})
     * @param input the original string being reversed
     */
    private static void reverse(StringBuilder reversed, int index, String input) {
        if (index < 0) {
            return;
        }

        reversed.append(input.charAt(index));
        reverse(reversed, index - 1, input);
    }
}