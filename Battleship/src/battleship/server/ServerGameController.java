package battleship.server;

import battleship.game.Game;
import battleship.game.Tile;
import battleship.game.Utils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayden Chumbley
 */
public class ServerGameController implements Runnable {

    private Thread thread;
    private boolean running;

    private final ServerSocket ss;
    private final Server server;

    private Socket[] clients;

    private Tile[][] b1, b2;
    private final int boardSize;

    private Timer p1Updates, p2Updates;
    private String p1Name, p2Name;
    private boolean p1Ready, p2Ready;

    public ServerGameController(int port, Server server) throws UnknownHostException, IOException {
	ss = new ServerSocket(port, 1, InetAddress.getLocalHost());
	clients = new Socket[2];
	this.server = server;
	boardSize = 10;

	p1Updates = new Timer();
	p2Updates = new Timer();

	p1Ready = false;
	p2Ready = false;

	server.logEvent("SERVER_CREATED", "Server created at " + ss.getInetAddress() + ":" + ss.getLocalPort());
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

    public Socket connectClient() throws IOException {
	server.logEvent("AWAITING_CONNECTION", "Server is waiting for client connection at " + ss.getInetAddress() + ":" + ss.getLocalPort());
	Socket s = ss.accept();

	return s;
    }

    @Override
    public void run() {
	try {
	    boolean serverFull = false;
	    while (!serverFull) {
		try {
		    if (clients[0] == null) {
			clients[0] = connectClient();
			final DataOutputStream p1Out = new DataOutputStream(clients[0].getOutputStream());
			final DataInputStream p1In = new DataInputStream(clients[0].getInputStream());

			p1Name = p1In.readUTF();
			server.logEvent("CONNECTION_AQUIRED", p1Name + " has connected! " + clients[0].getInetAddress() + ":" + clients[0].getLocalPort());

			TimerTask p1LobbyTask = new TimerTask() {
			    @Override
			    public void run() {
				try {
				    String data = p1In.readUTF();
				    System.out.println(data);
				    if (data.equalsIgnoreCase("quit")) {
					server.logEvent("CLIENT_QUIT", p1Name + " left the server");
					clients[0] = null;
					//this.cancel();
				    }
				    if (data.equalsIgnoreCase("ready")) {
					server.logEvent("PLAYER_READY", p1Name + " is ready");
					p1Ready = true;
					b1 = Utils.receiveBoard(p1In);
				    }

				} catch (IOException ex) {
				    Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
				}
			    }
			};

			p1Updates.scheduleAtFixedRate(p1LobbyTask, 0, 100);
		    } else if (clients[1] == null) {
			clients[1] = connectClient();
			final DataOutputStream p2Out = new DataOutputStream(clients[1].getOutputStream());
			final DataInputStream p2In = new DataInputStream(clients[1].getInputStream());

			p1Name = p2In.readUTF();
			server.logEvent("CONNECTION_AQUIRED", p2Name + " has connected! " + clients[1].getInetAddress() + ":" + clients[1].getLocalPort());

			TimerTask p2LobbyTask = new TimerTask() {
			    @Override
			    public void run() {
				try {
				    String data = p2In.readUTF();
				    System.out.println(data);
				    if (data.equalsIgnoreCase("quit")) {
					server.logEvent("CLIENT_QUIT", p2Name + " left the server");
					clients[1] = null;
					//this.cancel();
				    }
				    if (data.equalsIgnoreCase("ready")) {
					server.logEvent("PLAYER_READY", p2Name + " is ready");
					p2Ready = true;
					b2 = Utils.receiveBoard(p2In);
				    }

				} catch (IOException ex) {
				    Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
				}
			    }
			};

			p1Updates.scheduleAtFixedRate(p2LobbyTask, 0, 100);
		    } else {
			serverFull = true;
		    }
		} catch (IOException ex) {
		    Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }

	    server.logEvent("GAME_STARTED", "Starting the game...");

	    server.logEvent("GAME_STARTED", "Generating board layouts...");

	    b1 = new Tile[boardSize][boardSize];
	    b2 = new Tile[boardSize][boardSize];

	    for (int x = 0; x < boardSize; x++) {
		for (int y = 0; y < boardSize; y++) {
		    b1[x][y] = new Tile(x, y);
		    b2[x][y] = new Tile(x, y);
		}
	    }

	    DataOutputStream p1Out = new DataOutputStream(clients[0].getOutputStream());
	    DataInputStream p1In = new DataInputStream(clients[0].getInputStream());
	    
	    DataOutputStream p2Out = new DataOutputStream(clients[0].getOutputStream());
	    DataInputStream p2In = new DataInputStream(clients[0].getInputStream());

	    Utils.sendBoard(b1, p1Out);
	    Utils.sendBoard(b2, p2Out);

	    p1Out.writeUTF("placementPhase");
	    p1Out.writeBoolean(true);
	    
	    p2Out.writeUTF("placementPhase");
	    p2Out.writeBoolean(true);

	    server.logEvent("PLACE_PHASE", "Server is waiting for clients to place ships");
	    
	    while (!(p1Ready && p2Ready)) {
		System.out.println("waiting");
	    }

	    server.logEvent("ATTACK_PAHSE", "All players are ready");

	    p1Out.writeUTF("enemyBoard");
	    Utils.sendBoard(b2, p1Out);
	    
	    p2Out.writeUTF("enemyBoard");
	    Utils.sendBoard(b1, p2Out);

	    boolean attackPhase = true;
	    int xGuess = 0, yGuess = 0;

	    while (attackPhase) {
		server.logEvent("ATTACK_PHASE", "It is " + p1Name + "\'s turn");
		
		p1Out.writeUTF("isTurn");
		p1Out.writeBoolean(true);
		p2Out.writeUTF("isTurn");
		p2Out.writeBoolean(false);
		
		xGuess = p1In.readInt();
		yGuess = p1In.readInt();
		
		server.logEvent("ATTACK_PHASE", "Shot fired at " + xGuess + ":" + yGuess);

		p2Out.writeInt(xGuess);
		p2Out.writeInt(yGuess);
		
		
		server.logEvent("ATTACK_PHASE", "It is " + p2Name + "\'s turn");
		p1Out.writeUTF("isTurn");
		p1Out.writeBoolean(false);
		p2Out.writeUTF("isTurn");
		p2Out.writeBoolean(true);
		
		xGuess = p1In.readInt();
		yGuess = p1In.readInt();
		
		server.logEvent("ATTACK_PHASE", "Shot fired at " + xGuess + ":" + yGuess);

		p2Out.writeInt(xGuess);
		p2Out.writeInt(yGuess);
	    }

	    stop();
	} catch (IOException ex) {
	    Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
