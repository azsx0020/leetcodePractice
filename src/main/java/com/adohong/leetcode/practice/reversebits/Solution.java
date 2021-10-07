package com.adohong.leetcode.practice.reversebits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;
            result = result | (temp << 32 - i);
            n = n >> 1;
        }
        return result;
    }
}
