/*
 * Tony
 * May 29 2019
 * This class draws tiles
 */
package battleship.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Tile extends AbstractGameObject {

    public static final int TILE_SIZE = 65;
    
    private int x, y;
    private boolean occupiedEh;
    private boolean guessedEh;

    /**
     * This constructor i used to set the coordinates of the tiles
     *
     * @param x - The location of the tile on the x-axis
     * @param y - The location of the tile on the y-axis
     */
    public Tile(int x, int y) {
	pos = new Coordinate(x, y);
	this.x = x;
	this.y = y;
	guessedEh = false;
	occupiedEh = false;
    }

    @Override
    public void update(Game game) {
	if (game.getInput().isButtonDown(MouseEvent.BUTTON1)) {
	    if (game.getInput().getMouseX() > pos.getX() && game.getInput().getMouseX() < pos.getX() + TILE_SIZE) {
		if (game.getInput().getMouseY() > pos.getY() && game.getInput().getMouseY() < pos.getY() + TILE_SIZE) {
		    System.out.println("Clicked " + pos.getAbsX() + ":" + pos.getAbsY());
		    System.out.println(occupiedEh? "Hit" : "Miss");
		}
	    }
	}
    }

    /**
     * Used to draw the tiles
     *
     * @param g - Graphics object that is being drawn
     */
    @Override
    public void draw(Graphics g) {
	g.setColor(Color.red);
	g.drawRect(pos.getX(), pos.getY(), TILE_SIZE, TILE_SIZE);
	//g.drawImage(sprite, (int)x, (int)y, null)
    }

    @Override
    public String toString() {
	return "Tile{" + "x=" + pos.getX() + ",y=" + pos.getY() + "}";
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
	return y;
    }

    public void setY(int y) {
	this.y = y;
    }

    public boolean isOccupiedEh() {
	return occupiedEh;
    }

    public void setOccupiedEh(boolean occupiedEh) {
	this.occupiedEh = occupiedEh;
    }

    public boolean isGuessedEh() {
	return guessedEh;
    }

    public void setGuessedEh(boolean guessedEh) {
	this.guessedEh = guessedEh;
    }
    
}
