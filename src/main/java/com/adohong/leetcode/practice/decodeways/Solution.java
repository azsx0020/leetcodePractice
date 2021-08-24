package com.adohong.leetcode.practice.decodeways;

public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1) {
            if (s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int sum = 0;
            if (s.charAt(i) != '0') {
                sum += dp[i - 1];
            }
            if (s.charAt(i - 1) - '0' == 1 || ((s.charAt(i - 1) - '0') == 2 && s.charAt(i)  <= '6')) {
                if (i == 1) {
                    sum++;
                } else {
                    sum += dp[i - 2];
                }
            }
            dp[i] = sum;
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.numDecodings("06");
        System.out.println(result);
    }
}
