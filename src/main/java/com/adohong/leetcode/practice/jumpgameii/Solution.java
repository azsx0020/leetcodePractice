package com.adohong.leetcode.practice.jumpgameii;

public class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int current_jump_max_end = 0;
        int next_jump_max_end = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            next_jump_max_end = Math.max(next_jump_max_end, i + nums[i]);
            if (i == current_jump_max_end) {
                steps++;
                current_jump_max_end = next_jump_max_end;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        Solution solution = new Solution();
        int jump = solution.jump(nums);
        System.out.println(jump);
    }
}
