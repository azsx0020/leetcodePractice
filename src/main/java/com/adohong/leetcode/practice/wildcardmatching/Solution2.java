package com.adohong.leetcode.practice.wildcardmatching;

import com.adohong.leetcode.practice.firstmissingpositive.Solution;

import java.util.ArrayList;
import java.util.List;
// 动态规划
public class Solution2 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (s.length() == 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = true;
                    } else if (p.charAt(j - 1) == '*'){
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) && dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        boolean result = solution2.isMatch("abc", "a??*");
        System.out.println(result);
    }
}
