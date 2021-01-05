package com.adohong.leetcode.practice.minimumpathsum;

public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] path = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        path[0][0] = grid[i][j];
                    } else {
                        path[0][j] = path[0][j - 1] + grid[0][j];
                    }
                } else {
                    int fromUp = path[i - 1][j] + grid[i][j];
                    int fromLeft = j > 0 ? path[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    path[i][j] = Math.min(fromUp, fromLeft);
                }
            }
        }
        return path[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(result);
    }

}
