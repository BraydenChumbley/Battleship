/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Color;
import java.awt.Graphics;


public class Tile extends AbstractGameObject{

    public Tile(int x, int y){
        pos = new Coordinate(x, y);
    }
    
    @Override
    public void update() {
	
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.drawRect(pos.getX(), pos.getY(),50,50);
        //g.drawImage(sprite, (int)x, (int)y, null)
    }

    @Override
    public String toString() {
	return "Tile{" + "x=" + pos.getX() + ",y=" + pos.getY() + "}";
    }
}
