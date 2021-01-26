package com.adohong.leetcode.practice.implementstrstr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack == null || haystack.length() == 0) && needle != null && needle.length() > 0) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.equals(needle)){
            return 0;
        }
        int[] needleNext = calcNeedleNext(needle);
        for (int i = 0; i < haystack.length();) {
            for (int j = 0; j < needle.length();) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = needleNext[j];
                    }
                }
                if (j == needle.length()) {
                    return i - needle.length();
                }
                if (i == haystack.length()) {
                    return -1;
                }
            }
        }
        return -1;

    }

    private int[] calcNeedleNext(String needle) {
        int[] next = new int[needle.length()];
        for (int i = 0; i < needle.length(); i++) {
            next[i] = getNextIndex(needle, i);
        }
        return next;
    }

    private int getNextIndex(String needle, int index) {
        for (int i = index - 1; i >= 1; i--) {
            if (needle.substring(0, i).equals(needle.substring(index - i, index))) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "";
        Solution solution = new Solution();
        int result = solution.strStr(haystack, needle);
        System.out.println(result);
    }
}
