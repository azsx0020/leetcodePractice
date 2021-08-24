package com.adohong.leetcode.practice.sortcolors;

// 两次遍历
public class Solution {
    public void sortColors(int[] nums) {
        int pointer = findFirstNonTwoIndex(nums, nums.length);
        for (int i = 0; i < pointer; i++) {
            if (nums[i] == 2) {
                nums[i] = nums[i] ^ nums[pointer];
                nums[pointer] = nums[pointer] ^ nums[i];
                nums[i] = nums[i] ^ nums[pointer];
                pointer = findFirstNonTwoIndex(nums, pointer);
            }
        }
        pointer = findFirstZeroIndex(nums, nums.length);
        for (int i = 0; i <= pointer; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[i] ^ nums[pointer];
                nums[pointer] = nums[i] ^ nums[pointer];
                nums[i] = nums[i] ^ nums[pointer];
                pointer = findFirstZeroIndex(nums, pointer);
            }
        }
    }

    private int findFirstNonTwoIndex(int[] nums, int currentPoint) {
        int pointer = -1;

        for (int i = currentPoint - 1; i >= 0; i--) {
            if (nums[i] != 2) {
                pointer = i;
                break;
            }
        }
        return pointer;
    }

    private int findFirstZeroIndex(int[] nums, int currentPoint) {
        int pointer = -1;

        for (int i = currentPoint - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                pointer = i;
                break;
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{};
        solution.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
