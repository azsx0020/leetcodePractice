package com.adohong.leetcode.practice.dailytemperatures;

import java.util.Stack;

// Monotune Stack solution
public class Solution2 {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> monotuneStack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            maintainMonotuneStack(T, i, monotuneStack, result);
        }
        while (!monotuneStack.isEmpty()) {
            result[monotuneStack.pop()] = 0;
        }
        return result;
    }

    private void maintainMonotuneStack(int[] t, int index, Stack<Integer> monotueStack, int[] result) {
        while (!monotueStack.isEmpty() && t[monotueStack.peek()] < t[index]) {
            result[monotueStack.peek()] = index - monotueStack.peek();
            monotueStack.pop();
        }
        monotueStack.push(index);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] results = solution.dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
        for (int i = 0; i < results.length; i++) {
            System.out.printf("%s, ", results[i]);
        }

    }
}
