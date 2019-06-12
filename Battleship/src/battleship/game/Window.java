/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Brayden Chumbley
 */
public final class Window extends JFrame{
    
    /**
     * This constructor is made to make it so it is easier to create windows
     * @param width - The width of the window
     * @param height - The height of the window
     * @param title - The title of the window
     * @param game - The game 
     * @throws IOException 
     */
    public Window(int width, int height, String title, Game game) throws IOException{
	setTitle(title);
        
	setPreferredSize(new Dimension(width, height));
	setMinimumSize(new Dimension(width, height));
	setMaximumSize(new Dimension(width, height));
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLocationRelativeTo(null);

	add(game); //Add game to the window
	setVisible(true); //Make the window visible
	game.start(); //Start the game
    }
    
}
