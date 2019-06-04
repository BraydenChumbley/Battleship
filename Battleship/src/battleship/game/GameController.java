/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.game;

/**
 *
 * @author Brayden Chumbley
 */
public class GameController {
    
    private Tile[][] board;
    private boolean isTurn;
    
    public GameController(){
	isTurn = false;
	board = new Tile[10][10];
	for(int x = 0; x < 10; x++){
	    for(int y = 0; y < 10; y++){
		board[x][y] = new Tile(x,y);
	    }
	}
    }
    
    public void displayHit(){
	
    }
    
    public Tile[][] getBoardLayout(){
	return board;
    }
    
}
