/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public Player(Socket soc, String username, Tile[][] board){
	
    }
    
    public Coordinate getGuess(){
	return null;
    }
    
}
