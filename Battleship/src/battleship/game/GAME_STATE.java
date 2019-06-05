package battleship.game;

import battleship.game.menus.GameMenu;
import battleship.game.menus.JoinGameMenu;
import battleship.game.menus.MainMenu;
import javax.swing.JPanel;

public enum GAME_STATE {
    
    MAIN_MENU(new MainMenu()), JOIN_MENU(new JoinGameMenu()), OPTIONS_MENU(new JPanel()), CREDITS_MENU(new JPanel()), GAME(new GameMenu());
    
    private final JPanel panel;
    
    private GAME_STATE(JPanel panel){
	this.panel = panel;
    }
    
    public JPanel getPanel(){
	return panel;
    }
    
}
