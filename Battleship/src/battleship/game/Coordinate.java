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

    private int x, y;

    public Coordinate(int x, int y) {
	super();
	this.x = x * 50 + 50;
	this.y = y * 50;
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

    public int getX() {
	return x;
    }
    
    public void setX(int x){
	this.x = x;
    }

    public int getY() {
	return y;
    }
    
    public void setY(int y){
	this.y = y;
    }

}
