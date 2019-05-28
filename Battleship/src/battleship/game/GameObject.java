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
public interface GameObject {
    
    public void update();
    public void draw(Graphics g);
    public void setX(double x);
    public double getX();
    public void setY(double y);
    public double getY();
    public void setVelX(double velX);
    public double getVelX();
    public void setVelY(double velY);
    public double getVelY();

}
