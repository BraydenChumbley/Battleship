/*
 * Tony Brayden Josh
 * June 6 2019
 * This class handles the user inputs of the game
 */
package battleship.game.io;

import battleship.game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author Brayden Chumbley
 */
public class Input implements MouseMotionListener, MouseWheelListener, KeyListener, MouseListener {

    
    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

    /**
     * This constructor handles the 
     * @param game 
     */
    public Input(Game game) {
	//this.game = game;
	mouseX = 0;
	mouseY = 0;
	scroll = 0;

	game.addKeyListener(this);
	game.addMouseListener(this);
	game.addMouseMotionListener(this);
	game.addMouseWheelListener(this);
    }

    /**
     * 
     */
    public void update() {
	for (int i = 0; i < NUM_KEYS; i++) {
	    keysLast[i] = keys[i];
	}
	for (int i = 0; i < NUM_BUTTONS; i++) {
	    buttonsLast[i] = buttons[i];
	}
    }

    /**
     * Make scroll wheel a input
     * @return 
     */
    public int scoll() {
	return scroll;
    }

    /**
     * 
     * @param keyCode
     * @return 
     */
    public boolean isKey(int keyCode) {
	return keys[keyCode];
    }

    /**
     * 
     * @param keyCode
     * @return 
     */
    public boolean isKeyUp(int keyCode) {
	return !keys[keyCode] && keysLast[keyCode];
    }

    /**
     * 
     * @param keyCode
     * @return 
     */
    public boolean isKeyDown(int keyCode) {
	return keys[keyCode] && !keysLast[keyCode];
    }

    /**
     * 
     * @param button
     * @return 
     */
    public boolean isButton(int button) {
	return buttons[button];
    }

    /**
     * 
     * @param button
     * @return 
     */
    public boolean isButtonUp(int button) {
	return !buttons[button] && buttonsLast[button];
    }

    /**
     * 
     * @param button
     * @return 
     */
    public boolean isButtonDown(int button) {
	return buttons[button] && !buttonsLast[button];
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
	buttons[e.getButton()] = true;
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
	buttons[e.getButton()] = false;
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
	keys[e.getKeyCode()] = true;
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
	keys[e.getKeyCode()] = false;
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
	scroll = e.getWheelRotation();
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
	mouseX = (int) (e.getX());
	mouseY = (int) (e.getY());
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void mouseMoved(MouseEvent e) {
	mouseX = (int) (e.getX());
	mouseY = (int) (e.getY());
    }

    /**
     * 
     */
    public int getMouseX() {
	return mouseX;
    }

    /**
     * 
     * @return 
     */
    public int getMouseY() {
	return mouseY;
    }

}
