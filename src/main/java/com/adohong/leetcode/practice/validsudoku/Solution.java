package com.adohong.leetcode.practice.validsudoku;

import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if ((!checkDuplicateNumber(board, 1, board.length, i, 0)) ||
                (!checkDuplicateNumber(board, board.length, 1, 0, i))) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkDuplicateNumber(board, 3, 3, i * 3, j * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDuplicateNumber(char[][] board, int witdth, int length, int startX, int startY) {
        HashSet<Character> set = new HashSet();
        for (int i = startX; i < startX + witdth; i++) {
            for (int j = startY; j < startY + length; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                        return false;
                }
            }
        }
        return true;
    }


}
