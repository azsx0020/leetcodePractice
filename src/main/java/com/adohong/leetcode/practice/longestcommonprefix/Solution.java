package com.adohong.leetcode.practice.longestcommonprefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder longestPrefix = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            boolean isPartOfPrefix = true;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    isPartOfPrefix = false;
                }
            }
            if (isPartOfPrefix) {
                longestPrefix.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return longestPrefix.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(result);
    }
}
