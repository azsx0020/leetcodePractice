package com.adohong.leetcode.practice.numberofislands;

public class Solution {


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dFSTraverse(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dFSTraverse(char[][] grid, int xstart, int ystart) {
        if (grid[xstart][ystart] == '1') {
            grid[xstart][ystart] = '0';
        } else {
            return;
        }

        if (xstart - 1 >= 0) {
            dFSTraverse(grid, xstart - 1, ystart);
        }

        if (xstart + 1 < grid.length) {
            dFSTraverse(grid, xstart + 1, ystart);
        }
        if (ystart + 1 < grid[0].length) {
            dFSTraverse(grid, xstart, ystart + 1);
        }
        if (ystart - 1 >= 0) {
            dFSTraverse(grid, xstart, ystart - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][]{
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'},
        };

        int result = solution.numIslands(grid);
        System.out.println(result);
    }

}
