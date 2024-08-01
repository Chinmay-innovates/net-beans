/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalculateAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read date of birth
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dobInput = scanner.nextLine();

        // close the scanner object
        scanner.close();

        // Parse the date of birth
        LocalDate dob = LocalDate.parse(dobInput);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the age
        Period age = Period.between(dob, currentDate);

        // Display the age
        System.out.println(
                "You are " + age.getYears()
                + " years, " + age.getMonths()
                + " months, and " + age.getDays()
                + " days old."
        );

        scanner.close();
    }
}
