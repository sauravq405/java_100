package com.demo.simplenumbers;

public class KthLargestLeetCodeSolution {


    /*
    *
    Given an integer array nums and an integer k, return the kth largest element in the array.

    Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Can you solve it without sorting?
    *
    * */

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("Kth largest digit = "+kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];

        for (int num : nums)
            count[num + 10000]++;

        for (int i = count.length - 1; i >= 0; i--)
            if (count[i] > 0) {
                k -= count[i];
                if (k <= 0) return i - 10000;
            }

        return -1;
    }
}
