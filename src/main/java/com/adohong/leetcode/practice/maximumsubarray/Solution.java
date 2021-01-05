package com.adohong.leetcode.practice.maximumsubarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currentMaxSub = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (currentMaxSub == Integer.MIN_VALUE) {
                currentMaxSub = nums[i];
            } else {
                if (currentMaxSub + nums[i] > nums[i]) {
                    currentMaxSub += nums[i];
                } else {
                    currentMaxSub = nums[i];
                }

            }
            if (currentMaxSub > result) {
                result = currentMaxSub;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(result);
    }
}
