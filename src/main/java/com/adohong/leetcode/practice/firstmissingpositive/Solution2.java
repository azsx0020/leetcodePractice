package com.adohong.leetcode.practice.firstmissingpositive;

import java.util.Arrays;

public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] <= l || nums[l] > nums.length || nums[nums[l] - 1] == nums[l]) {
                swap(nums, l, r);
                r--;
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }
        return l + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int result = solution2.firstMissingPositive(new int[]{2, 1});
        System.out.println(result);

    }
}

