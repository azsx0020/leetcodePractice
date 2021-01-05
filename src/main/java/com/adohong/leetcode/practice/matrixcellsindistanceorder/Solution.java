package com.adohong.leetcode.practice.matrixcellsindistanceorder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R * C][2];
        List<List<Integer>> matrixList = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                List<Integer> element = new ArrayList<>();
                element.add(i);
                element.add(j);
                matrixList.add(element);
            }
        }
        matrixList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int distance1 = Math.abs(o1.get(0) - r0) + Math.abs(o1.get(1) - c0);
                int distance2 = Math.abs(o2.get(0) - r0) + Math.abs(o2.get(1) - c0);
                return Integer.compare(distance1, distance2);
            }
        });
        for (int i = 0; i < matrixList.size(); i++) {
            matrix[i][0] = matrixList.get(i).get(0);
            matrix[i][1] = matrixList.get(i).get(1);
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.allCellsDistOrder(1, 2, 0, 0);
        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for(int j = 0; j < 2; j++) {
                System.out.print(result[i][j]);
                if(j == 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
