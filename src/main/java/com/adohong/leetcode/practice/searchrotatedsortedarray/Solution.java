package com.adohong.leetcode.practice.searchrotatedsortedarray;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (target >= nums[0]) {
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] > target || (i != 0 && nums[i] < nums[i - 1])) {
                    return -1;
                }
                if (nums[i] == target) {
                    return i;
                }
            }
        } else {
            for (int i = nums.length - 1; i > 0 ; i--) {
                if (nums[i] < target || (i != nums.length - 1 && nums[i] > nums[i + 1])) {
                    return -1;
                }
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.search(new int[]{1}, 0);
        System.out.println(result);
    }
}
