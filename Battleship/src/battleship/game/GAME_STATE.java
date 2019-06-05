package battleship.game;

import battleship.game.menus.CreditsMenu;
import battleship.game.menus.JoinGameMenu;
import battleship.game.menus.MainMenu;
import battleship.game.menus.Score;
import javax.swing.JPanel;

public enum GAME_STATE {
    
    MAIN_MENU(new MainMenu()), JOIN_MENU(new JoinGameMenu()), OPTIONS_MENU(new JPanel()), CREDITS_MENU(new CreditsMenu()), GAME(new JPanel()), SCORE(new Score());
    
    private final JPanel panel;
    
    private GAME_STATE(JPanel panel){
	this.panel = panel;
    }
    
    public JPanel getPanel(){
	return panel;
    }
    
}
