package com.adohong.leetcode.practice.factorialtrailingzeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 5; i <=n ; i += 5) {
            int temp = 5;
            while (i % temp == 0) {
                result ++;
                temp *= 5;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.trailingZeroes(5);
        System.out.println(i);
    }
}
