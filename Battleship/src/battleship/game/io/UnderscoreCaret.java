/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game.io;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Brayden Chumbley
 */
public class UnderscoreCaret extends DefaultCaret {

    public UnderscoreCaret() {
	this.setBlinkRate(300);
    }

    protected synchronized void damage(Rectangle r) {
	if (r == null) {
	    return;
	}
	// give values to x,y,width,height (inherited from java.awt.Rectangle)
	x = r.x;
	y = r.y + (r.height * 4 / 5 - 3);
	width = 5;
	height = 5;
	repaint(); // calls getComponent().repaint(x, y, width, height)
    }

    public void paint(Graphics g) {
	JTextComponent comp = getComponent();
	if (comp == null) {
	    return;
	}

	int dot = getDot();
	Rectangle r = null;
	try {
	    r = comp.modelToView(dot);
	} catch (BadLocationException e) {
	    return;
	}
	if (r == null) {
	    return;
	}

	int dist = r.height * 4 / 5 - 3; // will be distance from r.y to top

	if ((x != r.x) || (y != r.y + dist)) {
	    // paint() has been called directly, without a previous call to
	    // damage(), so do some cleanup. (This happens, for example, when
	    // the
	    // text component is resized.)
	    repaint(); // erase previous location of caret
	    x = r.x; // set new values for x,y,width,height
	    y = r.y + dist;
	    width = 5;
	    height = 5;
	}

	if (isVisible()) {
	    g.setColor(comp.getCaretColor());
	    g.drawString("_", x, y+8);
	    //g.drawLine(r.x, r.y + dist, r.x, r.y + dist + 4); // 5 vertical
	    // pixels
	    //g.drawLine(r.x, r.y + dist + 4, r.x + 4, r.y + dist + 4); // 5 horiz
	    // px
	}

    }
}
