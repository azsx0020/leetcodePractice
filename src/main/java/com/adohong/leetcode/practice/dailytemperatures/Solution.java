package com.adohong.leetcode.practice.dailytemperatures;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            result[i] = getCount(T, i);
        }
        return result;
    }

    private int getCount(int[] t, int start) {
        int result = 0;
        for (int i = start + 1; i < t.length; i++) {
            if (i != t.length - 1) {
                if (t[i] <= t[start]) {
                    result++;
                } else {
                    return result + 1;
                }
            } else {
                if (t[i] <= t[start]) {
                    return 0;
                } else {
                    return result + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%s, ",result[i]);
        }
    }
}
