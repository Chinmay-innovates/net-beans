/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

import java.util.HashSet;

/**
 *
 * @author CHINMAY GOPE
 */
public class Recursion2 {

    public static int n = 3;
    public static int first = -1;
    public static int last = -1;
    public static int arr[] = {1, 2, 3};
    public static String str = "abc";
    public static String abxccdff = "abxccdff";
    public static boolean[] map = new boolean[26];
    public static HashSet<String> set = new HashSet<>();
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    /**
     *
     * @param n no of towers
     * @param source source tower
     * @param helper helper tower
     * @param destination destination tower
     */
    public static void towerOfHanoi(int n, String source, String helper, String destination) {
        if (n == 1) {
            System.out.println("trsnsfer disk " + n + " from " + source + " to " + destination);
            return;
        }

        towerOfHanoi(n - 1, source, destination, helper);
        System.out.println("trsnsfer disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, helper, source, destination);
    }

    /**
     *
     * @param string input string
     * @param index
     * @param element element to find first and last occurrence
     */
    public static void findOccurence(String string, int index, char element) {

        if (index == string.length()) {
            System.out.println("first occurence: " + first);
            System.out.println("last occurence: " + last);
            return;
        }
        char currChar = string.charAt(index);
        if (currChar == element) {
            if (first == -1) {
                first = index;
            } else {
                last = index;
            }
        }
        findOccurence(string, index + 1, element);
    }

    /**
     *
     * @param string input string
     * @param index last index of the string
     */
    public static void printReverse(String string, int index) {

        if (index == 0) {
            System.out.println(string.charAt(index));
            return;
        }

        System.out.print(string.charAt(index));
        printReverse(string, index - 1);
    }

    /**
     *
     * @param arr input an integer array
     * @param index tracking index
     * @return true if arr is sorted || false
     *
     */
    public static boolean isSorted(int arr[], int index) {
//           strictly increasing
        if (index == arr.length - 1) {
            return true;
        }

        if (arr[index] >= arr[index + 1]) {
//            array is  unsorted  
            return false;
        }
        return isSorted(arr, index + 1);
    }

    /**
     *
     * @param str input string
     * @param find required character to move to end of string
     * @param idx
     * @param count track the count of required character
     * @param newString required character appends to end of the string
     */
    public static void moveAllX(String str, char find, int idx, int count, String newString) {

        if (idx == str.length()) {
            for (int i = 0; i < count; i++) {
                newString += find;
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (currChar == find) {
            count++;
            moveAllX(str, find, idx + 1, count, newString);
        } else {
            newString += currChar;
            moveAllX(str, find, idx + 1, count, newString);
        }
    }

    /**
     *
     * @param str input string
     * @param idx
     * @param newString remove duplicates from given string
     */
    public static void removeDuplicates(String str, int idx, String newString) {

        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a']) {
            removeDuplicates(str, idx + 1, newString);
        } else {
            newString += currChar;
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newString);

        }
    }

    /**
     *
     * @param str input string
     * @param idx
     * @param newString prints all subsequences of string without repeating
     * @param set hashSet of strings
     */
    public static void subSequences(String str, int idx, String newString, HashSet<String> set) {

        if (idx == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);

//        to be
        subSequences(str, idx + 1, newString + currChar, set);

//        or not to be
        subSequences(str, idx + 1, newString, set);
    }

    /**
     *
     * @param str input integer string
     * @param idx
     * @param combination prints all the combinations for the input string
     */
    public static void printCombinations(String str, int idx, String combination) {

        if (idx == str.length()) {
            System.out.println(combination);
            return;
        }

        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            printCombinations(str, idx + 1, combination + mapping.charAt(i));
        }
    }

    /**
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        towerOfHanoi(n, "S", "H", "D");

        printReverse(str, str.length() - 1);

        findOccurence(abxccdff, 0, 'f');

        System.out.println(isSorted(arr, 0));

        moveAllX(abxccdff, 'c', 0, 0, "");

        removeDuplicates(abxccdff, 0, "");

        subSequences("aaa", 0, "", set);
        
        printCombinations("24", 0, "");
    }

}
