package com.adohong.leetcode.practice.containerwithmostwater;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        List<Integer> integerList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            integerList.add(height[i]);
            if (height[i] > max) {
                max = height[i];
            }
        }
        int maxArea = 0;
        for (int i = 0; i < max; i++) {
            int indexStart = findFirstNotSmallerIntegerIndex(height, i + 1);
            int indexEnd = findLastNotSmallerIntegerIndex(height, i + 1);
            if (((indexEnd - indexStart) * (i + 1)) > maxArea) {
                maxArea = (indexEnd - indexStart) * (i + 1);
            }
        }
        return maxArea;
    }

    private int findLastNotSmallerIntegerIndex(int[] height, int integer) {
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= integer) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstNotSmallerIntegerIndex(int[] height, int integer) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= integer) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0};
        Solution solution = new Solution();
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }

}
