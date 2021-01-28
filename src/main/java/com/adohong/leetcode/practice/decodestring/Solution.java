package com.adohong.leetcode.practice.decodestring;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z') {
                result.append(s.charAt(i));
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int indexLeftBracket = s.indexOf('[', i);
                int num = Integer.valueOf(s.substring(i, indexLeftBracket));
                int indexRightBracket = findCorrespondingLeftBracket(s, indexLeftBracket);
                String subResult = decodeString(s.substring(indexLeftBracket + 1, indexRightBracket));
                for (int j = 0; j < num; j++) {
                    result.append(subResult);
                }
                i = indexRightBracket;
            }
        }
        return result.toString();
    }

    private int findCorrespondingLeftBracket(String s, int indexLeftBracket) {
        Stack<Character> stack = new Stack<>();
        for (int i = indexLeftBracket; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                stack.pop();
            }
            if (stack.size() == 0) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.decodeString("3[a2[c]]");
        System.out.println(result);
    }
}
