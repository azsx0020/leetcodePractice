package com.adohong.leetcode.practice.zigzagconversion;

public class Solution {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 1) return s;
        String[] rows = new String[numRows];
        int currentRow = 0;
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            if (rows[currentRow] == null) {
                rows[currentRow] = s.substring(i, i + 1);
            } else {
                rows[currentRow] += s.substring(i, i + 1);
            }
            if (i != 0 && currentRow == 0) {
                step = 1;
            } else if (i != 0 && currentRow == numRows - 1) {
                step = -1;
            }
            if (numRows != 1) {
                currentRow +=step;
            }
        }
        String result = "";
        for(int i = 0; i < numRows; i++) {
            if (rows[i] != null) {
                result += rows[i];
            }
        }
        return result;
    }

    public static void main(String[] args)  {
        Solution solution = new Solution();
        solution.convert("PAYPALISHIRING", 3);
    }

}
