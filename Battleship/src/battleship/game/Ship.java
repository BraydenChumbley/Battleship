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
    
    private int width, height;
    
    public Ship(Tile t, int length, boolean isXaligned){
	if(isXaligned){
	    width = length;
	    height = 1;
	}
	else{
	    width = 1;
	    height = length;
	}
	pos = t.getPos();
	//t.setOccupiedEh(true);
    }
    
    public Ship(Coordinate coord, int length, boolean isXaligned){
	if(isXaligned){
	    width = length;
	    height = 1;
	}
	else{
	    width = 1;
	    height = length;
	}
	pos = coord;
	//t.setOccupiedEh(true);
    }

    @Override
    public void update(Game game) {
	
    }

    @Override
    public void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(pos.getX(), pos.getY(), Tile.TILE_SIZE, Tile.TILE_SIZE);
    }
    
}
