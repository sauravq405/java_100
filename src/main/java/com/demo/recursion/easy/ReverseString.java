package com.demo.recursion.easy;

/**
 * Demonstrates reversing a string using a recursive helper method
 * with a {@link StringBuilder}.
 */
public class ReverseString {

    /**
     * Entry point of the program. Reverses a sample string and prints the result.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        String input = "Book";
        String reversed = reverse(input);

        System.out.printf("Reverse of string \"%s\" is \"%s\"%n", input, reversed);
    }

    /**
     * Reverses the given string using recursion.
     *
     * <p><b>Time Complexity:</b> O(n) - where n is the length of the input string.<br>
     * <b>Space Complexity:</b> O(n) - due to the recursion call stack depth and the O(n) space of the StringBuilder.</p>
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
     * <p><b>Time Complexity:</b> O(n) - where n is the length of the input string.<br>
     * <b>Space Complexity:</b> O(n) - due to the recursion call stack depth of n.</p>
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