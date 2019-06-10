/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.uicomponents;

import battleship.game.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author johic8379
 */
public class Label extends JLabel {

    private Color outlineColor;
    private Color textColor;
    private Color backgroundColor;

    public Label(String text) {
        try {
            init(text);
        } catch (FontFormatException ex) {
            Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Label(String text, int x, int y, int width, int height) {
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
        g.setColor(textColor);
        Utils.drawCenteredString(g, getText(), new Rectangle(0, 0, getWidth(), getHeight()), getFont());
    }
}
