package com.adohong.leetcode.practice.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        String[] arrays = new String[]{"right", "next", "left", "up"};
        boolean[][] markMatrix = new boolean[matrix.length][matrix[0].length];
        int[] lastestMark = new int[]{0, 0};
        List<Integer> integers = new ArrayList<>();
        integers.add(matrix[0][0]);
        markMatrix[0][0] = true;
        for (int i = 1, j = 0; i < matrix.length * matrix[0].length;) {
            int value = Integer.MIN_VALUE;
            while ((value = move(arrays[j % 4], lastestMark, markMatrix, matrix)) != Integer.MIN_VALUE) {
                integers.add(value);
                i++;
            }
            j++;
        }
        return integers;
    }

    private int move(String direction, int[] latestMark, boolean[][] markMatrix, int[][] matrix) {
        switch (direction) {
            case "right":
                if (latestMark[1] + 1 < markMatrix[0].length && !markMatrix[latestMark[0]][latestMark[1] + 1]) {
                    latestMark[1]++;
                    markMatrix[latestMark[0]][latestMark[1]] = true;
                    return matrix[latestMark[0]][latestMark[1]];
                } else {
                    return Integer.MIN_VALUE;
                }
            case "next":
                if (latestMark[0] + 1 < markMatrix.length && !markMatrix[latestMark[0] + 1][latestMark[1]]) {
                    latestMark[0]++;
                    markMatrix[latestMark[0]][latestMark[1]] = true;
                    return matrix[latestMark[0]][latestMark[1]];
                } else {
                    return Integer.MIN_VALUE;
                }
            case "left":
                if (latestMark[0] - 1 >= 0 && !markMatrix[latestMark[0] - 1][latestMark[1]]) {
                    latestMark[0]--;
                    markMatrix[latestMark[0]][latestMark[1]] = true;
                    return matrix[latestMark[0]][latestMark[1]];
                } else {
                    return Integer.MIN_VALUE;
                }
            case "up":
                if (latestMark[1] - 1 >= 0 && !markMatrix[latestMark[0]][latestMark[1] - 1]) {
                    latestMark[1]--;
                    markMatrix[latestMark[0]][latestMark[1]] = true;
                    return matrix[latestMark[0]][latestMark[1]];
                } else {
                    return Integer.MIN_VALUE;
                }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};
        Solution solution = new Solution();
        List<Integer> integers = solution.spiralOrder(matrix);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
