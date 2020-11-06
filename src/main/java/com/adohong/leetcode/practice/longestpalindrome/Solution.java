package com.adohong.leetcode.practice.longestpalindrome;

public class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String longestPalindrome = "";
        for(int l = 0; l < s.length(); l++) {
            for(int i = 0; i < s.length(); i++) {
                int j = i + l;
                if (j >= s.length()) continue;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && (l + 1 > longestPalindrome.length())) {
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome("babad");
    }
}
