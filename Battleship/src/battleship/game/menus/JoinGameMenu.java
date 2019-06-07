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
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Brayden Chumbley
 */
public class JoinGameMenu extends JPanel {
    
    private Image background;
    private JTextField ipField, portField, unameField;
    private JButton connectBtn, backBtn;

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
	
	JPanel inputPanel = new JPanel();
	inputPanel.setLayout(null);
	inputPanel.setBounds(100, 0, 300, Game.HEIGHT);
	inputPanel.setBackground(new Color(50, 50, 50, 200));
	
	Rectangle b = inputPanel.getBounds();
	int startY = 200, height = 50;
	int margin = 10;
	
	ipField = new InputField("IP Address", margin, startY + (margin + height)*0, (int) (b.getWidth()-(2*margin)), height);
	portField = new InputField("Port", margin, startY + (margin + height)*1, (int) (b.getWidth()-(2*margin)), height);
	unameField = new InputField("Username", margin, startY + (margin + height)*2, (int) (b.getWidth()-(2*margin)), height);
	
	//ipField.addFocusListener((FocusListener) ipField);
	ipField.addKeyListener((KeyListener) ipField);
	
	connectBtn = new Button("Connect", margin, startY + (margin + height)*3, (int) (b.getWidth()-(2*margin)), height);
	connectBtn.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		/*try {
		    Socket s = new Socket(ipField.getText(), Integer.parseInt(portField.getText()));
		    Game.setGameState(GAME_STATE.GAME);
		} catch (IOException ex) {
		    Logger.getLogger(JoinGameMenu.class.getName()).log(Level.SEVERE, null, ex);
		}*/
		Game.menuTheme.stop();
		Game.battleSetupTheme.loop();
		Game.setGameState(GAME_STATE.GAME);
	    }
	});
	
	backBtn = new Button("Back", margin, (int) (b.getHeight() - height - 50), (int) (b.getWidth()-(2*margin)), height);
	backBtn.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		Game.setGameState(GAME_STATE.MAIN_MENU);
	    }
	});
	
	connectBtn.addMouseListener((MouseListener) connectBtn);
	backBtn.addMouseListener((MouseListener) backBtn);
	
	inputPanel.add(ipField);
	inputPanel.add(portField);
	inputPanel.add(unameField);
	inputPanel.add(connectBtn);
	inputPanel.add(backBtn);
	
	add(inputPanel);
	
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

}
