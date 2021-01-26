package com.adohong.leetcode.practice.singlenumber;

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(result);

    }
}
