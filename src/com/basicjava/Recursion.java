/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

import java.util.ArrayList;

/**
 *
 * @author CHINMAY GOPE
 */
public class Recursion {

    public static String str = "cos";
    public static int n = 3;
    public static int m = 3;
    public static ArrayList<Integer> subset = new ArrayList<>();

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void printPermutation(String string, String permutation) {
        if (string.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for (int i = 0; i < string.length(); i++) {
            char currentCharecter = string.charAt(i);
//            "abc"-> "ab"
            String newString = string.substring(0, i) + string.substring(i + 1);
            printPermutation(newString, permutation + currentCharecter);
        }
    }

    public static int countPaths(int i, int j, int n, int m) {
        if (i == n && j == m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        int downwardPaths = countPaths(i + 1, j, n, m);
        int rightwardPaths = countPaths(i, j + 1, n, m);
        return downwardPaths + rightwardPaths;
    }

    public static int placeTiles(int n, int m) {

        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }

//        place vertically 
        int verticalPlacements = placeTiles(n - m, m);
//        place horizontally 
        int horizontalPlacements = placeTiles(n - 1, m);

        return verticalPlacements + horizontalPlacements;

    }

    public static int callGuests(int n) {
        if (n <= 1) {
            return 1;
        }
        int callSingle = callGuests(n - 1);
        int callPair = (n - 1) * callGuests(n - 2);

        return callSingle + callPair;
    }

    public static void findSubsets(int n, ArrayList<Integer> subset) {

        if (n == 0) {
            printSubset(subset);
            return;
        }
//        can add 
        subset.add(n);
        findSubsets(n - 1, subset);

//        cannot add 
        subset.remove(subset.size() - 1);
        findSubsets(n - 1, subset);

    }

    public static void printSubset(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        get permutations
        System.out.println("Total permutations for given string " + str + " : " + factorial(str.length()));
        printPermutation(str, "");

//        get total paths from  0,0 to n,m in a n*m matrix
        int totalPaths = countPaths(0, 0, n, m);
        System.out.println(totalPaths);

//        get no.of tiles of size 1*m in a flor of size n*m
        System.out.println("Total placements : " + placeTiles(n, m));

//        get no of invites to your party
        System.out.println("Total wasys to call : " + callGuests(n));

//        get subsets of given string
        System.out.println("subsets of n = " + n);
        findSubsets(n, subset);

    }

}
