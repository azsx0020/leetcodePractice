package com.adohong.leetcode.practice.houserobber;

public class Solution {
    public int max(int[] nums, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public int rob(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i <=1) {
                result[i] = nums[i];
            } else {
                int preMax = max(result, i - 2);
                result[i] = preMax + nums[i];
            }
        }
        return max(result, nums.length - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(result);
    }
}
