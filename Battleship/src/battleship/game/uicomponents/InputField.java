package battleship.game.uicomponents;

import battleship.game.Utils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JTextField;

/**
 *
 * @author Brayden Chumbley
 */
public class InputField extends JTextField {
    
    private String label;
    
    public InputField(String label){
	this.label = label;
	init();
    }
    
    public InputField(String label, int x, int y, int width, int height){
	this(label);
	setBounds(x, y, width, height);
    }
    
    private void init(){
	setText(label);
	setBounds(0, 0, 100, 30);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.BLACK);
	Rectangle bounds = this.getBounds();
	g.fillRect(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());

	g.setColor(Color.WHITE);
	g.drawRect(0, 0, (int) bounds.getWidth()-1, (int) bounds.getHeight()-1);

	g.setColor(Color.WHITE);
	Utils.drawCenteredString(g, getText(), new Rectangle(0, 0, getWidth(), getHeight()), getFont());
    }

}
