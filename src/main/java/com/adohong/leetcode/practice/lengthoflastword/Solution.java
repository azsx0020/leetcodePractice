package com.adohong.leetcode.practice.lengthoflastword;

public class Solution {

    public int lengthOfLastWord(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int start = 0;
        int end = reversed.length();

        while (start < reversed.length() && reversed.charAt(start) == ' ') {
            start++;

        }
        for (int i = start; i < reversed.length(); i++) {
            if (reversed.charAt(i) == ' ') {
                end = i;
                break;
            }
        }
        return start == reversed.length() ? 0 : end - start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int hello_world = solution.lengthOfLastWord("  ");
        System.out.println(hello_world);
    }
}
