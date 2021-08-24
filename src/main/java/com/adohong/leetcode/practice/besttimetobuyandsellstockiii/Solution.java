package com.adohong.leetcode.practice.besttimetobuyandsellstockiii;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] buy1 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buy1[i] = -prices[i];
            } else {
                buy1[i] = Math.max(buy1[i - 1], - prices[i]);
            }
        }
        int[] sell1 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                sell1[i] = 0;
            } else {
                sell1[i] = Math.max(sell1[i - 1], buy1[i] + prices[i]);
            }
        }

        int[] buy2 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buy2[i] = -prices[i];
            } else {
                buy2[i] = Math.max(buy2[i - 1], sell1[i] - prices[i]);
            }
        }

        int[] sell2 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                sell2[i] = 0;
            } else {
                sell2[i] = Math.max(sell2[i - 1], buy2[i] + prices[i]);
            }
        }
        return Math.max(Math.max(Math.max(Math.max(buy1[prices.length - 1], 0), sell1[prices.length - 1]), buy2[prices.length - 1]), sell2[prices.length - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxProfit(new int[]{2, 1, 4, 5, 2, 9, 7});
        System.out.println(result);
    }
}
