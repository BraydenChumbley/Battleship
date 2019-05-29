package battleship.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class Game extends JPanel implements Runnable {

    public static final int WIDTH = 1280, HEIGHT = 720;
    
    public static GAME_STATE GAMESTATE = GAME_STATE.MAIN_MENU;
    private static boolean STATE_SWITCHED = false;

    private final Window window;
    private GameObjectHandler goHandler;
    private JPanel contentPanel;

    JButton btn;

    private Thread thread;
    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private double runTime = 0;

    public Game() {
	
	goHandler = new GameObjectHandler(this);

	init();

	window = new Window(WIDTH, HEIGHT, "Battleship", this);
    }

    private void init() {
	setBackground(Color.BLACK);
	setLayout(null);
	
	contentPanel = GAMESTATE.getPanel();
	add(contentPanel);
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
	requestFocus();
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
		repaint();
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
	if(STATE_SWITCHED){
	    remove(contentPanel);
	    contentPanel = GAMESTATE.getPanel();
	    add(contentPanel);
	    STATE_SWITCHED = false;
	}
    }

    private void draw(Graphics g) {

	Graphics2D g2D = (Graphics2D) g;

	//Drawing begins
	//Drawing ends
	contentPanel.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	draw(g);
    }
    
    public static void setGameState(GAME_STATE newState){
	GAMESTATE = newState;
	STATE_SWITCHED = true;
    }

    public static void main(String[] args) {
	new Game();
    }

}
