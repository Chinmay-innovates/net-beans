/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author CHINMAY GOPE
 */
public class Board {

    final int MAX_COL = 8;
    final int MAX_ROW = 8;
    public static final int SQUARE_SIZE = 100;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

    public void draw(Graphics2D g2) {
        int c = 0;
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if (c == 0) {
                    g2.setColor(new Color(235, 236, 208));
                    c = 1;
                } else {
                    g2.setColor(new Color(119, 149, 86));
                    c = 0;
                }
                g2.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }

            if (c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }
    }

}
