/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.menus;

import battleship.game.GAME_STATE;
import battleship.game.Game;
import battleship.game.uicomponents.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class GameMenu extends JPanel {
    
    private Game game;

    public GameMenu(Game game) {
	this.game = game;
	init();
    }

    private void init() {
	setBackground(Color.DARK_GRAY);
	setBounds(Game.WIDTH - 300, 0, 300, Game.HEIGHT);

	addButtons(this);
    }

    private void addButtons(JPanel p) {

	JButton leaveBtn, undoBtn, readyBtn;

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

	leaveBtn.addMouseListener((MouseListener) leaveBtn);
	undoBtn.addMouseListener((MouseListener) undoBtn);
	
	p.add(undoBtn);
	p.add(leaveBtn);

    }

}
