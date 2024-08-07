
import java.util.Random;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CHINMAY GOPE
 */
public class NQueens {

    private final int size;
    private final int[] board;

    public NQueens(int size) {
        this.size = size;
        board = new int[size];
    }

    public void solve() {
        if (placeQueens(0)) {
            printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean placeQueens(int row) {
        if (row == size) {
            return true;
        }

        for (int col = 0; col < size; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                if (placeQueens(row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8;
        NQueens nQueens = new NQueens(N);
        nQueens.solve();
    }
}
