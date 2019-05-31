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
    public Tile(int x, int y){
        pos = new Coordinate(x, y);
    }
    
    @Override
    public void update() {
	
    }
    
    /**
     * Used to draw the tiles
     * @param g - Graphics object that is being drawn
     */
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
