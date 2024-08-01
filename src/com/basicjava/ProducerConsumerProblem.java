/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
class SharedBuffer {

    private int buffer;
    private boolean empty = true;

    // Method to add an item to the buffer
    public synchronized void produce(int value) throws InterruptedException {
        // Wait if the buffer is not empty
        while (!empty) {
            System.out.println("Buffer full. Producer waiting...");
            wait();
        }
        buffer = value;
        empty = false;
        System.out.println("Produced: " + buffer);
        // Notify the consumer that the buffer has data
        notify();
    }

    // Method to consume an item from the buffer
    public synchronized void consume() throws InterruptedException {
        // Wait if the buffer is empty
        while (empty) {
            System.out.println("Buffer empty. Consumer waiting...");
            wait();
        }
        System.out.println("Consumed: " + buffer);
        empty = true;
        // Notify the producer that the buffer is empty
        notify();
    }
}

class Producer extends Thread {

    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int value = 0;
            while (true) {
                buffer.produce(value++);
                Thread.sleep(1000); // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {

    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1500); // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerProblem {

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
