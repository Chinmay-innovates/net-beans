/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piece;

import main.GamePanel;

/**
 *
 * @author CHINMAY GOPE
 */
public class Rook extends Piece {

    public Rook(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("C:\\Users\\CHINMAY GOPE\\Documents\\NetBeansProjects\\Basicjava\\src\\piece\\w-rook.png");
        } else {
            image = getImage("C:\\Users\\CHINMAY GOPE\\Documents\\NetBeansProjects\\Basicjava\\src\\piece\\b-rook.png");

        }
    }

}
