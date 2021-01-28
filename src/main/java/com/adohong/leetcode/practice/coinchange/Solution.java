package com.adohong.leetcode.practice.coinchange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] ints) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (ints[amount - 1] != 0) {
            return ints[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, ints);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        ints[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return ints[amount - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int result = solution.coinChange(coins, 11);
        System.out.println(result);
    }
}
