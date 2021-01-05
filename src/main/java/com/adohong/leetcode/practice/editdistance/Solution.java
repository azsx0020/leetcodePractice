package com.adohong.leetcode.practice.editdistance;

public class Solution {


    //word1第一个位置时，不可以remove和add，只可以edit，此时的edit需特殊考虑
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int[][] distance = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            for (int j = 0; j < word1.length(); j++) {

                int removeCurrentChar =
                    (j > 0 && distance[j - 1][i] < Integer.MAX_VALUE) ? distance[j - 1][i] + 1 : Integer.MAX_VALUE;
                int addNewChar = (i > 0 && distance[j][i - 1] < Integer.MAX_VALUE) ? distance[j][i - 1] + 1: Integer.MAX_VALUE;

                int editNewChar = Integer.MAX_VALUE;
                if (i > 0 && j > 0) {
                    editNewChar = Math.min(distance[j - 1][i - 1], Integer.MAX_VALUE);
                    if (word1.charAt(j) != word2.charAt(i)) {
                        editNewChar++;
                    }
                } else if (i == 0) {
                    editNewChar = word1.charAt(j) == word2.charAt(i) ? j : j + 1;
                } else if (j == 0) {
                    editNewChar = word1.charAt(j) == word2.charAt(i) ? i : i + 1;
                }
                distance[j][i] = Math.min(Math.min(removeCurrentChar, addNewChar), editNewChar);
            }

        }
        return distance[word1.length() - 1][word2.length() - 1];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minDistance("park", "spake");
        System.out.println(result);
    }
}
