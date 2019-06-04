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
    
    public void update(Game game);
    public void draw(Graphics g);
    public Coordinate getPos();
    public void setPos(Coordinate pos);
}
