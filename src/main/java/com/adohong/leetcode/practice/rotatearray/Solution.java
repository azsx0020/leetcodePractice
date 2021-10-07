package com.adohong.leetcode.practice.rotatearray;

public class Solution {

    public void reverseArray(int[] nums, int start, int end) {
        int mid = (end - start + 1) / 2;
        int tmp = 0;
        for (int i = 0; i < mid; i++) {
            tmp = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = tmp;
        }
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        reverseArray(nums, 0, nums.length - 1);
        k = k % nums.length;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

    }
}
