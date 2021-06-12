package com.adohong.leetcode.practice.plusone;

public class Solution {
    public int[] plusOne(int[] digits) {
        int jinwei = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int a = digits[i];
            int sum = a + jinwei;
            digits[i] = sum % 10;
            jinwei = sum / 10;
            if (jinwei == 0) {
                return digits;
            }
        }
        if (jinwei == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] results = solution.plusOne(new int[]{9, 9, 9, 9});
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
    }
}
