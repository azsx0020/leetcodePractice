package com.adohong.leetcode.practice.maxareaofisland;

public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, maxAreaOfIslandRecursive(grid, i, j));
                }
            }
        }
        return result;
    }

    private int maxAreaOfIslandRecursive(int[][] grid, int indexX, int indexY) {
        int result = 1;
        grid[indexX][indexY] = 0;
        if ((indexX < grid.length - 1) && (grid[indexX + 1][indexY] == 1)) {
            grid[indexX + 1][indexY] = 0;
            result += maxAreaOfIslandRecursive(grid, indexX + 1, indexY);
        }
        if (indexY < grid[0].length - 1 && grid[indexX][indexY + 1] == 1) {
            grid[indexX][indexY + 1] = 0;
            result += maxAreaOfIslandRecursive(grid, indexX, indexY + 1);
        }
        if (indexX > 0 && grid[indexX - 1][indexY] == 1) {
            grid[indexX - 1][indexY] = 0;
            result += maxAreaOfIslandRecursive(grid, indexX - 1, indexY);
        }
        if (indexY > 0 && grid[indexX][indexY - 1] == 1) {
            grid[indexX][indexY - 1] = 0;
            result += maxAreaOfIslandRecursive(grid, indexX, indexY - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
            {
                0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0
            },
            {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0
            },
            {
                0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0
            },
            {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0
            },
            {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0
            },
            {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0
            },
            {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0
            },
            {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0
            }
        };
        int result = solution.maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
