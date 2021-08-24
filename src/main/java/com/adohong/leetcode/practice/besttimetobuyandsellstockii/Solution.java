package com.adohong.leetcode.practice.besttimetobuyandsellstockii;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int j = 0; j < prices.length; j++) {
            int max = Math.max(prices[j] - prices[0], 0);
            for (int i = 0; i < j; i++) {
                if (i == j - 1) {
                   max = Math.max(dp[i], max);
                } else {
                    max = Math.max(dp[i] + Math.max(prices[j] - prices[i + 1], 0), max);
                }
            }
            dp[j] = max;
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxProfit(new int[]{7,6,4,3,1});
        System.out.println(result);
    }
}
