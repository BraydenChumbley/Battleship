/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.menus;

import battleship.game.GAME_STATE;
import battleship.game.Game;
import battleship.game.Utils;
import battleship.game.uicomponents.Button;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayden Chumbley
 */
public class GameMenu extends JPanel {

    private Game game;
    private JPanel titlePanel;

    public GameMenu(Game game) {
	this.game = game;
	init();
    }

    private void init() {
	setBackground(Color.DARK_GRAY);
	setBounds(Game.WIDTH - 300, 0, 300, Game.HEIGHT);
	setLayout(null);
	addButtons(this);
    }

    private void addButtons(JPanel p) {

	JButton leaveBtn, undoBtn, readyBtn; //The different buttons

	int xMargin = 25, yMargin = 50, btnHeight = 50;

	leaveBtn = new Button("LEAVE", xMargin, p.getHeight() - (btnHeight + yMargin), p.getWidth() - (xMargin * 2), btnHeight);
	leaveBtn.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

                if(Game.IS_AUDIO_ENABLED){
		Game.battleSetupTheme.stop();
		Game.menuTheme.loop();
                }
		Game.setGameState(GAME_STATE.MAIN_MENU);
	    }
	});

	undoBtn = new Button("UNDO", xMargin, 400, p.getWidth() - (xMargin * 2), btnHeight);
	undoBtn.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		game.getGC().undoPlacement();
	    }
	});

	readyBtn = new Button("READY", xMargin, 400 + btnHeight, p.getWidth() - (xMargin * 2), btnHeight);
	readyBtn.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		try {
		    if (game.getGC().ready()) {
			    //game.getGC().getOutputStream().writeUTF("ready");
			    Utils.sendBoard(game.getGC().getBoardLayout(), game.getGC().getOutputStream());
		    } else {
			
		    }
		} catch (IOException ex) {
		    Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	});

	leaveBtn.addMouseListener((MouseListener) leaveBtn);
	undoBtn.addMouseListener((MouseListener) undoBtn);
	readyBtn.addMouseListener((MouseListener) readyBtn);

	p.add(undoBtn);
	p.add(readyBtn);
	p.add(leaveBtn);

    }

}
