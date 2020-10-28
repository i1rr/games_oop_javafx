package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int diagCheck = 0; diagCheck < board.length; diagCheck++) {
            if (board[diagCheck][diagCheck] == 1) {
            if (monoHorizontal(board, (diagCheck)) || monoVertical(board, (diagCheck))) {
                rsl = true;
                break;
            }
            }
        }
        return rsl;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean check = true;
        for (int cell = 0; cell < board[row].length; cell++) {
            if (board[row][cell] != 1) {
                check = false;
                break;
            }
        }
        return check;
    }

    public static boolean monoVertical(int[][] board, int column) {
        boolean check = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] != 1) {
                check = false;
                break;
            }
        }
        return check;
    }
}
