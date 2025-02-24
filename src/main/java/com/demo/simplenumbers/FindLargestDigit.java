package com.demo.simplenumbers;

public class FindLargestDigit {
    public static void main(String[] args) {
        int number = -76594238;
        int largestDigit = findLargestDigit(number);
        System.out.println("Largest digit in the number "+number+" is: "+largestDigit);
    }

    private static int findLargestDigit(int number) {
        number = Math.abs(number);
        int maximum = 0;
        while (number > 0){
            int lastDigit = number % 10;
            if(lastDigit > maximum){
                maximum = lastDigit;
            }
            number = number / 10;
        }
        return maximum;
    }
}
