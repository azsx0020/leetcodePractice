package com.adohong.leetcode.practice.firstmissingpositive;

import java.util.Arrays;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] mark = new int[nums.length];
        Arrays.fill(mark, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                mark[nums[i] - 1] = 1;
            }
        }
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] < 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        System.out.println(result);
    }
}
