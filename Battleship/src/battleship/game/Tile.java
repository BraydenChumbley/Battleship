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

    public static final int TILE_SIZE = 64; //The lenght of the tile

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

    /**
     * Updates the game 
     * @param game - The game 
     */
    @Override
    public void update(Game game) {
	if (game.getInput().isButtonDown(MouseEvent.BUTTON1) && game.getGC().isTurn()) {
	    if (game.getInput().getMouseX() > pos.getX() && game.getInput().getMouseX() < pos.getX() + TILE_SIZE) {
		if (game.getInput().getMouseY() > pos.getY() && game.getInput().getMouseY() < pos.getY() + TILE_SIZE) {
		    System.out.println("Clicked " + pos.getAbsX() + ":" + pos.getAbsY());
		    System.out.println(occupiedEh? "Hit" : "Miss");
		    if(!guessedEh){
			game.getGC().setIsTurn(false);
			game.getGC().swapBoard(game.getGC().getBoardLayout(), true);
		    }
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
        if (occupiedEh) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.green);
        }
        g.drawRect(pos.getX(), pos.getY(), TILE_SIZE, TILE_SIZE);
        //g.drawImage(sprite, (int)x, (int)y, null)
    }

    @Override
    public String toString() {
        return "Tile{" + "x=" + pos.getX() + ",y=" + pos.getY() + "}";
    }

    /**
     * Get the x value
     * @return - return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x value 
     * @param x - The x value of the tile
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y value
     * @return - return the y value
     */
    public int getY() {
        return y;
    }

    /**
     * Get the y value
     * @return - return the y value of the tile
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Checks if the tile is already used
     * @return - Return true or false
     */
    public boolean isOccupiedEh() {
        return occupiedEh;
    }

    /**
     * Set occupied to true or false
     * @param occupiedEh - boolean to check if ship is in a tile
     */
    public void setOccupiedEh(boolean occupiedEh) {
        this.occupiedEh = occupiedEh;
    }

    /**
     * Once the user clicks/guesses return of the user hit the ship or missed
     * @return - returns true or false
     */
    public boolean isGuessedEh() {
        return guessedEh;
    }

    /**
     * Once the user clicks check if the ship is hit or not
     * @param guessedEh - User's guess 
     */
    public void setGuessedEh(boolean guessedEh) {
        this.guessedEh = guessedEh;
    }

}
