package com.adohong.leetcode.practice.climbingstairs;

public class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] results = new int[n];
        results[0] = 1;
        results[1] = 2;
        for (int i = 2; i < n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.climbStairs(3);
        System.out.println(result);
    }
}
