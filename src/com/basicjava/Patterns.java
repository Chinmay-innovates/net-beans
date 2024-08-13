/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

import java.util.Scanner;

/**
 *
 * @author CHINMAY 
 */
public class Patterns {

    static int m = 5;
    static int n = 5;

    public static int fact(int i) {
        if (i == 0) {
            return 1;
        }
        return i * fact(i - 1);
    }

    public static void main(String[] args) {
        System.out.println("enter row and col value : ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        System.out.println("\nSolid Rectangle\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\nHollow Rectangle\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // cell -> (i,j)
                if (i == 1 || j == 1 || i == n || j == m) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("\nHalf Pyramid\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\nInverted Half Pyramid\n");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\nInverted Half Pyramid(rotated 180 deg)\n");
        for (int i = 1; i <= n; i++) {
            // inner loop -> space print
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println("\nHalf Pyramid with numbers\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\nInverted Half Pyramid  with numbers\n");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\nFloyd's Triangle \n");
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

        System.out.println("\n0-1 Triangle \n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int sum = i + j;
                if (sum % 2 == 0)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }

        System.out.println("\nButterfly Pattern\n");
        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // spaces
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // 2nd part
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        // lower half
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // spaces
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // 2nd part
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        System.out.println("\nSolid Rhombus\n");
        for (int i = 1; i < n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }

            System.out.println();

        }

        System.out.println("\nHollow Rhombus\n");
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= m; j++) {
                // cell -> (i,j)
                if (i == 1 || j == 1 || i == n || j == m) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }

        System.out.println("\nNumber Pyramid\n");
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // numbers print row no, row no. times
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();

        }

        System.out.println("\nPalindrome Pyramid\n");
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // 1st half numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            // 2nd half numbers

            // if j=1 then 1 prints twice
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\nPalindrome Pyramid | 2\n");
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // 1st half numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            // 2nd half numbers

            // if j=1 then 1 prints twice
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\nPascal Triangle\n");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print("   ");
            }

            for (int k = 0; k <= i; k++) {
                System.out.print("    " + fact(i) / (fact(i - k) * fact(k)));
            }

            System.out.println();
        }

        System.out.println("\nDaimond Pattern\n");
        // upper half of the pattern
        for (int i = 0; i <= n; i++) {
            // spaces
            for (int j = 0; j <= n - i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
        // lower half
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = 0; j <= n - i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
        System.out.println("Thankyou");
    }
}