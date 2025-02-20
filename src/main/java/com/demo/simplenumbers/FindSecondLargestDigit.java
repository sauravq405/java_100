package com.demo.simplenumbers;

public class FindSecondLargestDigit {
    public static void main(String[] args) {
        int number = -76594238;
        int largestDigit = findLargestDigit(number);
        System.out.println("Second largest digit in the number "+number+" is: "+largestDigit);
    }

    private static int findLargestDigit(int number) {
        number = (int) Math.abs(number);
        int largest = 0;
        int secondLargest = 0;
        while (number > 0){
            int lastDigit = number % 10;
            if(lastDigit > largest){
                secondLargest = largest;
                largest = lastDigit;
            } else if (lastDigit < largest && lastDigit > secondLargest) {
                secondLargest = lastDigit;
            }
            number = number / 10;
        }
        return secondLargest;
    }
}
