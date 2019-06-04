/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Brayden Chumbley
 */
public abstract class AbstractGameObject implements GameObject {
    
    protected Coordinate pos;
    protected BufferedImage sprite;
    
    public AbstractGameObject(){
	
    }

    @Override
    public abstract void update(Game game);
    @Override
    public abstract void draw(Graphics g);
    
    public int getX(){
	return pos.getX();
    }

    @Override
    public Coordinate getPos() {
	return pos;
    }

    @Override
    public void setPos(Coordinate pos) {
	this.pos = pos;
    }

    public void setSprite(BufferedImage sprite) {
	this.sprite = sprite;
    }
    
}
