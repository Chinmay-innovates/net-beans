/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
public class MatrixInverse {

    public static void main(String[] args) {
        double[][] matrix = {
            {4, 7, 3},
            {2, 6, 5},
            {1, 2, 2},
        };

        double[][] inverse = invert(matrix);

        if (inverse != null) {
            System.out.println("Inverse of the matrix:");
            printMatrix(inverse);
        } else {
            System.out.println("Matrix is singular and cannot be inverted.");
        }
    }

    public static double[][] invert(double[][] matrix) {
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Create the augmented matrix [matrix | I]
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][i + n] = 1;
        }

        // Apply Gaussian elimination
        for (int i = 0; i < n; i++) {
            // Make the diagonal contain all 1's
            double diagonalElement = augmentedMatrix[i][i];
            if (diagonalElement == 0) {
                return null; // Singular matrix
            }
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= diagonalElement;
            }

            // Make the other rows contain 0's in the current column
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Extract the right half of the augmented matrix as the inverse
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverse;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%9.4f ", value);
            }
            System.out.println();
        }
    }
}
