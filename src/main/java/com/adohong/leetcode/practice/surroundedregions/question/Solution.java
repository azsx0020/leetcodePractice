package com.adohong.leetcode.practice.surroundedregions.question;

public class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && (board[i][j] == 'O')) {
                    markO(i, j, board);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markO(int i, int j, char[][] board) {
        board[i][j] = 'P';

        if (i > 1 && board[i - 1][j] == 'O') {
            markO(i - 1, j, board);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
            markO(i, j + 1, board);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            markO(i + 1, j, board);
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            markO(i, j - 1, board);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",  ");
            }
            System.out.println();
        }
    }
}
