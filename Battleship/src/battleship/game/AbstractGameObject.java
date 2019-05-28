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
public class AbstractGameObject implements GameObject {
    
    protected double x, y, velX, velY;
    protected BufferedImage sprite;
    
    public AbstractGameObject(){
	
    }
    
    @Override
    public void draw(Graphics g){
	g.drawImage(sprite, (int)x, (int)y, null);
    }

    @Override
    public void update() {
	this.x += velX;
	this.y += velY;
    }

    @Override
    public double getX() {
	return x;
    }

    @Override
    public void setX(double x) {
	this.x = x;
    }

    @Override
    public double getY() {
	return y;
    }

    @Override
    public void setY(double y) {
	this.y = y;
    }

    @Override
    public double getVelX() {
	return velX;
    }

    @Override
    public void setVelX(double velX) {
	this.velX = velX;
    }

    @Override
    public double getVelY() {
	return velY;
    }

    @Override
    public void setVelY(double velY) {
	this.velY = velY;
    }

    public BufferedImage getSprite() {
	return sprite;
    }

    public void setSprite(BufferedImage sprite) {
	this.sprite = sprite;
    }

    
    
}
