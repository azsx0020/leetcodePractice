package com.adohong.leetcode.practice.maxpointsonaline;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPoints(int[][] points) {
        int result = 1;
        double[][] degree = new double[points.length][points.length];
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] - points[i][0] == 0) {
                    degree[i][j] = Double.MAX_VALUE;
                } else if (points[j][1] - points[i][1] == 0) {
                    degree[i][j] = 0;
                } else {
                    degree[i][j] = ((double) (points[j][1] - points[i][1])) / ((double) (points[j][0] - points[i][0]));
                }
            }
        }
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> resultMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                if (resultMap.containsKey(degree[i][j])) {
                    resultMap.put(degree[i][j], resultMap.get(degree[i][j]) + 1);
                } else {
                    resultMap.put(degree[i][j], 2);
                }
                if (resultMap.get(degree[i][j]) > result) {
                    result = resultMap.get(degree[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxPoints(new int[][]{{4,5}, {4,-1}, {4,0}});
        System.out.println(result);
    }
}
