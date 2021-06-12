package com.adohong.leetcode.practice.powxn;

// 时间复杂度O(logn)，空间复杂度O(logn)
public class Solution2 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0d) return 1;
        if (x == 0d) return 0;

        long absN = Math.abs((long) n);
        long mod = absN % 2;
        double subResult = myPow(x, (int) (absN / 2));
        if (n > 0) {
            return subResult * subResult * (mod == 1 ? x : 1);
        } else {
                return 1.0d / (subResult * subResult * (mod == 1 ? x : 1));
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        double result = solution2.myPow(2.00000, -77);
        System.out.println(result);
    }
}
