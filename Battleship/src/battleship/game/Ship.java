/*
 * Tony Josh Brayden
 * June 4 2019
 * This class is for ships
 */

package battleship.game;

import java.awt.Color;
import java.awt.Graphics;


public class Ship extends AbstractGameObject {
    
    private int size;
    private boolean xAlignedEh;
    
    
    /**
     * Second Constructor for the ship 
     * @param coord - The coordinates of the ship
     * @param size - The size of the ship
     * @param xAlignedEh - The alignment of the ship
     */
    public Ship(Coordinate coord, int size, boolean xAlignedEh){
	this.size = size;
	this.xAlignedEh = xAlignedEh;
	pos = coord;
	//t.setOccupiedEh(true);
    }

    /**
     * This is to keep the values updated
     * @param game - The game is being updated
     */
    @Override
    public void update(Game game) {
        
    }

    /**
     * This method draws the ships
     * @param g - g is the graphics object
     */
    @Override
    public void draw(Graphics g) {
	g.setColor(Color.YELLOW); //The ship will be yellow
	for(int i = 0; i < size; i++){
	    Coordinate tempCoord = new Coordinate(pos.getAbsX() + i * (xAlignedEh? 1 : 0), pos.getAbsY() + i * (xAlignedEh? 0 : 1));
	    g.fillRect(tempCoord.getX()+1, tempCoord.getY()+1, Tile.TILE_SIZE-2, Tile.TILE_SIZE-2);
	}
    }

    /**
     * Get the size of the ship
     * @return - Return the size
     */
    public int getSize() {
	return size;
    }

    /**
     * Set the size of the ship
     * @param size - The size of the ship
     */
    public void setSize(int size) {
	this.size = size;
    }

    /**
     * This boolean checks if the ship is straight or horizontal 
     * @return - returns true or false
     */
    public boolean isxAlignedEh() {
	return xAlignedEh;
    }

    /**
     * Set whether the ship is aligned
     * @param xAlignedEh 
     */
    public void setxAlignedEh(boolean xAlignedEh) {
	this.xAlignedEh = xAlignedEh;
    }
    
}
