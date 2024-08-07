/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CHINMAY GOPE
 */
public class SudokuSolver {

    public static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        int[][][] boards = {{
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        },
        {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        },
        {
            {0, 2, 0, 6, 0, 8, 0, 0, 0},
            {5, 8, 0, 0, 0, 9, 7, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 0},
            {3, 7, 0, 0, 0, 0, 5, 0, 0},
            {6, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 8, 0, 0, 0, 0, 1, 3},
            {0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 9, 8, 0, 0, 0, 3, 6},
            {0, 0, 0, 3, 0, 6, 0, 9, 0}
        },
        {
            {0, 0, 0, 0, 0, 7, 0, 9, 0},
            {1, 0, 0, 4, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 5, 0, 7, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 6, 0, 5, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 4, 0, 5, 0},
            {0, 0, 0, 2, 0, 0, 6, 0, 0}
        },
        {
            {1, 0, 0, 0, 6, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 5, 4, 0, 1},
            {0, 0, 4, 8, 0, 0, 0, 0, 0},
            {0, 0, 8, 1, 0, 0, 5, 0, 0},
            {0, 0, 0, 0, 9, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 6, 0, 4, 0},
            {5, 0, 0, 0, 0, 7, 0, 0, 0},
            {0, 7, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 4, 1, 0, 0, 0}
        }};

        for (int[][] board : boards) {
            printBoard(board);
            System.out.println(board.getClass());
            if (solveBoard(board)) {
                System.out.println("Solved successfully!");
            } else {
                System.out.println("Unsolvable board :(");
            }
            printBoard(board);
            System.out.println();
        }
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------");
            }
            for (int j = 0; j < GRID_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    private static boolean isNumInRow(int[][] board, int num, int row) {

        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumInCol(int[][] board, int num, int col) {

        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumInGrid(int[][] board, int num, int row, int col) {

        int localGridRow = row - row % 3;
        int localGridCol = col - col % 3;
        for (int i = localGridRow; i < localGridRow + 3; i++) {
            for (int j = localGridCol; j < localGridCol + 3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int num, int row, int col) {

        return !isNumInRow(board, num, row)
                && !isNumInCol(board, num, col)
                && !isNumInGrid(board, num, row, col);
    }

    private static boolean solveBoard(int[][] board) {

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValidPlacement(board, num, i, j)) {
                            board[i][j] = num;
                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
