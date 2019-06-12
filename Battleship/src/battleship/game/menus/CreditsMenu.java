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
public class CreditsMenu extends JPanel {

    private Image background;
    //private JPanel inputPanel;
    private JLabel braydenLbl;
    private JLabel joshLbl;
    private JLabel tonyLbl;
    private JButton backBtn;

    public CreditsMenu() {
        System.out.println("hdf");
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(CreditsMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws IOException {
        setLayout(null);
        background = Toolkit.getDefaultToolkit().createImage("res\\gfx\\BrownTatteredAmericanredsquirrel-small.gif");
        setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.setBackground(new Color(86, 172, 255, 0));

        /*inputPanel = new JPanel();
	inputPanel.setBounds(100, 0, Game.WIDTH, Game.HEIGHT);
	inputPanel.setBackground(new Color(87, 172, 255));*/
        Rectangle b = getBounds();
        int startY = 200, height = 50;
        int padding = 10;

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
                if(Game.IS_AUDIO_ENABLED){
                Game.creditsTheme.stop();
                Game.menuTheme.play();
                }
            }
        });

        add(backBtn);
        backBtn.addMouseListener((MouseListener) backBtn);

        braydenLbl = new Label("Brayden C.", (Game.WIDTH) / 2, startY + (padding + height) * (-1), (int) (b.getWidth() - (90 * padding)), height);
        joshLbl = new Label("Tony Y.", (Game.WIDTH) / 2, startY + (padding + height) * (-2), (int) (b.getWidth() - (90 * padding)), height);
        tonyLbl = new Label("Joshua H.", (Game.WIDTH) / 2, startY + (padding + height) * (-3), (int) (b.getWidth() - (90 * padding)), height);
        add(braydenLbl);
        add(joshLbl);
        add(tonyLbl);
    }

    @Override

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, Game.HEIGHT - 500, Game.WIDTH, Game.HEIGHT - 250, null);
        this.setBackground(new Color(86, 172, 255, 255));
    }

}
