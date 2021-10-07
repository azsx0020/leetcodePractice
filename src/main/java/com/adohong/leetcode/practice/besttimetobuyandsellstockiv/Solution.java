package com.adohong.leetcode.practice.besttimetobuyandsellstockiv;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        k = Math.min(k, prices.length / 2);
        int[][] buy = new int[prices.length][k + 1];  // buy[i][j]表示截至到第i天进行了j次交易的情况下的最大收益。买入，交易次数不会加1；卖出交易次数才会加1
        int[][] sell = new int[prices.length][k + 1];
        for (int i = 0; i <= k; i++) {
            if (i == 0) {
                buy[0][i] = -prices[i];
                sell[0][i] = 0;
            } else {
                buy[0][i] = -1000000;
                sell[0][i] = -1000000;
            }
        }
        for (int i = 1; i < prices.length; i++) {
            sell[i][0] = 0;
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
                if (sell[prices.length - 1][i] > result) {
                    result = sell[prices.length - 1][i];
                }
        }
        return result;

    }
}
