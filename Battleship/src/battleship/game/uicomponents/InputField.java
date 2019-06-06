package battleship.game.uicomponents;

import battleship.game.UnderscoreCaret;
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
public class InputField extends JTextField implements FocusListener {

    private String label;
    private Color outlineColor;
    private Color textColor;
    private Color backgroundColor;

    public InputField(String label) {
	try {
	    this.label = label;
	    init();
	} catch (FontFormatException ex) {
	    Logger.getLogger(InputField.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(InputField.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public InputField(String label, int x, int y, int width, int height) {
	this(label);
	setBounds(x, y, width, height);
    }

    private void init() throws FontFormatException, IOException {
	//setText(label);
	setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\font.ttf")).deriveFont(20.0f)); //Set the font of the words
	setTextColor(Color.ORANGE); //Set the font color 
	setOutlineColor(Color.RED); //Set the outline of the textarea
	setBackgroundColor(Color.BLACK); //Set the background of the textarea
	setBounds(0, 0, 100, 30);
	this.setCaret(new UnderscoreCaret());
	this.setCaretColor(Color.ORANGE);
	this.setSelectionColor(new Color(155, 155, 155, 155));
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
	
	if(this.getText().equals("") && !this.hasFocus()){
	    g.setColor(Color.DARK_GRAY);
	    g.drawString(label, 5, getHeight()/2+8);
	}

	g.setColor(outlineColor);
	g.drawRect(0, 0, (int) bounds.getWidth() - 1, (int) bounds.getHeight() - 1);
	
	g.setFont(getFont());
	g.setColor(textColor);
	g.drawString(getText(), 5, getHeight()/2+8);
	this.getCaret().paint(g);
    }

    @Override
    public void focusGained(FocusEvent e) {
	setOutlineColor(Color.CYAN);
    }

    @Override
    public void focusLost(FocusEvent e) {
	setOutlineColor(Color.RED);
    }

}
