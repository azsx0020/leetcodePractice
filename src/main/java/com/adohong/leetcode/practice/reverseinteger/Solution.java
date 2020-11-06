package com.adohong.leetcode.practice.reverseinteger;

public class Solution {
    public int reverse(int x) {
        long absoluteX = Math.abs((long)x);
        boolean isNegative = false;
        if (absoluteX != (long) x) {
            isNegative = true;
        }
        String stringX = String.valueOf(absoluteX);
        String reversedStringAbsX = "";
        for(int i = 0; i < stringX.length(); i++) {
            reversedStringAbsX += stringX.substring(stringX.length() - 1 - i, stringX.length() - i);
        }
        long reversedX = isNegative ? 0 - Long.valueOf(reversedStringAbsX) : Long.valueOf(reversedStringAbsX);

        if (reversedX > Integer.MAX_VALUE || reversedX < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversedX;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(-2147483648);
    }
}
