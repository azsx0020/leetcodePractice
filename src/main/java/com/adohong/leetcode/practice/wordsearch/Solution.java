package com.adohong.leetcode.practice.wordsearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existRecursive(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existRecursive(char[][] board, int i, int j, String word, int index, boolean[][] mark) {
        if (board[i][j] == word.charAt(index)) {
            mark[i][j] = true;
            if (index == word.length() - 1) {
                return true;
            }
        } else {
            return false;
        }
        if (j < board[0].length - 1 && !mark[i][j + 1]
                && existRecursive(board, i, j + 1, word, index + 1, mark)) {
            return true;
        }

        if (i < board.length - 1 && !mark[i + 1][j]
                && existRecursive(board, i + 1, j, word, index + 1, mark)) {
            return true;
        }

        if (j > 0 && !mark[i][j - 1]
                && existRecursive(board, i, j - 1, word, index + 1, mark)) {
            return true;
        }

        if (i > 0 && !mark[i - 1][j]
                && existRecursive(board, i - 1, j, word, index + 1, mark)) {
            return true;
        }
        mark[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCEFSADEESE");
        System.out.println(result);

    }
}
