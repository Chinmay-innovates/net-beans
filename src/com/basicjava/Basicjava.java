/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.basicjava;

import java.util.Scanner;

/**
 *
 * @author CHINMAY
 */
class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showPersonData() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}

class Employee extends Person {

    double sal;

    public Employee(String name, int age, double salary) {
        super(name, age);
        sal = salary;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Double getSal() {
        return sal;
    }

    void showEmployeeData() {

        super.showPersonData();
        System.out.println("Salary : " + sal);
    }

}

public class Basicjava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Person p = new Person("Chinmay", 24);

        Employee e = new Employee("Shami", 34, 24000.435);

        e.showEmployeeData();
        p.showPersonData();

    }

}
