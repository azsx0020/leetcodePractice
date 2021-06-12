package com.adohong.leetcode.practice.jumpgame;

// time exceeded, O(n^3)
public class Solution {
    public boolean canJump(int[] nums) {
        boolean[][] marks = new boolean[nums.length][nums.length];
        for (int j = 0; j < nums.length; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    marks[i][j] = true;
                } else {
                    if ( i + nums[i] >= j) {
                        marks[i][j] = true;
                    } else {
                        marks[i][j] = false;
                        for (int k = i + 1; k < j; k++) {
                            if (marks[i][k] && marks[k][j]) {
                                marks[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return marks[0][nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.canJump(new int[]{3,2,1,0,4});
        System.out.println(result);
    }


}
