/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Board;

/**
 *
 * @author CHINMAY GOPE
 */
public  class Piece {

    public BufferedImage image;
    public int x, y;
    public int col, row, prevCol, prevRow;
    public int color;

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        prevCol = col;
        prevRow = row;
    }

    public BufferedImage getImage(String imagePath) {
        try {
            System.out.println("image: "+image);
            System.out.println("path: "+imagePath);
            image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            System.out.println(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public final int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public final int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }

}
