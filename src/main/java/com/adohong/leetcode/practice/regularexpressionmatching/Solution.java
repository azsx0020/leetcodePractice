package com.adohong.leetcode.practice.regularexpressionmatching;

public class Solution {

    public boolean isMatch(String s, String p) {
        if (s.equals("")) {
            boolean isMatch = true;
            for (int i = 0; i < p.length(); i++) {
                if(isMatch && p.charAt(i) != '*') {
                    isMatch = false;
                } else if(!isMatch && p.charAt(i) == '*'){
                    isMatch = true;
                } else {
                   break;
                }
            }
            return isMatch;
        } else if (p.equals("")) {
            return false;
        }

        boolean[][] result = new boolean[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
                } else if (i == 0) {
                    matchFirstElement(s.charAt(0), p, result[0]);
                } else {
                    result[i][j] = match(s, p, i, j, result);
                }
            }
        }
        return result[s.length() - 1][p.length() - 1];
    }

    private boolean match(String s, String p, int i, int j, boolean[][] result) {
        if (j == 0) {
            return false;
        } else {
            return (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') && result[i - 1][j - 1]
                    || (p.charAt(j) == '*' && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') && (result[i - 1][j - 1] || result[i][j - 1] || result[i - 1][j]))
                    || (j > 1 && p.charAt(j) == '*' && result[i][j - 2]);
        }
    }

    private void matchFirstElement(char firstChar, String p, boolean[] isMatch) {
        int indexOfbegining = 1;
        for (int i = 1; i < p.length(); i++) {
            if (indexOfbegining != 0) {
                isMatch[i] = false;
                if (p.charAt(i) == '*') {
                    isMatch[i] = isMatch[i - 1] || (i > 1 && isMatch[i - 2]);
                    indexOfbegining--;
                } else {
                    indexOfbegining++;
                }
            } else {
                isMatch[i] = (firstChar == p.charAt(i) || p.charAt(i) == '.');
                indexOfbegining++;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aaabaaaababcbccbaab", "c*c*.*c*a*..*c*"));
    }
}
