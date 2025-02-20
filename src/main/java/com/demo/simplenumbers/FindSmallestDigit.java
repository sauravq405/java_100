package com.demo.simplenumbers;

public class FindSmallestDigit {
    public static void main(String[] args) {
        int number = 999998999;
        int smallestDigit = findSmallestDigit(number);
        System.out.println("Smallest digit in the number "+number+" is: "+smallestDigit);
    }

    private static int findSmallestDigit(int number) {
        if (number == 0) return 0;
        number = Math.abs(number);
        int smallest = 9;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit < smallest) {
                smallest = lastDigit;
            }
            number = number / 10;
        }
        return smallest;
    }
}
