package com.adohong.leetcode.practice.increasingdecreasingstring;

public class Solution2 {
    public String sortString(String s) {
        // use bucket sorting
        int[] sortedString = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sortedString[s.charAt(i) - 'a'] += 1;
        }
        StringBuilder result = new StringBuilder("");
        while (result.length() < s.length()) {
            for (int i = 0; i < sortedString.length; i++) {
                if (sortedString[i] != 0) {
                    result.append((char) (i + 'a'));
                    sortedString[i]--;
                }
            }
            for (int i = 0; i < sortedString.length; i++) {
                if (sortedString[sortedString.length - 1 - i] != 0) {
                    result.append((char) (sortedString.length - 1 - i + 'a'));
                    sortedString[sortedString.length - 1 - i]--;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String result = solution2.sortString("aaaabbbbcccc");
        System.out.println(result);
    }
}
