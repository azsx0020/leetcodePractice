package com.adohong.leetcode.practice.powxn;

// time exceeded
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || (x == 1.0d && n >= 0)) return 1;
        if (x == 0) return 0;
        double result = 1;
        for (int i = 0; i < Math.abs((long)n); i++) {
            result *= x;
        }
        return n > 0 ? result : 1.0d / result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double result = solution.myPow(2.00000, -2147483648);
        System.out.println(result);
    }
}
