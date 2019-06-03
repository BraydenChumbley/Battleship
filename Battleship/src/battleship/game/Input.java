/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

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

    //private Game game;
    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

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

    public void update() {
	for (int i = 0; i < NUM_KEYS; i++) {
	    keysLast[i] = keys[i];
	}
	for (int i = 0; i < NUM_BUTTONS; i++) {
	    buttonsLast[i] = buttons[i];
	}
    }

    public int scoll() {
	return scroll;
    }

    public boolean isKey(int keyCode) {
	return keys[keyCode];
    }

    public boolean isKeyUp(int keyCode) {
	return !keys[keyCode] && keysLast[keyCode];
    }

    public boolean isKeyDown(int keyCode) {
	return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isButton(int button) {
	return buttons[button];
    }

    public boolean isButtonUp(int button) {
	return !buttons[button] && buttonsLast[button];
    }

    public boolean isButtonDown(int button) {
	return buttons[button] && !buttonsLast[button];
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
	buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	buttons[e.getButton()] = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
	keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
	keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
	scroll = e.getWheelRotation();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
	mouseX = (int) (e.getX());
	mouseY = (int) (e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
	mouseX = (int) (e.getX());
	mouseY = (int) (e.getY());
    }

    public int getMouseX() {
	return mouseX;
    }

    public int getMouseY() {
	return mouseY;
    }

}