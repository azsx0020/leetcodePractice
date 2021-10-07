package com.adohong.leetcode.practice.findpeakelement;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && i != nums.length - 1) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            if (i == nums.length - 1 && i != 0) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            }
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int peakElement = solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        System.out.println(peakElement);
    }
}
