package com.adohong.leetcode.practice.uniquepaths;

public class Solution {
    public int uniquePaths(int m, int n) {

        return uniquePathsDp(m, n);

    }
    // Dynamic programming， passed
    private int uniquePathsDp(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = 1;
                    continue;
                }
                if (j == 0) {
                    result[i][j] = result[i - 1][j];
                } else {
                    int count = 0;
                    for (int k = 0; k <= i; k++) {
                        count += result[k][j - 1];
                    }
                    result[i][j] = count;
                }
            }
        }
        return result[m - 1][n - 1];
    }


    // dfs, exceed time limit
    private int uniquePathsRecursive(int m, int n, int i, int j) {
        int count = 0;
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i + 1 < m) {
            count += uniquePathsRecursive(m, n, i + 1, j);
        }
        if (j + 1 < n) {
            count += uniquePathsRecursive(m, n, i, j + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.uniquePaths(3, 2);
        System.out.println(result);
    }
}
