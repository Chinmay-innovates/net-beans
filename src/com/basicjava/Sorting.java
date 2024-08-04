/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
public class Sorting {
    
    public static int arr[] = {7, 8, 3, 1, 2};
    
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//    Time Complexity O(n^2)
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
//                    swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArray(arr);
    }

//    Time Complexity O(n^2)
    public static void selectioniSort(int arr[]) {
        
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }

//    Time Complexity O(n^2)
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
//            placement
            arr[j + 1] = current;
        }
        printArray(arr);
    }

    /**
     *
     * @param arr integer input arr
     * @param si starting index
     * @param ei ending index
     */
//    Time Complexity O(n logn)
    public static void mergeSort(int arr[], int si, int ei) {
        
        if (si >= ei) {
            return;
        }
        
        int mid = si + (ei - si) / 2;
        
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }
    
    private static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }
        
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }
        
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
        
    }
    
    public static void quickSort(int arr[], int low, int high) {
        
        if (low < high) {
            int pidx = partition(arr, low, high);
            
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[high];
        int i = low - 1;
        for (int j = 0; j < high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
//                swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        
        return i;  //pivot index
    }
    
    public static void main(String[] args) {
        bubbleSort(arr);
        selectioniSort(arr);
        insertionSort(arr);
        
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
        
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
    
}
