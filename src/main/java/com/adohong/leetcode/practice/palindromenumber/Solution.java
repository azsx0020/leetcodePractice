package com.adohong.leetcode.practice.palindromenumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String stringX = String.valueOf(x);
        String reversedStringX = new StringBuffer().append(stringX).reverse().toString();
        return stringX.equals(reversedStringX);
    }
}
