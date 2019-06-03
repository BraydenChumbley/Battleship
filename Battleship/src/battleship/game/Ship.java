/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.game;

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
    }

    @Override
    public void update() {
	
    }

    @Override
    public void draw(Graphics g) {
	
    }
    
}
