/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.menus;

import battleship.game.GAME_STATE;
import battleship.game.Game;
import battleship.game.uicomponents.Button;
import battleship.game.uicomponents.Label;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author johic8379
 */
public class OptionsMenu extends JPanel {

    private Image background;
    //private JPanel inputPanel;

    private JButton backBtn;
    private JButton musicToggleBtn;

    public OptionsMenu() {
        System.out.println("optionstest");
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(CreditsMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws IOException {
        setLayout(null);
        //  background = Toolkit.getDefaultToolkit().createImage("res\\gfx\\BrownTatteredAmericanredsquirrel-small.gif");
        setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.setBackground(new Color(86, 172, 255, 0));

        /*inputPanel = new JPanel();
	inputPanel.setBounds(100, 0, Game.WIDTH, Game.HEIGHT);
	inputPanel.setBackground(new Color(87, 172, 255));*/
        Rectangle b = getBounds();
        int startY = 200, height = 50;
        int padding = 10;
        String torfMsg = "on";

        /*credits = new battleship.game.Button("Credits");
	credits.setBounds(padding, p.getHeight()/4 + 120, p.getWidth()-padding*2, 40);
	credits.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("Credits");
                Game.setGameState(GAME_STATE.CREDITS_MENU);
	    }
	});*/
        backBtn = new Button("Back", padding, startY + (padding + height) * (-3), (int) (b.getWidth() - (90 * padding)), height);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGameState(GAME_STATE.MAIN_MENU);

            }
        });
        musicToggleBtn = new Button("Toggle Music", padding, startY + (padding + height) * (-1), (int) (b.getWidth() - (90 * padding)), height);

        musicToggleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.IS_AUDIO_ENABLED = !(Game.IS_AUDIO_ENABLED);
                if (Game.IS_AUDIO_ENABLED) {
                    Game.menuTheme.loop();
                } else {
                    Game.menuTheme.stop();
                }
                
            }
        });
        add(backBtn);
        add(musicToggleBtn);
        backBtn.addMouseListener((MouseListener) backBtn);
        musicToggleBtn.addMouseListener((MouseListener) musicToggleBtn);
    }

    @Override

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, Game.HEIGHT - 500, Game.WIDTH, Game.HEIGHT - 250, null);
        this.setBackground(new Color(86, 172, 255, 255));
    }

}