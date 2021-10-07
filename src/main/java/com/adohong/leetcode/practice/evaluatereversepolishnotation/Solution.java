package com.adohong.leetcode.practice.evaluatereversepolishnotation;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operaters = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!operaters.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int secondNumber = stack.pop();
                int firstNumber = stack.pop();
                int result = Integer.MAX_VALUE;
                switch (tokens[i].charAt(0)) {
                    case '+':
                        result = firstNumber + secondNumber;
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        break;
                    case '/':
                        result = firstNumber / secondNumber;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(result);
    }
}
