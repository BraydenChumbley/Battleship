/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Brayden Chumbley
 */
public class Ship extends AbstractGameObject {
    
    private int size;
    private boolean xAlignedEh;
    
    public Ship(Tile t, int size, boolean xAlignedEh){
	this.size = size;
	this.xAlignedEh = xAlignedEh;
	pos = t.getPos();
	//t.setOccupiedEh(true);
    }
    
    public Ship(Coordinate coord, int size, boolean xAlignedEh){
	this.size = size;
	this.xAlignedEh = xAlignedEh;
	pos = coord;
	//t.setOccupiedEh(true);
    }

    @Override
    public void update(Game game) {
	
    }

    @Override
    public void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	for(int i = 0; i < size; i++){
	    Coordinate tempCoord = new Coordinate(pos.getAbsX() + i * (xAlignedEh? 1 : 0), pos.getAbsY() + i * (xAlignedEh? 0 : 1));
	    g.fillRect(tempCoord.getX()+1, tempCoord.getY()+1, Tile.TILE_SIZE-2, Tile.TILE_SIZE-2);
	}
    }

    public int getSize() {
	return size;
    }

    public void setSize(int size) {
	this.size = size;
    }

    public boolean isxAlignedEh() {
	return xAlignedEh;
    }

    public void setxAlignedEh(boolean xAlignedEh) {
	this.xAlignedEh = xAlignedEh;
    }
    
}
