package com.adohong.leetcode.practice.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> tmpList = new ArrayList<>();
            if (i == 0) {
                tmpList.add(intervals[i][0]);
                tmpList.add(intervals[i][1]);
                resultList.add(tmpList);
            } else {
                List<Integer> lastInterval = resultList.get(resultList.size() - 1);
                if (intervals[i][0] <= lastInterval.get(1)) {
                    lastInterval.set(1, Math.max(intervals[i][1], lastInterval.get(1)));
                } else {
                    tmpList.add(intervals[i][0]);
                    tmpList.add(intervals[i][1]);
                    resultList.add(tmpList);
                }
            }
        }
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i][0] = resultList.get(i).get(0);
            result[i][1] = resultList.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 4},{2, 3}, {8, 10}, {15, 18}};
        int[][] results = solution.merge(intervals);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i][0]);
            System.out.print(" ");
            System.out.print(results[i][1]);
            System.out.println();
        }
    }
}
