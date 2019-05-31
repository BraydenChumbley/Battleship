/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author tonyy
 */
public class MainMenu extends JPanel {
   
    AudioClip menuTheme = new AudioClip("res\\audio\\song.wav");
    AudioClip creditsTheme = new AudioClip("res\\audio\\credits.wav");
    AudioClip battleTheme = new AudioClip("res\\audio\\battletheme.wav");
    AudioClip battleSetupTheme = new AudioClip("res\\audio\\battlesetup.wav");
    
    private Image background;

    public MainMenu() {
        menuTheme.play();
        //audio.stop();
        try {
            init();
            
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void init() throws IOException{
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
        titleLbl.setBounds(0,50,300,90);
        titleLbl.setIcon(titleImage);
        btnPanel.add(titleLbl);
        
	add(btnPanel);
        
	
    }
    
    public void addButtons(JPanel p){
	
	JButton play, options, credits, quit;
	int padding = 10;
	
	//Play Button
	
	play = new Button("START");
        play.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 25));
	play.setBounds(padding, p.getHeight()/4 + 25, p.getWidth()-padding*2, 40);
        ((Button) play).setTextColor(Color.ORANGE);
        ((Button) play).setOutlineColor(Color.red);
        ((Button)play).setBackgroundColor(Color.black);
	play.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		Game.setGameState(GAME_STATE.JOIN_MENU);
	    }
            
	}
                
        );
        
        play.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)play).setBackgroundColor(Color.blue);
                ((Button)play).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)play).setBackgroundColor(Color.blue);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)play).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)play).setOutlineColor(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)play).setOutlineColor(Color.red);
            }
        });
	
	
	//Options Button
	
	options = new Button("OPTIONS");
        options.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20));
        ((Button)options).setTextColor(Color.ORANGE);
        ((Button)options).setOutlineColor(Color.red);
        ((Button)options).setBackgroundColor(Color.BLACK);
	options.setBounds(padding, p.getHeight()/4 + 125, p.getWidth()-padding*2, 40);
	options.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Options" + options.getFont());
	    }
	});
        options.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)options).setBackgroundColor(Color.blue);
                ((Button)options).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)options).setBackgroundColor(Color.blue);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)options).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)options).setOutlineColor(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)options).setOutlineColor(Color.red);
            }
        });
	//Credits Button
	
	credits = new Button("CREDITS");
        credits.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20));
        ((Button)credits).setTextColor(Color.ORANGE);
        ((Button)credits).setOutlineColor(Color.red);
        ((Button)credits).setBackgroundColor(Color.BLACK);
	credits.setBounds(padding, p.getHeight()/4 + 225, p.getWidth()-padding*2, 40);
	credits.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Credits");
                menuTheme.stop();
                creditsTheme.play();
	    }
	});
	credits.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)credits).setBackgroundColor(Color.blue);
                ((Button)credits).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)credits).setBackgroundColor(Color.blue);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)credits).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)credits).setOutlineColor(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)credits).setOutlineColor(Color.red);
            }
        });
	//Quit Button
	
	quit = new Button("QUIT");
        quit.setFont(new Font("res\\fonts\\font.ttf", Font.BOLD, 20));
        ((Button)quit).setTextColor(Color.ORANGE);
        ((Button)quit).setOutlineColor(Color.red);
        ((Button)quit).setBackgroundColor(Color.BLACK);
	quit.setBounds(padding, p.getHeight()/4 + 325, p.getWidth()-padding*2, 40);
	quit.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	quit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                ((Button)quit).setBackgroundColor(Color.blue);
                ((Button)quit).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                ((Button)quit).setBackgroundColor(Color.blue);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                ((Button)quit).setBackgroundColor(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ((Button)quit).setOutlineColor(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                ((Button)quit).setOutlineColor(Color.red);
            }
        });
	p.add(play);
	p.add(options);
	p.add(credits);
	p.add(quit);
	
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        
        
    }
}
