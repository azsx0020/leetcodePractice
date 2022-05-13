package com.adohong.leetcode.practice.happynumber;

public class Solution {
    public boolean isHappy(int n) {
        String numberStr = String.valueOf(n);
        int maxLimit = 1000;
        int count = 0;
        while (!numberStr.equals("1")) {
            long result = 0;
            for (int i = 0; i < numberStr.length(); i++) {
                int t = numberStr.charAt(i) - '0';
                result += t * t;
            }
            numberStr = String.valueOf(result);
            count++;
            if (count > maxLimit) return false;
        }
        return true;

    }
}
