/*
 * Brayden Tony Josh
 * May 29, 2019
 * This class handles the coordinates of the tiles
 */
package battleship.game;

/**
 *
 * @author Brayden Chumbley
 */
public class Coordinate implements Comparable<Coordinate> {
    
    private static final int X_SHIFT = (Game.WIDTH - (300 + Tile.TILE_SIZE*10))/2, Y_SHIFT = 25;
    
    private int absX, absY;
    private int x, y;

    /**
     * The coordinate of the tiles
     * @param x - The x coordinate
     * @param y - The y coordinate
     */
    public Coordinate(int x, int y) {
	super();
	this.absX = x;
	this.absY = y;
	this.x = x * Tile.TILE_SIZE + X_SHIFT;
	this.y = y * Tile.TILE_SIZE + Y_SHIFT;
    }

    @Override
    public String toString() {
	return x + "," + y;
    }

    @Override
    public int compareTo(Coordinate o) {
	if (this.x == o.x && this.y == o.y) {
	    return 0;
	} else if (this.x < o.x && this.y < o.y) {
	    return -1;
	} else {
	    return 1;
	}
    }
    
    public static Coordinate screenToCoordinate(int x, int y){
	return new Coordinate(Utils.clamp((x - X_SHIFT )/ Tile.TILE_SIZE, 0, 9), Utils.clamp((y - Y_SHIFT ) / Tile.TILE_SIZE, 0, 9));
    }
    
    public static Coordinate screenToCoordinate(int x, int y, int restrictionX, int restrictionY){
	return new Coordinate(Utils.clamp((x - X_SHIFT )/ Tile.TILE_SIZE, 0, 9 - restrictionX), Utils.clamp((y - Y_SHIFT ) / Tile.TILE_SIZE, 0, 9 - restrictionY));
    }

    /**
     * Getter for x value
     * @return -return the value of x
     */
    public int getX() {
	return x;
    }

    /**
     * Setter for x value
     * @param x - Set the value of x
     */
    public void setX(int x) {
	this.x = x;
    }

    /**
     * Getter for Y
     * @return - return of the value of Y
     */
    public int getY() {
	return y;
    }

    /**
     * Setter for y
     * @param y - set the value of y
     */
    public void setY(int y) {
	this.y = y;
    }

    /**
     * Get the absolute value of X
     * @return - return the absolute value of x
     */
    public int getAbsX() {
	return absX;
    }

    /**
     * Set the absolute value of x
     * @param absX - set the absolute value of x
     */
    public void setAbsX(int absX) {
	this.absX = absX;
    }

    /**
     * Get the absolute value of Y
     * @return - return the absolute value of x
     */
    public int getAbsY() {
	return absY;
    }

    /**
     * Set the absolute value of y
     * @param absY - set the absolute value of y
     */
    public void setAbsY(int absY) {
	this.absY = absY;
    }

}
