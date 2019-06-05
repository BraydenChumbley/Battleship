/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

/**
 *
 * @author Brayden Chumbley
 */
public class Coordinate implements Comparable<Coordinate> {
    
    private static final int X_SHIFT = 50, Y_SHIFT = 25;
    
    private int absX, absY;
    private int x, y;

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

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

    public int getAbsX() {
	return absX;
    }

    public void setAbsX(int absX) {
	this.absX = absX;
    }

    public int getAbsY() {
	return absY;
    }

    public void setAbsY(int absY) {
	this.absY = absY;
    }

}
