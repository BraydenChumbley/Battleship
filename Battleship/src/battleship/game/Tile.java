/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Color;
import java.awt.Graphics;


public class Tile extends AbstractGameObject{

    public Tile(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.drawRect((int)x,(int)y,43,43);
        //g.drawImage(sprite, (int)x, (int)y, null)
    }
}
