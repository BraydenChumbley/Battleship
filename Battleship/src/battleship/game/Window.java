/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Brayden Chumbley
 */
public final class Window extends JFrame{
    
    public Window(int width, int height, String title, Game game){
	setTitle(title);
	
	setPreferredSize(new Dimension(width, height));
	setMinimumSize(new Dimension(width, height));
	setMaximumSize(new Dimension(width, height));
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLocationRelativeTo(null);
	add(game);
	setVisible(true);
	
	game.start();
    }
    
}
