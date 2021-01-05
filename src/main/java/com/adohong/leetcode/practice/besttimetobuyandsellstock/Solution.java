package com.adohong.leetcode.practice.besttimetobuyandsellstock;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        List<Integer> monoStack = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            while (monoStack.size() != 0 && monoStack.get(monoStack.size() - 1) >= prices[i]) {
                if (monoStack.get(monoStack.size() - 1) - monoStack.get(0) > result) {
                    result = monoStack.get(monoStack.size() - 1) - monoStack.get(0);
                }
                monoStack.remove(monoStack.size() - 1);
            }
            monoStack.add(prices[i]);
        }

        return monoStack.size() == 0 ? 0 : Math.max(result, monoStack.get(monoStack.size() - 1) - monoStack.get(0));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxProfit(new int[]{1, 2});
        System.out.println(result);

    }
}
