package com.adohong.leetcode.practice.longestsubstringwithoutrepeatingcharacters;

public class SolutionTest {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder longestSubstring = new StringBuilder();
        StringBuilder currentSubstring = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = currentSubstring.indexOf(s.substring(i, i + 1));
            if (index == -1) {
                currentSubstring.append(s.charAt(i));
            } else {
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = new StringBuilder(currentSubstring.substring(index + 1) + s.charAt(i));
            }
        }
        return Math.max(currentSubstring.length(), longestSubstring.length());
    }

    public static void main(String[] args) {
        SolutionTest solution = new SolutionTest();
        int result = solution.lengthOfLongestSubstring(" ");
        System.out.print(result);
    }

}
