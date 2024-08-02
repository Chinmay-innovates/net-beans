/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */

// shapes interface
interface Drawable {

    void draw();
}

// banks interface
interface Bank {

    float rateOfInterest();
}

// shapes
class Rectangle implements Drawable {

    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}

class Circle implements Drawable {

    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}

// bank
class SBI implements Bank {

    @Override
    public float rateOfInterest() {
        return 9.15F;
    }
}

class PNB implements Bank {

    @Override
    public float rateOfInterest() {
        return 9.7F;
    }
}

public class InterfaceDemo {

    public static void main(String args[]) {
        Drawable d = new Circle();
        Drawable r = new Rectangle();
        d.draw();
        r.draw();

        SBI sbi = new SBI();
        PNB pnb = new PNB();
        System.out.println("ROI of SBI: " + sbi.rateOfInterest());
        System.out.println("ROI of PNB: " + pnb.rateOfInterest());

    }
}
