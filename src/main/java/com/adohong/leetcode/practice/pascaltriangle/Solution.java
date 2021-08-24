package com.adohong.leetcode.practice.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            List<Integer> resultElement = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    resultElement.add(1);
                } else {
                    resultElement.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(resultElement);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j));
                System.out.print(',');
            }
            System.out.println();
        }
    }
}