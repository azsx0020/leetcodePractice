package com.adohong.leetcode.practice.rotateimage;

public class Solution {
    public void rotate(int[][] matrix) {
        int xLimit = matrix[0].length / 2;
        for (int i = 0; i < xLimit; i++) {
            int yLimit = matrix.length - i - 1;
            for (int j = i; j < yLimit; j++) {
                if (i == j) {
                    rotateForCorner(i, j, matrix);
                } else {
                    rotateForNonCorner(i, j, matrix);
                }
            }
        }

    }

    private void rotateForNonCorner(int i, int j, int[][] matrix) {
        int spot2X = j;
        int spot2Y = matrix[0].length - 1 - i;
        int spot3X = matrix.length - i - 1;
        int spot3Y = matrix[0].length - j - 1;
        int spot4X = matrix.length - j - 1;
        int spot4Y = i;
        int tempVal = matrix[i][j];
        matrix[i][j] = matrix[spot4X][spot4Y];
        matrix[spot4X][spot4Y] = matrix[spot3X][spot3Y];
        matrix[spot3X][spot3Y] = matrix[spot2X][spot2Y];
        matrix[spot2X][spot2Y] = tempVal;
    }

    private void rotateForCorner(int i, int j, int[][] matrix) {
        int rightUpX = j;
        int rightUpY = matrix[0].length - 1 - j;
        int leftBottomX = matrix.length - 1 - i;
        int leftBottomY = i;
        int rightBottomX = matrix.length - 1 - i;
        int rightBottomY = matrix[0].length - 1 - j;
        int tempVal = matrix[i][j];
        matrix[i][j] = matrix[leftBottomX][leftBottomY];
        matrix[leftBottomX][leftBottomY] = matrix[rightBottomX][rightBottomY];
        matrix[rightBottomX][rightBottomY] = matrix[rightUpX][rightUpY];
        matrix[rightUpX][rightUpY] = tempVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
