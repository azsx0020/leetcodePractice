package com.adohong.leetcode.practice.numberof1bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (count = 0;  n != 0 ; count++) {
            n = n & (n - 1);
        }
        return count;
    }
}
