/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

/**
 *
 * @author CHINMAY GOPE
 */
class TicketBooking {

    private int availableTickets = 10;

    public synchronized void bookTicket(String passengerName, int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            System.out.println(passengerName + " is trying to book " + numberOfTickets + " ticket(s).");
            try {
                // Simulate the time taken to book tickets
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            availableTickets -= numberOfTickets;
            System.out.println("Successfully booked " + numberOfTickets + " ticket(s) for " + passengerName + ".");
            System.out.println("Remaining tickets: " + availableTickets);
        } else {
            System.out.println("Not enough tickets available for " + passengerName + ".");
        }
    }
}

class BookingThread extends Thread {

    private final TicketBooking ticketBooking;
    private final String passengerName;
    private final int numberOfTickets;

    public BookingThread(TicketBooking ticketBooking, String passengerName, int numberOfTickets) {
        this.ticketBooking = ticketBooking;
        this.passengerName = passengerName;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public void run() {
        ticketBooking.bookTicket(passengerName, numberOfTickets);
    }
}

public class SynchronizedTicketBooking {

    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();

        BookingThread thread1 = new BookingThread(ticketBooking, "Alice", 5);
        BookingThread thread2 = new BookingThread(ticketBooking, "Bob", 4);
        BookingThread thread3 = new BookingThread(ticketBooking, "Charlie", 3);

        thread2.start();
        thread1.start();
        thread3.start();
    }
}
