/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import static battleship.game.Tile.TILE_SIZE;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayden Chumbley
 */
public class GameController {

    private Tile[][] board, enemyBoard;
    private boolean isTurn, placementPhase, isReady;
    private Ship[] ships;
    private int placedShips;
    private Game game;
    private Socket s;
    final private DataOutputStream dOut;
    final private DataInputStream dIn;
    private Timer socketListener;

    public GameController(Game game, Socket s) throws IOException {
	this.s = s;
	
	//s.setSoTimeout();
	this.isReady = false;
	dOut = new DataOutputStream(s.getOutputStream());
	dIn = new DataInputStream(s.getInputStream());

	this.game = game;
	isTurn = false;
	board = new Tile[10][10];

	placementPhase = false;
	placedShips = 0;
	ships = new Ship[5];
	ships[0] = new Ship(new Coordinate(0, 0), 5, false);
	ships[1] = new Ship(new Coordinate(0, 0), 4, false);
	ships[2] = new Ship(new Coordinate(0, 0), 3, false);
	ships[3] = new Ship(new Coordinate(0, 0), 3, false);
	ships[4] = new Ship(new Coordinate(0, 0), 2, false);

	socketListener = new Timer();

    }

    public void update(Game game) {

	if (board[0][0] == null) {
	    
	    board = Utils.receiveBoard(dIn);
	    
	    for(int x = 0; x < 10; x++){
		for(int y = 0; y < 10; y++){
		    game.getGOHandler().addObj(board[x][y]);
		}
	    }
	    
	    TimerTask socketTask = new TimerTask() {
		@Override
		public void run() {
		    try {
			String data = dIn.readUTF();
			System.out.println(data);
			if (data.equalsIgnoreCase("placementphase")) {
			    if (dIn.readBoolean()) {
				startPlacementPhase(game);
			    }
			}
			else if(data.equalsIgnoreCase("enemyboard")) {
			    enemyBoard = Utils.receiveBoard(dIn);
			}
			else if(data.equalsIgnoreCase("isturn")){
			    swapBoard(enemyBoard, false);
			    isTurn = true;
			}
		    } catch (SocketTimeoutException e) {
			//System.out.println("timedout");
		    } catch (IOException e) {
		    }
		}
	    };

	    socketListener.scheduleAtFixedRate(socketTask, 0, 1000);
	}

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
    }

    public void startPlacementPhase(Game game) {
	placementPhase = true;
	game.getGOHandler().addObj(ships[placedShips]);
    }

    private void draw(Graphics g) {

    }

    public void undoPlacement() {
	if (isReady) {
	    return;
	}
	try {
	    game.getGOHandler().removeObj(ships[placedShips]);
	} catch (ArrayIndexOutOfBoundsException e) {
	    placementPhase = true;
	}
	placedShips = Utils.clamp(placedShips - 1, 0, ships.length - 1);

	if (placedShips == 0) {
	    game.getGOHandler().addObj(ships[placedShips]);
	}

	Ship tempShip = ships[placedShips];

	Utils.setTilesOccupied(tempShip.getPos().getAbsX(), tempShip.getPos().getAbsY(), tempShip.isxAlignedEh() ? tempShip.getSize() : 1, !tempShip.isxAlignedEh() ? tempShip.getSize() : 1, board, false);
    }

    public boolean ready() throws IOException {
	if (!placementPhase) {
	    dOut.writeUTF("ready");
	    isReady = true;
	    return true;
	} else {
	    game.displayMessage(game, "Not All Ships Placed", 2);
	    return false;
	}
    }

    public void swapBoard(Tile[][] newBoard, boolean drawShips) {
	for (int x = 0; x < 10; x++) {
	    for (int y = 0; y < 10; y++) {
		game.getGOHandler().removeObj(board[x][y]);
		game.getGOHandler().addObj(newBoard[x][y]);
	    }
	}

	for (int i = 0; i < ships.length; i++) {
	    ships[i].setIsDrawn(drawShips);
	}
    }

    public void dispose() {
	try {
	    game.undisplayMessage();
	    game.getGOHandler().removeAllObj();
	    sendData("quit");
	    s.close();
	    dOut.close();
	    dIn.close();
	} catch (IOException ex) {
	    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void sendData(String data) {
	try {
	    dOut.writeUTF(data);
	} catch (IOException ex) {
	    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public void sendBoolean(boolean bool) {
	try {
	    dOut.writeBoolean(bool);
	} catch (IOException ex) {
	    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public Tile[][] getBoardLayout() {
	return board;
    }

    public Tile[][] getEnemyBoardLayout() {
	return enemyBoard;
    }
    
    public boolean isTurn(){
	return isTurn;
    }
    
    public void setIsTurn(boolean state){
	this.isTurn = state;
    }
    
    public DataOutputStream getOutputStream(){
	return dOut;
    }

}
