package com.demo.simplenumbers;

public class CountAllDigits {
    public static void main(String[] args) {
        int number = 0;
        int count = countAllDigits(number);
        System.out.println("Total digits in the number "+number+" is: "+count);
    }

    private static int countAllDigits(int number) {
        //Based on a mathematical formula
        return number == 0? 1: (int) Math.floor(Math.abs(Math.log10(number) + 1));
    }

    private static int countNumberOfDigits(int number){
        int count = 0;
        if (number == 0){
            count = 1;
        }
        while (number > 0){
            number = number / 10;
            count ++;
        }
        //int count = (int) String.valueOf(number).chars().count();
        return count;
    }
}
