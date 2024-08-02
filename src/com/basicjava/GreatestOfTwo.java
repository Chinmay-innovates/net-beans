/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
public class GreatestOfTwo {

    static void conditionalOperator(int num1, int num2) {
        int greatest = (num1 > num2) ? num1 : num2;
        System.out.println("greatest: " + greatest);

    }

    static void ifCondition(int num1, int num2) {
        int greatest;
        if (num1 > num2) {
            greatest = num1;
        } else {
            greatest = num2;
        }
        System.out.println("greatest: " + greatest);

    }

    public static void main(String[] args) {
        System.out.println("using Conditional operator:");
        conditionalOperator(4, 6);
        conditionalOperator(15, 36);
        System.out.println("using If statement:");
        ifCondition(55, 40);
        ifCondition(55, 400);
    }
}
