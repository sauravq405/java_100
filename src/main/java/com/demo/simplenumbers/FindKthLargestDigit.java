package com.demo.simplenumbers;

import java.util.Arrays;
import java.util.Collections;

public class FindKthLargestDigit {

    public static void main(String[] args) {
        int number = -76594238;
        int k = 0;
        int largestDigit = findKthLargestDigit(number, k);
        System.out.println(k+"-th largest digit in the number "+number+" is: "+largestDigit);
    }

    private static int findKthLargestDigit(int number, int k) {
        if (k <= 0) return -1;
        number = Math.abs(number);
        int noOfDigits = (int) Math.floor(Math.abs(Math.log10(number) + 1));
        int kthLargest = 0;
        Integer[] digitArray = new Integer[noOfDigits];
        int i = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            digitArray[i] = lastDigit;
            number = number / 10;
            i++;
        }
        Arrays.sort(digitArray, Collections.reverseOrder());
        kthLargest = digitArray[k - 1];
        return kthLargest;
    }
}
