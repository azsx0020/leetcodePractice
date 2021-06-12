package com.adohong.leetcode.practice.rotateimage;

import java.util.jar.JarEntry;

public class Solution2 {
    public void rotate(int[][] matrix) {
        int xLimit = matrix[0].length / 2;
        for (int i = 0; i < xLimit; i++) {
            int yLimit = matrix.length - i - 1;
            for (int j = i; j < yLimit; j++) {
                doRotate(i, j, matrix);
            }
        }

    }

    private void doRotate(int i, int j, int[][] matrix) {
        int x = i;
        int y = j;
        int tempVal = matrix[i][j];
        for (int k = 0; k < 4; k++) {
            int nextX = getNextX(x, y, matrix.length);
            int nextY = getNextY(x, y, matrix[0].length);
            if (nextX == i && nextY == j) {
                matrix[x][y] = tempVal;
            } else {
                matrix[x][y] = matrix[nextX][nextY];
            }
            x = nextX;
            y = nextY;

        }
    }

    private int getNextX(int i, int j, int n) {
        return n - j - 1;
    }

    private int getNextY(int i, int j, int n) {
        return i;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution2.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
