/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.menus;

import battleship.game.Game;
import battleship.game.Tile;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class GameMenu extends JPanel {

    public GameMenu() {
	init();
    }

    private void init() {
	setBackground(Color.DARK_GRAY);
	setBounds(Game.WIDTH - 300, 0, 300, Game.HEIGHT);
    }

}
