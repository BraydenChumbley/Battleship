/*
 * Tony Brayden Josh
 * May 19 2019
 * The Abstract Game Object 
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

    /**
     * 
     * @param game 
     */
    @Override
    public abstract void update(Game game);
    
    /**
     * 
     * @param g - Graphics 
     */
    @Override
    public abstract void draw(Graphics g);

    /**
     * 
     * @return - The position
     */
    @Override
    public Coordinate getPos() {
	return pos;
    }

    /**
     * 
     * @param pos - The position
     */
    @Override
    public void setPos(Coordinate pos) {
	this.pos = pos;
    }

    /**
     * 
     * @param sprite 
     */
    public void setSprite(BufferedImage sprite) {
	this.sprite = sprite;
    }
    
}
