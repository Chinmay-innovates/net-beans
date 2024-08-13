/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
class CallMe {

    synchronized void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("]");
    }
}

class Caller implements Runnable {

    String message;
    CallMe target;
    Thread thread;

    public Caller(CallMe target, String message) {
        this.target = target;
        this.message = message;
        thread = new Thread(this);
        thread.start();
    }
//
//    @Override
//    public void run() {
//        target.call(message);
//    }

//    sync Statement
    @Override
    public void run() {
        synchronized (target) {
            target.call(message);
        }
    }

}

public class SynchronizedThreadDemo {

    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller c1 = new Caller(target, "Hello");
        Caller c2 = new Caller(target, "Synchronized");
        Caller c3 = new Caller(target, "World");
        try {
            c1.thread.join();
            c2.thread.join();
            c3.thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
