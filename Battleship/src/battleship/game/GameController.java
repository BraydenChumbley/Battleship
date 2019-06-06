/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Brayden Chumbley
 */
public class GameController {

    private Tile[][] board;
    private boolean isTurn, placementPhase;
    private Ship[] ships;
    private int placedShips;
    private Game game;

    public GameController(Game game) {
	this.game = game;
	isTurn = false;
	board = new Tile[10][10];
	for (int x = 0; x < 10; x++) {
	    for (int y = 0; y < 10; y++) {
		board[x][y] = new Tile(x, y);
	    }
	}
	placementPhase = false;
	placedShips = 0;
	ships = new Ship[5];
	ships[0] = new Ship(new Coordinate(0, 0), 5, false);
	ships[1] = new Ship(new Coordinate(0, 0), 4, false);
	ships[2] = new Ship(new Coordinate(0, 0), 3, false);
	ships[3] = new Ship(new Coordinate(0, 0), 3, false);
	ships[4] = new Ship(new Coordinate(0, 0), 2, false);
    }

    public void update(Game game) {

	if (placementPhase) {

	    ships[placedShips].setPos(Coordinate.screenToCoordinate(game.getInput().getMouseX(), game.getInput().getMouseY(), ships[placedShips].isxAlignedEh() ? ships[placedShips].getSize() - 1 : 0,
		    ships[placedShips].isxAlignedEh() ? 0 : ships[placedShips].getSize() - 1));

	    if (game.getInput().isButtonDown(MouseEvent.BUTTON1)) {
		if (Utils.inRange(game.getInput().getMouseX(), board[0][0].getPos().getX(), board[9][9].getPos().getX() + Tile.TILE_SIZE)
			&& Utils.inRange(game.getInput().getMouseY(), board[0][0].getPos().getY(), board[9][9].getPos().getY() + Tile.TILE_SIZE)) {
		    if (Utils.placeShip(board, ships[placedShips])) {
			placedShips++;
			if (placedShips >= 5) {
			    placementPhase = false;
			} else {
			    ships[placedShips].setPos(Coordinate.screenToCoordinate(game.getInput().getMouseX(), game.getInput().getMouseY()));
			    game.getGOHandler().addObj(ships[placedShips]);
			}
		    }
		}

	    }

	    if (game.getInput().isButtonDown(MouseEvent.BUTTON2) || game.getInput().isKeyDown(KeyEvent.VK_R)) {
		ships[placedShips].setxAlignedEh(!ships[placedShips].isxAlignedEh());
	    }
	}
	//ship1.setPos(new Coordinate(game.getInput().getMouseX()/Tile.TILE_SIZE, game.getInput().getMouseY()/Tile.TILE_SIZE));
    }

    public void startPlacementPhase(Game game) {
	placementPhase = true;
	game.getGOHandler().addObj(ships[placedShips]);
    }

    private void draw(Graphics g) {

    }

    public void undoPlacement() {
	try {
	    game.getGOHandler().removeObj(ships[placedShips]);
	} catch (ArrayIndexOutOfBoundsException e) {
	    placementPhase = true;
	}
	placedShips = Utils.clamp(placedShips - 1, 0, ships.length - 1);

	Ship tempShip = ships[placedShips];

	Utils.setTilesOccupied(tempShip.getPos().getAbsX(), tempShip.getPos().getAbsY(), tempShip.isxAlignedEh() ? tempShip.getSize() : 1, !tempShip.isxAlignedEh() ? tempShip.getSize() : 1, board, false);
    }

    public Tile[][] getBoardLayout() {
	return board;
    }

}
