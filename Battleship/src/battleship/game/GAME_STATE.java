package battleship.game;

import javax.swing.JPanel;

public enum GAME_STATE {
    
    MAIN_MENU(new MainMenu()), JOIN_MENU(new JPanel()), OPTIONS_MENU(new JPanel()), CREDITS_MENU(new JPanel()), GAME(new JPanel());
    
    private final JPanel panel;
    
    private GAME_STATE(JPanel panel){
	this.panel = panel;
    }
    
    public JPanel getPanel(){
	return panel;
    }
    
}