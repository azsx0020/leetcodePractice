package com.adohong.leetcode.practice.removeduplicatesfromsortedarray;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int firstPointer = 0;
        int secondPointer = 1;
        for (;secondPointer < nums.length; secondPointer++) {
            if (nums[firstPointer] != nums[secondPointer]) {
                firstPointer++;
                nums[firstPointer] = nums[secondPointer];
            }
        }
        return firstPointer + 1;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
