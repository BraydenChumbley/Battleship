package battleship.game;

import battleship.game.io.Input;
import battleship.game.menus.CreditsMenu;
import battleship.game.menus.GameMenu;
import battleship.game.menus.JoinGameMenu;
import battleship.game.menus.MainMenu;
import battleship.game.menus.Score;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Brayden Chumbley
 */
public class Game extends JPanel implements Runnable {

    public static final int WIDTH = 1280, HEIGHT = 720; //The length and width of the window

    public static GAME_STATE GAMESTATE = GAME_STATE.MAIN_MENU; //GAME_STATE is used for the stages of the game
    private static boolean STATE_SWITCHED = false; //This is a boolean used for seeing if the game state has changed
    
    //Sounds used in the game
    public static AudioClip menuTheme = new AudioClip("res\\audio\\song.wav");
    public static AudioClip creditsTheme = new AudioClip("res\\audio\\credits.wav");
    public static AudioClip battleTheme = new AudioClip("res\\audio\\battletheme.wav");
    public static AudioClip battleSetupTheme = new AudioClip("res\\audio\\battlesetup.wav");

    public static Font GAMEFONT = null; //The font used for this game

    private Window window;
    private Input input;
    private GameController gc;

    private GameObjectHandler goHandler;
    private JPanel contentPanel;

    private Thread thread;
    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private double runTime = 0;

    public Game() {
	try {
	    goHandler = new GameObjectHandler(this);

	    init();

	    input = new Input(this);

	    gc = new GameController(this);
	    for (int x = 0; x < 10; x++) {
		for (int y = 0; y < 10; y++) {
		    goHandler.addObj(gc.getBoardLayout()[x][y]);
		}
	    }

	    gc.startPlacementPhase(this);

	    //goHandler.addObj(new Ship(gc.getBoardLayout()[1][0], 1, false));
	    window = new Window(WIDTH, HEIGHT, "Battleship", this);

	    Game.menuTheme.loop();
	} catch (IOException ex) {
	    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
	    System.exit(1); 
	}
    }

    private void init() {
	setBackground(Color.BLACK); //The background of the game is set to black
	setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
	setLayout(null);

	contentPanel = new MainMenu();
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
		input.update();

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

    /**
     * When the mouse is clicked get the x and y coordinates
     * @param e - MouseEvent object
     */
    public void mouseClicked(MouseEvent e) {
	int x = e.getX();
	int y = e.getY();
	System.out.println("X:" + x + " Y:" + y);
    }

    
    private void update(float dt) {
	//Update game logic here
	if (STATE_SWITCHED) {
	    remove(contentPanel);
	    switch (GAMESTATE) {
		case MAIN_MENU:
		    contentPanel = new MainMenu();
		    break;
		case CREDITS_MENU:
		    contentPanel = new CreditsMenu();
		    break;
		case JOIN_MENU:
		    contentPanel = new JoinGameMenu();
		    break;
		case GAME:
		    contentPanel = new GameMenu(this);
		    break;
		case SCORE:
		    contentPanel = new Score();
		    break;
	    }
	    System.out.println("Adding: " + contentPanel.getClass());
	    add(contentPanel);
	    STATE_SWITCHED = false;
	}
	if (GAMESTATE == GAME_STATE.GAME) {
	    gc.update(this);
	}
	goHandler.update(this);
    }

    private void draw(Graphics g) {

	Graphics2D g2D = (Graphics2D) g;

	//Drawing begins
	goHandler.draw(g);

	//Drawing ends
	contentPanel.repaint();
    }

    /**
     * Draws the game
     * @param g - Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	draw(g);
    }

    public static void setGameState(GAME_STATE newState) {
	GAMESTATE = newState;
	STATE_SWITCHED = true;
    }

    public Input getInput() {
	return input;
    }

    public GameObjectHandler getGOHandler() {
	return goHandler;
    }
    
    public GameController getGC(){
	return gc;
    }

    public static void main(String[] args) {
	try {
	    GAMEFONT = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\font.ttf"));
	    new Game();
	} catch (FontFormatException ex) {
	    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
