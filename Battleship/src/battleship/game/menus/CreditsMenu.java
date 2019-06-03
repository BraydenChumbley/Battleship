/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author johic8379
 */
public class CreditsMenu extends JPanel {
    private Image background;
    //private JPanel inputPanel;
    private JLabel creditors;
    private JButton backBtn;
    
    public CreditsMenu() {
	try {
	    init();
	} catch (IOException ex) {
	    Logger.getLogger(CreditsMenu.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    private void init() throws IOException{
	setLayout(null);
	//background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST);
	setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        setBackground(new Color(0,255,0,0));
	
	/*inputPanel = new JPanel();
	inputPanel.setBounds(100, 0, Game.WIDTH, Game.HEIGHT);
	inputPanel.setBackground(new Color(87, 172, 255));*/
	
	Rectangle b = getBounds();
	int startY = 200, height = 50;
	int margin = 10;
	
	
	backBtn = new Button("Back", margin, startY + (margin + height)*3, (int) (b.getWidth()-(90*margin)), height);
        backBtn.setBackground(Color.yellow);
	backBtn.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		Game.setGameState(GAME_STATE.MAIN_MENU);
	    }
	});
	
	
	//inputPanel.add(backBtn);
	
	add(backBtn);
	
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }


}

