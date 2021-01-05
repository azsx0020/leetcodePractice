package com.adohong.leetcode.practice.removeduplicatesfromsortedarray;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int firstPointer = 0;
        int secondPointer = 1;
        int size = nums.length;
        for (; firstPointer < size - 1 && secondPointer < size; ) {
            if (nums[firstPointer] == nums[secondPointer]) {
                size--;
                for (int j = secondPointer; j < size; j++) {
                    nums[j] = nums[j + 1];
                }

            } else {
                firstPointer++;
                secondPointer++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
