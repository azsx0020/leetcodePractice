package com.adohong.leetcode.practice.longestvalidparentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (i > 0 && s.charAt(i - 1) == '(') {
                    dp[i] =  i - 2 > 0 ? dp[i - 2] + 2 : 2;
                } else if (i > 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - 1) == ')' && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[(i - dp[i - 1] - 2)] : 0);
                } else {
                    dp[i] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.longestValidParentheses("(()())");
        System.out.println(result);
    }
}
