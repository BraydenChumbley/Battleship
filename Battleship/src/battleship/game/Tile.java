/*
 * Tony
 * May 29 2019
 * This class draws tiles
 */
package battleship.game;
import java.awt.Color;
import java.awt.Graphics;


public class Tile extends AbstractGameObject{

    /**
     * This constructor i used to set the coordinates of the tiles
     * @param x - The location of the tile on the x-axis 
     * @param y - The location of the tile on the y-axis
     */
    public Tile(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    
    /**
     * Used to draw the tiles
     * @param g - Graphics object that is being drawn
     */
    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.drawRect((int)x,(int)y,50,50);
        //g.drawImage(sprite, (int)x, (int)y, null)
    }
}
