/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayden Chumbley
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 500, HEIGHT = 500;

    private final Window window;

    private Thread thread;
    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private double runTime = 0;

    public Game() {
	window = new Window(WIDTH, HEIGHT, "Battleship", this);
    }

    public synchronized void start() {
	thread = new Thread(this);
	thread.start();
	running = true;
    }

    public synchronized void stop() {
	try {
	    thread.join();
	    running = false;
	} catch (InterruptedException ex) {
	    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void run() {
	this.requestFocus();
	running = true;
	boolean render = false;
	double firstTime = 0;
	double lastTime = System.nanoTime() / 1000000000.0;
	double passedTime = 0;
	double unprocessedTime = 0;

	double frameTime = 0;
	int frames = 0;
	int fps = 0;

	while (running) {
	    render = false;

	    firstTime = System.nanoTime() / 1000000000.0;
	    passedTime = firstTime - lastTime;
	    lastTime = firstTime;

	    unprocessedTime += passedTime;
	    frameTime += passedTime;
	    while (unprocessedTime >= UPDATE_CAP) {
		unprocessedTime -= UPDATE_CAP;
		render = true;

		update((float) UPDATE_CAP);
		//Input update goes here in.update()

		if (frameTime >= 1.0) {
		    frameTime = 0;
		    fps = frames;
		    frames = 0;
		    System.out.println("FPS: " + fps);
		}
	    }

	    if (render) {
		render();
		frames++;
	    } else {
		try {
		    Thread.sleep(1);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
	stop();
    }
    
    private void update(float dt) {
	//Update game logic here
    }

    private void render() {
	BufferStrategy bs = this.getBufferStrategy();
	if (bs == null) {
	    this.createBufferStrategy(2);
	    return;
	}

	Graphics g = bs.getDrawGraphics();
	
	//Draws background as black. DONT DRAW ANYTHING ABOVE THESE LINES!!!
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
	//Drawing begins
	
	//Drawing ends
	
	g.dispose();
	bs.show();
    }

    public static void main(String[] args) {
	new Game();
    }

}
