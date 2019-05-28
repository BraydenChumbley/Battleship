package battleship.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class JoinGameMenu extends JPanel {
    
    private Image background;

    public JoinGameMenu() {
	try {
	    init();
	} catch (IOException ex) {
	    Logger.getLogger(JoinGameMenu.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    private void init() throws IOException{
	setLayout(null);
	background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST);
	setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
	
	add(new InputField("Port", 100, 100, 200, 50));
	
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        
        
    }

}
