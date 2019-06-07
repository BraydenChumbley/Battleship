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
    
    public Window(int width, int height, String title, Game game) throws IOException{
	setTitle(title);
	
	setPreferredSize(new Dimension(width, height));
	setMinimumSize(new Dimension(width, height));
	setMaximumSize(new Dimension(width, height));
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLocationRelativeTo(null);
	add(game);
	setVisible(true);
	//setIconImage(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getClass().getResource("res\\gfx\\icon.png"));
        //setIconImage(ImageIO.read (new File("res\\gfx\\icon.png")));
	
	//Component[] comps = this.getComponents();
	
	/*this.addComponentListener(new ComponentListener(){
	    @Override
	    public void componentResized(ComponentEvent e) {
		game.revalidate();
	    }

	    @Override
	    public void componentMoved(ComponentEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public void componentShown(ComponentEvent e) {
		//System.out.println("shown");
	    }

	    @Override
	    public void componentHidden(ComponentEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	});*/
	
	game.start();
    }
    
}
