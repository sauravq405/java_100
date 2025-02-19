package com.demo.simplenumbers;

public class FindPositionOfANumber {

    public static void main(String[] args) {
        int number = 1837462958;
        int digitAtPosition = 5;
        int result = findDigitAtPositionFromLeft(number, digitAtPosition);
        System.out.println("FROM LEFT: In the number " +number+ ", required digit at position " +digitAtPosition+ " is: "+result);
        result = findDigitAtPositionFromRight(number, digitAtPosition);
        System.out.println("FROM RIGHT: In the number " +number+ ", required digit at position " +digitAtPosition+" is: "+result);
        System.out.println("No of digits: "+countNumberOfDigits(1837462958));
    }

    private static int findDigitAtPositionFromLeft(int number, int digitAtPosition) throws IllegalArgumentException{
        int foundNumber = 0;
        int totalNumberOfDigits = (int) Math.log10(number) + 1;
        int totalDigitsToBeRemoved = totalNumberOfDigits - digitAtPosition;
        int divisor = (int) Math.pow(10, totalDigitsToBeRemoved);
        int digitsLeftAfterRemoval = number / divisor;
        int lastDigit = digitsLeftAfterRemoval % 10;
        foundNumber = lastDigit;
        return foundNumber;
    }

    private static int findDigitAtPositionFromRight(int number, int digitAtPosition) throws IllegalArgumentException{
        int foundNumber = 0;
        int divisor = (int) Math.pow(10, digitAtPosition - 1);
        number = number / divisor;
        /*for(int i = 1; i <= digitAtPosition-1; i++){
            number = number /10;
        }*/
        foundNumber = number % 10;
        return foundNumber;
    }

    private static int power(int number, int power){
        int result = 1;
        for(int i=1; i <= power; i++){
            result = number * result;
        }
        //result = IntStream.rangeClosed(1, power).reduce(result, (acc, i) -> acc * number);
        return result;
    }

    private static int countNumberOfDigits(int number){
        int count = 0;
        while (number != 0){
            number = number / 10;
            count ++;
        }
        //int count = (int) String.valueOf(number).chars().count();
        return count;
    }

    private static int countNumberOfDigitsO1(int number) {
        if (number == 0) return 1; // 0 has one digit
        return (int) Math.floor(Math.log10(Math.abs(number))) + 1;
    }

    private static int powerOlogn(int number, int power) {
        if (power == 0) return 1;
        if (power < 0) {
            number = 1 / number;
            power = -power;
        }

        int result = 1;
        while (power > 0) {
            if (power % 2 == 1) { // If power is odd, multiply result with number
                result *= number;
            }
            number *= number; // Square number
            power /= 2; // Integer division by 2
        }
        return result;
    }
}
