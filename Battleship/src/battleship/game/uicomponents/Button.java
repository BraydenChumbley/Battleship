/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.uicomponents;

import battleship.game.Utils;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;

/**
 *
 * @author Brayden Chumbley
 */
public class Button extends JButton {
    private Color outlineColor;
    private Color textColor;
    private Color backgroundColor;
    public Button(String text) {
	init(text);
    }

    public Button(String text, int x, int y, int width, int height) {
	this(text);
	setBounds(x, y, width, height);
         
        
    }
   
    private void init(String text) {
	setText(text);
	setBounds(0, 0, 100, 30);
	setBorderPainted(false);
    }
    public void setTextColor(Color c){
        this.textColor = c;
    }
    public void setOutlineColor(Color c){
        this.outlineColor = c;
    }
    public void setBackgroundColor(Color c){
        this.backgroundColor = c;
    }
    @Override
    protected void paintComponent(Graphics g) {
	g.setColor(backgroundColor);
	Rectangle bounds = this.getBounds();
	g.fillRect(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());

	g.setColor(outlineColor);
	g.drawRect(0, 0, (int) bounds.getWidth()-1, (int) bounds.getHeight()-1);

	g.setColor(textColor);
	Utils.drawCenteredString(g, getText(), new Rectangle(0, 0, getWidth(), getHeight()), getFont());
    }
}