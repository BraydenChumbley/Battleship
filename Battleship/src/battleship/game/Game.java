/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class Game extends JPanel implements Runnable {
    
    public Game(){
	
    }

    @Override
    public void run() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
	new Game();
    }

}
