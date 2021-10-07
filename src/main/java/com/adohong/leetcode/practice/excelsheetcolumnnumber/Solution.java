package com.adohong.leetcode.practice.excelsheetcolumnnumber;

public class Solution {
    public int titleToNumber(String columnTitle) {
        String reversedColumnTitle = new StringBuilder(columnTitle).reverse().toString();
        int result = 0;
        for (int i = 0; i < reversedColumnTitle.length(); i++) {
                result += (reversedColumnTitle.charAt(i) - 'A' + 1) * Math.pow(26, i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.titleToNumber("FXSHRXW");
        System.out.println(result);
    }
}
