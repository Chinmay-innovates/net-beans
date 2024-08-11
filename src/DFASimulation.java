
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CHINMAY GOPE
 */
public class DFASimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter no of states :");
        int st = scanner.nextInt();

        System.out.println("Enter no of transition states :");
        int ts = scanner.nextInt();

        int q[][] = new int[st][ts];

        System.out.println("Enter transition table");

        for (int i = 0; i < st; i++) {
            System.out.println("State " + i);
            for (int j = 0; j < ts; j++) {
                q[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter Input string : ");
        String s1 = scanner.next();

        scanner.close();

        String in[] = s1.split("");

        System.out.println("transition table");
        System.out.println("\t 0 1");

        for (int i = 0; i < st; i++) {
            System.out.print("State" + i + "\t");
            for (int j = 0; j < ts; j++) {
                System.out.print("q" + q[i][j] + " ");
            }
            System.out.println();
        }

        int input[] = new int[in.length];

        for (int i = 0; i < in.length; i++) {
            if (in[i].equals("a")) {
                input[i] = 0;
            }
            if (in[i].equals("b")) {
                input[i] = 1;
            }
        }

        System.out.println("------------------");
        int initial = 0;
        int fin = (st - 1);
        int current = initial;
        int ip, nextState;

        for (int i = 0; i < in.length; i++) {
            System.out.print("q" + current + "--" + input[i] + "-->");
            ip = input[i];
            nextState = q[current][ip];
            current = nextState;
            if (i == in.length - 1) {
                System.out.println("q" + current);
            }
        }
        if (current == fin) {
            System.out.println("Accepted");
        } else {
            System.out.println("Not Accepted");
        }

    }

}
