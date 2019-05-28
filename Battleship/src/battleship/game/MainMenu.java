/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tonyy
 */
public class MainMenu extends JPanel {
   
    AudioClip audio = new AudioClip("res\\audio\\song.wav");
    
    
    
    private Image background;

    public MainMenu() {
        audio.play();
        audio.stop();
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
	add(btnPanel);
	
    }
    
    private void addButtons(JPanel p){
	
	JButton play, options, credits, quit;
	int padding = 10;
	
	//Play Button
	
	play = new Button("Play");
	play.setBounds(padding, p.getHeight()/4, p.getWidth()-padding*2, 40);
	play.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Play");
	    }
	});
	
	
	//Options Button
	
	options = new Button("Options");
	options.setBounds(padding, p.getHeight()/4 + 60, p.getWidth()-padding*2, 40);
	options.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Options");
	    }
	});
	
	//Credits Button
	
	credits = new Button("Credits");
	credits.setBounds(padding, p.getHeight()/4 + 120, p.getWidth()-padding*2, 40);
	credits.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Credits");
	    }
	});
	
	//Quit Button
	
	quit = new Button("Quit");
	quit.setBounds(padding, p.getHeight()/4 + 180, p.getWidth()-padding*2, 40);
	quit.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
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
