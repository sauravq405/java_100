package com.demo.simplenumbers;

public class FindSecondLargestDigit {
    public static void main(String[] args) {
        int number = 222; //-76594238;
        int largestDigit = findLargestDigit(number);
        System.out.println("Second largest digit in the number "+number+" is: "+largestDigit);
    }

    private static int findLargestDigit(int number) {
        number = Math.abs(number);
        int largest = 0;
        int secondLargest = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit > largest) {
                secondLargest = largest;
                largest = lastDigit;
            } else if (lastDigit < largest && lastDigit > secondLargest) {
                secondLargest = lastDigit;
            }
            number = number / 10;
        }
        // Handle case where no second largest exists (all digits were same)
        return (secondLargest == 0 && largest != 0) ? largest : secondLargest;
    }
}
