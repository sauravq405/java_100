package com.demo.simplenumbers;

public class FindSecondSmallestDigit {
    public static void main(String[] args) {
        int number = 123456789;
        int secondSmallestDigit = findSmallestDigit(number);
        System.out.println("Second Smallest digit in the number "+number+" is: "+secondSmallestDigit);
    }

    private static int findSmallestDigit(int number) {
        if (number == 0) return 0;
        number = Math.abs(number);
        int smallest = 9;
        int secondSmallest = 9;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit < smallest) {
                secondSmallest = smallest;
                smallest = lastDigit;
            }
            else if (lastDigit != smallest && lastDigit < secondSmallest){
                secondSmallest = lastDigit;
            }
            number = number / 10;
        }
        // Handle case where no second smallest exists (all digits were same)
        return (secondSmallest == 9 && smallest != 9) ? smallest : secondSmallest;
    }
}
