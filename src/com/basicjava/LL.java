/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.basicjava;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author CHINMAY GOPE
 */
public class LL {

    public static LinkedList<Integer> list = new LinkedList<>();
    public static Scanner scanner = new Scanner(System.in);
    Node head;

    public class Node {

        String data;
        Node next;

        Node() {
            this.data = data;
            this.next = null;
        }
    }

    public void printlist() {
        Node currNode = head;

        while (currNode != null) {
            System.out.println(currNode.data + " -> ");
            currNode = currNode.next;
        }
    }

    public static void getIndex(int searchElement) {

        int index = list.indexOf(searchElement);

        if (index != -1) {
            System.out.println("Element " + searchElement + " found at index: " + index);
        } else {
            System.out.println("Element " + searchElement + " not found in list " + list);
        }
    }

    public static void deleteNodeGreaterThan(int num) {

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            if (it.next() > num) {
                it.remove();
            }
        }
    }

    public static void takeInput() {
        System.out.println("Enter numbers btw 1 and 50 (type 'end' to stop):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num < 50) {
                    list.add(num);
                } else {
                    System.out.println("Number out of range");
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e);
            }
        }
//        taking input and deleting nodes greater thsn 25
        deleteNodeGreaterThan(25);

        System.out.println("updated list" + list);
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;

        while (currNode.next != null) {
            Node nextNode = currNode.next;
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;

    }

    public static void main(String[] args) {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
//        takeInput();
//        getIndex(8);
//        Collections.reverse(list);
    }

}
