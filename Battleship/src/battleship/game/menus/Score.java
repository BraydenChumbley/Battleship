/*
 * Tony Yu
 * June 6 2019
 * Scores of the player are sorted
 */
package battleship.game.menus;

import battleship.game.GAME_STATE;
import battleship.game.Game;
import battleship.game.uicomponents.Button;
import battleship.game.uicomponents.InputField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author toyu2550
 */
public class Score extends JPanel {

    //private Image background;
    private JPanel displayPanel;
    private JTextArea txtDisplay;
    private JButton backBtn;
    
    public Score(){
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws IOException{
	setLayout(null);
	//background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST);
        setBackground(Color.black);
        
	setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
	
	int startY = 200, height = 50;
	int margin = 10;
	
	
	
	backBtn = new Button("Back", 0, 0, 200, 50);
        backBtn.setForeground(Color.red);
        
	backBtn.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.MAIN_MENU);
	    }
	});
	
	add(backBtn);
	
    }
    

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
