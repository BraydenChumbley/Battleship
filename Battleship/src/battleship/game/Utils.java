/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Brayden Chumbley
 */
public class Utils {

    /**
     * 
     * @param g
     * @param text
     * @param rect
     * @param font 
     */
    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
    
    public static Rectangle getCenteredStringBounds(JLabel lbl, String text, Rectangle rect, Font font) {
	// Get the FontMetrics
	FontMetrics metrics = lbl.getFontMetrics(font);
	// Determine the X coordinate for the text
	int x = (rect.width - metrics.stringWidth(text)) / 2;
	// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	int y = (rect.height - metrics.getHeight()) / 2;
	
	return new Rectangle(x,y, metrics.stringWidth(text), metrics.getHeight());
    }

    /**
     * Clamp value in between a max and minimum value
     * @param value The value to clamp
     * @param min The minimum value of value
     * @param max The maximum value of value
     * @return value clamped between min and max
     */
    public static int clamp(int value, int min, int max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        } else {
            return value;
        }
    }

    /**
     * Checks if the value is in range of the min and max
     * @param value - The value 
     * @param min - The minimum value
     * @param max - The maximum value
     * @return 
     */
    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    /**
     * 
     * @param board - The board
     * @param s - The ship 
     * @return - If the ship can be placed on the board return true, if not return false
     */
    public static boolean placeShip(Tile[][] board, Ship s) {

        Tile[] checkedTiles = new Tile[s.getSize()];

        try {

            for (int i = 0; i < s.getSize(); i++) {

                Tile tempTile = board[s.getPos().getAbsX() + (s.isxAlignedEh() ? i : 0)][s.getPos().getAbsY() + (!s.isxAlignedEh() ? i : 0)];

                if (tempTile.isOccupiedEh()) {

                    for (int n = 0; n < i; n++) {
                        checkedTiles[n].setOccupiedEh(false);
                    }

                    return false;
                }
                checkedTiles[i] = tempTile;
                checkedTiles[i].setOccupiedEh(true);
            }

            return true;

        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Sets the tiles that are used 
     * @param x - x coordinate of the tile
     * @param y - y coordinate of the tile
     * @param width - width of the tile
     * @param height - height of the tile
     * @param board - The game board (grid)
     * @param newState - the state of the tiles (which is occupied or not)
     */
    public static void setTilesOccupied(int x, int y, int width, int height, Tile[][] board, boolean newState) {
        for (int loopx = x; loopx < width + x; loopx++) {
            for (int loopy = y; y < height + y; loopy++) {
                try {
                    System.out.println("reseting");
                    board[loopx][loopy].setOccupiedEh(newState);
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }
    }
    
    public static void sendBoard(Tile[][] board, DataOutputStream out){
	for(int x = 0; x < 10; x++){
	    for(int y = 0; y < 10; y++){
		try {
		    out.writeInt(x);
		    out.writeInt(y);
		    out.writeBoolean(board[x][y].isOccupiedEh());
		} catch (IOException ex) {
		    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	}
    }
    
    public static Tile[][] receiveBoard(DataInputStream in){
	Tile[][] board = new Tile[10][10];
	for(int x = 0; x < 10; x++){
	    for(int y = 0; y < 10; y++){
		try {
		    board[x][y] = new Tile(in.readInt(), in.readInt());
		    board[x][y].setOccupiedEh(in.readBoolean());
		} catch (IOException ex) {
		    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	}
	System.out.println(Arrays.toString(board[0]));
	return board;
    }

}
