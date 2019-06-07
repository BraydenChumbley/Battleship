/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.uicomponents;

import battleship.game.Game;
import battleship.game.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Brayden Chumbley
 */
public class Button extends JButton implements MouseListener {

    private Color outlineColor; //Outline color of the button
    private Color textColor; //Color of the font
    private Color backgroundColor; //Background color of the button

    /**
     * This con
     * @param text 
     */
    public Button(String text) {
	try {
	    init(text);
	} catch (FontFormatException ex) {
	    Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public Button(String text, int x, int y, int width, int height) {
	this(text);
	setBounds(x, y, width, height);

    }

    private void init(String text) throws FontFormatException, IOException {
	setText(text);
	setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\font.ttf")).deriveFont(20.0f)); //Set the font of the words
        setTextColor(Color.ORANGE); //Set the font color 
        setOutlineColor(Color.red); //Set the outline of the button
        setBackgroundColor(Color.BLACK); //Set the background of the button
	setBounds(0, 0, 100, 30);
	setBorderPainted(false);
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
    public void mouseClicked(MouseEvent me) {
	setBackgroundColor(Color.blue); //When the mouse is clicked the background turns blue
	setBackgroundColor(Color.BLACK); //When the mouse is clicked the background turns black immediately after it turns blue to make it look like a clicked animation
    }

    @Override
    public void mousePressed(MouseEvent me) {
	setBackgroundColor(Color.blue); //When the mouse is pressed the background turns blue
    }

    @Override
    public void mouseReleased(MouseEvent me) {
	setBackgroundColor(Color.BLACK); //When the mouse is released the background turns black
	setOutlineColor(Color.RED);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
	setOutlineColor(Color.cyan); //When the mouse is hovering over the button, the outline color of the button changes to cyan
    }

    @Override
    public void mouseExited(MouseEvent me) {
	setOutlineColor(Color.red); //When the mouse is no longer hovering over the button, the outline color changes back to normal
    }

    @Override
    protected void paintComponent(Graphics g) {
	g.setColor(backgroundColor);
	Rectangle bounds = this.getBounds();
	g.fillRect(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());

	g.setColor(outlineColor);
	g.drawRect(0, 0, (int) bounds.getWidth() - 1, (int) bounds.getHeight() - 1);

	g.setColor(textColor);
	Utils.drawCenteredString(g, getText(), new Rectangle(0, 0, getWidth(), getHeight()), getFont());
    }
}
