package com.adohong.leetcode.practice.largestrectangleinhistogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> mono_stack_left = new Stack<>();
        Stack<Integer> mono_stack_right = new Stack<>();
        int result = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!mono_stack_left.isEmpty() && heights[mono_stack_left.peek()] >= heights[i]) {
                mono_stack_left.pop();
            }
            left[i] = mono_stack_left.isEmpty() ? -1 : mono_stack_left.peek();
            mono_stack_left.push(i);
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!mono_stack_right.isEmpty() && heights[mono_stack_right.peek()] >= heights[i]) {
                mono_stack_right.pop();
            }
            right[i] = mono_stack_right.isEmpty() ? heights.length: mono_stack_right.peek();
            mono_stack_right.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            if ((right[i] - left[i] - 1) * heights[i] > result) {
                result = (right[i] - left[i] - 1) * heights[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(result);
    }
}
