package battleship.game.uicomponents;

import battleship.game.Game;
import battleship.game.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Brayden Chumbley
 */
public class InputField extends JTextField implements FocusListener, KeyListener{
    
    private String label;
    private Color outlineColor;
    private Color textColor;
    private Color backgroundColor;
    
    public InputField(String label){
	try {
	    this.label = label;
	    init();
	} catch (FontFormatException ex) {
	    Logger.getLogger(InputField.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(InputField.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public InputField(String label, int x, int y, int width, int height){
	this(label);
	setBounds(x, y, width, height);
    }
    
    private void init() throws FontFormatException, IOException {
	setText(label);
	setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\font.ttf")).deriveFont(20.0f)); //Set the font of the words
        setTextColor(Color.ORANGE); //Set the font color 
        setOutlineColor(Color.RED); //Set the outline of the button
        setBackgroundColor(Color.BLACK); //Set the background of the button
	setBounds(0, 0, 100, 30);
    }

    public void setTextColor(Color c) {
	this.textColor = c;
    }

    public void setOutlineColor(Color c) {
	this.outlineColor = c;
    }

    public void setBackgroundColor(Color c) {
	this.backgroundColor = c;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	g.setColor(backgroundColor);
	Rectangle bounds = this.getBounds();
	g.fillRect(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());

	g.setColor(outlineColor);
	g.drawRect(0, 0, (int) bounds.getWidth()-1, (int) bounds.getHeight()-1);

	g.setColor(textColor);
	Utils.drawCenteredString(g, getText(), new Rectangle(0, 0, getWidth(), getHeight()), getFont());
    }

    @Override
    public void focusGained(FocusEvent e) {
	System.out.println("Focused");
	setOutlineColor(Color.CYAN);
    }

    @Override
    public void focusLost(FocusEvent e) {
	setOutlineColor(Color.RED);
    }

    @Override
    public void keyTyped(KeyEvent e) {
	
    }

    @Override
    public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
	    setText(getText().substring(0, getText().length()-1) + "_");
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
	//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
