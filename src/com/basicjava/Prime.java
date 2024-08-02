/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
public class Prime {

    static void checkPrime(int n) {
        int i, m = 0;
        boolean flag = false;
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.println(n + " is not prime number");
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not prime number");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(n + " is prime number");
            }
        }
    }

    public static void main(String[] args) {
        checkPrime(1);
        checkPrime(3);
        checkPrime(17);
        checkPrime(20);
        checkPrime(1);
        checkPrime(3);
        checkPrime(45);
        checkPrime(21);
        checkPrime(0);
        checkPrime(65);
        checkPrime(90);
    }
}
