/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionsDemo {

    public static void register(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("User must be atleast 18 years old");
        } else {
            System.out.println("Registration successful for user : " + name);
        }
    }

    public static void main(String[] args) {
        // Checked Exceptions -> File
        try {
            File file = new File("myfile.txt");
            FileReader fr = new FileReader(file);

        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        }

        // Unchecked Exceptions -> Array Index Out of bound
        try {
            int arr[] = {1, 2, 3};
            System.out.println(arr[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds : " + e.getMessage());
        } finally {
            System.out.println("Finally block ...");
        }

        // Custom Err Handler
        System.out.println("Demonstrating Custom Exception: ");
        String[][] users = {
            {"Madhu", "17"},
            {"Virat", "18"},
            {"Sam", "13"},
            {"Rohit", "45"}
        };

        for (String[] user : users) {
            try {
                register(user[0], Integer.parseInt(user[1]));
            } catch (InvalidAgeException e) {
                System.out.println("Custom Age Exception : " + e.getMessage());
            }
        }
    }

}
