/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class UIManager {

    private ArrayList<JComponent> uicomps;

    public UIManager() {
	uicomps = new ArrayList<>();
    }

    public void drawUI() {
	for (JComponent uicomp : uicomps) {
	    uicomp.repaint();
	}
    }

    public void addUIComp(JComponent comp, JPanel panel) {
	panel.add(comp);
	uicomps.add(comp);
    }

    public void removeUIComp(int index) {
	uicomps.remove(index);
    }

    public void removeUIComp(JComponent comp) {
	uicomps.remove(comp);
    }

}
