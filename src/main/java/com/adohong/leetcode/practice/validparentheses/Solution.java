package com.adohong.leetcode.practice.validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');
        parenthesesMap.put('(', ')');
        Stack<Character> leftParenthesesStack = new Stack<>();
        Stack<Character> rightParenthesesStack = new Stack<>();
        String leftParentheses = "{[(";
        String rightParentheses = "}])";
        for (int i = 0; i < s.length(); i++) {
            if (leftParentheses.contains(s.substring(i, i + 1))) {
                if (rightParenthesesStack.isEmpty()) {
                    leftParenthesesStack.push(s.charAt(i));
                } else {
                    char topChar = rightParenthesesStack.peek();
                    if (topChar == parenthesesMap.get(s.charAt(i))) {
                        rightParenthesesStack.pop();
                    } else {
                        return false;
                    }
                }
            }
            if (rightParentheses.contains(s.substring(i, i + 1))) {
                if (leftParenthesesStack.isEmpty()) {
                    return false;
                } else {
                    char topChar = leftParenthesesStack.peek();
                    if (s.charAt(i) == parenthesesMap.get(topChar)) {
                        leftParenthesesStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return leftParenthesesStack.size() == 0 && rightParenthesesStack.size() == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("()");
        System.out.print(valid);
    }

}
