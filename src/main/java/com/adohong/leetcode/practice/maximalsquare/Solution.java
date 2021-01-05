package com.adohong.leetcode.practice.maximalsquare;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int squareLimit = Math.min(matrix.length, matrix[0].length);
        int result = -1;
        boolean[][][] resultMatrix = new boolean[squareLimit][matrix.length][matrix[0].length];
        for (int l = 0; l < squareLimit; l++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (isLeftUpCorner(matrix, i, j, l)) {
                        if (isSquare(matrix, i, j, l, resultMatrix)) {
                            resultMatrix[l][i][j] = true;
                            if (l > result) {
                                result = l;
                            }
                        }
                    }
                }
            }
        }
        return (result + 1) * (result + 1);
    }

    private boolean isSquare(char[][] matrix, int indexX, int indexY, int l, boolean[][][] resultMatrix) {
        if (l == 0) {
            return matrix[indexX][indexY] == '1';
        }
        if (!resultMatrix[l - 1][indexX][indexY]) {
            return false;
        }
        if (indexX + l >= matrix.length || indexY + l >= matrix[0].length) {
            return false;
        }
        for (int i = indexX; i <= indexX + l; i++) {
            if (matrix[i][indexY + l] != '1') {
                return false;
            }
        }

        for (int i = indexY; i <= indexY + l; i++) {
            if (matrix[indexX + l][i] != '1') {
                return false;
            }
        }
        return true;

    }

    private boolean isLeftUpCorner(char[][] matrix, int i, int j, int l) {
        if (i + l < matrix.length && j + l < matrix[0].length && matrix[i][j] == '1') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maximalSquare(new char[][]{
            {'0','0','0','0','1','1','1','0','1'},{'0','0','1','1','1','1','1','0','1'},{'0','0','0','1','1','1','1','1','0'}
        });
        System.out.println(result);
    }

}
