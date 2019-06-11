/*
 * Tony Brayden Joh
 * June 6 2019
 * Class for player
 */

package battleship.server;

import battleship.game.Coordinate;
import battleship.game.Tile;
import java.net.Socket;

/**
 *
 * @author Brayden Chumbley
 */
public class Player {
    
    private String username;
    
    /**
     * Constructor for player
     * @param soc - socket of the player
     * @param username - Username of the player
     * @param board - The tile board 
     */
    public Player(Socket soc, String username, Tile[][] board){
	
    }
    
    /**
     * Coordinate of ships 
     * @return - return nothing
     */
    public Coordinate getGuess(){
	return null;
    }
    
}
