/*
 * Brayden Josh Tony
 * May 27 2019
 * This is the main menu 
 */
package battleship.game.menus;

import battleship.game.AudioClip;
import battleship.game.uicomponents.Button;
import battleship.game.GAME_STATE;
import battleship.game.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.Font.font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author toyu2550
 */
public class MainMenu extends JPanel {

   

    private Image background;

    public MainMenu() {
        //Game.menuTheme.play();

        //audio.stop();
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws IOException {
        setLayout(null);
        background = ImageIO.read(new File("res\\gfx\\menubackground.png")).getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_FAST);
        setBounds(0, 0, Game.WIDTH, Game.HEIGHT);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btnPanel.setBounds(100, 0, 300, Game.HEIGHT);
        btnPanel.setBackground(new Color(50, 50, 50, 200));
        addButtons(btnPanel);

        ImageIcon titleImage = new ImageIcon(ImageIO.read(new File("res\\gfx\\title.png")).getScaledInstance(300, 90, Image.SCALE_FAST));
        JLabel titleLbl = new JLabel();
        titleLbl.setBounds(0, 50, 300, 90);
        titleLbl.setIcon(titleImage);
        btnPanel.add(titleLbl);

        add(btnPanel);

    }

    public void addButtons(JPanel p) {

        JButton play, options, credits, quit;
        int padding = 10;

        //Play Button
        play = new Button("START");
        play.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 25));
        play.setBounds(padding, p.getHeight() / 4 + 25, p.getWidth() - padding * 2, 40);
        ((Button) play).setTextColor(Color.ORANGE);
        ((Button) play).setOutlineColor(Color.red);
        ((Button) play).setBackgroundColor(Color.black);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.JOIN_MENU);
            }

        }
        );
	
	//Options Button
	options = new Button("OPTIONS"); //Button displays OPTIONS
        options.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20)); //Set the font of the words
        ((Button)options).setTextColor(Color.ORANGE); //Set the font color 
        ((Button)options).setOutlineColor(Color.red); //Set the outline of the button
        ((Button)options).setBackgroundColor(Color.BLACK); //Set the background of the button
	options.setBounds(padding, p.getHeight()/4 + 125, p.getWidth()-padding*2, 40);
	options.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Options" + options.getFont());
	    }
	});
        
	//Credits Button
	credits = new Button("CREDITS"); //Button displays CREDITS
        credits.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20)); //Set the font of the words
        ((Button)credits).setTextColor(Color.ORANGE); //Set the font color 
        ((Button)credits).setOutlineColor(Color.red); //Set the outline of the button
        ((Button)credits).setBackgroundColor(Color.BLACK); //Set the background of the button
	credits.setBounds(padding, p.getHeight()/4 + 225, p.getWidth()-padding*2, 40);
	credits.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Credits");
	    }
	});
        
	//Quit Button
	quit = new Button("QUIT"); //Button displays QUIT
        quit.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20)); //Set the font of the words
        ((Button)quit).setTextColor(Color.ORANGE); //Set the font color 
        ((Button)quit).setOutlineColor(Color.red); //Set the outline of the button
        ((Button)quit).setBackgroundColor(Color.BLACK); //Set the background of the button
	quit.setBounds(padding, p.getHeight()/4 + 325, p.getWidth()-padding*2, 40);
	quit.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	
	play.addMouseListener((MouseListener) play);
	options.addMouseListener((MouseListener) options);
	credits.addMouseListener((MouseListener) credits);
	quit.addMouseListener((MouseListener) quit);
	
	p.add(play);
	p.add(options);
	p.add(credits);
	p.add(quit);
	
    }
    
    /**
     * This method is for drawing images in the menu
     * @param g - Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);  //Background is being drawn    
    }
}
