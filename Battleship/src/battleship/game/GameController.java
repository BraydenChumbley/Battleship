/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author Brayden Chumbley
 */
public class GameController {
    
    private Tile[][] board;
    private boolean isTurn;
    private Ship ship1;
    
    public GameController(Game game) {
	isTurn = false;
	board = new Tile[10][10];
	for (int x = 0; x < 10; x++) {
	    for (int y = 0; y < 10; y++) {
		board[x][y] = new Tile(x, y);
	    }
	}
	ship1 = new Ship(new Coordinate(0, 0), 5, false);
	game.getGOHandler().addObj(ship1);
    }
    
    public void update(Game game) {
	ship1.setPos(Coordinate.screenToCoordinate(game.getInput().getMouseX(), game.getInput().getMouseY()));
	if (game.getInput().isButtonDown(MouseEvent.BUTTON2)) {
	    ship1.setxAlignedEh(!ship1.isxAlignedEh());
	}
	//ship1.setPos(new Coordinate(game.getInput().getMouseX()/Tile.TILE_SIZE, game.getInput().getMouseY()/Tile.TILE_SIZE));
    }
    
    private void draw(Graphics g) {
	
    }
    
    public void displayHit() {
	
    }
    
    public Tile[][] getBoardLayout() {
	return board;
    }
    
}