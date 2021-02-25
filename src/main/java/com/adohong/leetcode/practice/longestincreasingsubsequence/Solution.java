package com.adohong.leetcode.practice.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int maxDp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] > maxDp) {
                    maxDp = dp[j];
                }
            }
            dp[i] = maxDp + 1;

        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        System.out.println(result);
    }

}
