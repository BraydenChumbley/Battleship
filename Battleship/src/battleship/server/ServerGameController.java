package battleship.server;

import battleship.game.Game;
import battleship.game.Tile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
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

    public ServerGameController(int port, Server server) throws UnknownHostException, IOException {
	ss = new ServerSocket(port, 1, InetAddress.getLocalHost());
	clients = new Socket[2];
	this.server = server;
	boardSize = 10;
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
	s.setSoTimeout(1);
	server.logEvent("CONNECTION_AQUIRED", "A client has connected! " + s.getInetAddress() + ":" + s.getLocalPort());
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
		    } else if (clients[1] == null) {
			clients[1] = connectClient();
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
	    
	    for(int x = 0; x < boardSize; x++){
		for(int y = 0; y < boardSize; y++){
		    b1[x][y] = new Tile(50*(x+1), 50*(y+1));
		    b2[x][y] = new Tile(50*(x+1), 50*(y+1));
		}
	    }
	    
	    DataOutputStream p1Out = (DataOutputStream) clients[0].getOutputStream();
	    DataInputStream p1In = (DataInputStream) clients[0].getInputStream();
	    
	    DataOutputStream p2Out = (DataOutputStream) clients[0].getOutputStream();
	    DataInputStream p2In = (DataInputStream) clients[0].getInputStream();
	    
	    //p1Out.writeUTF(Arrays.toString(b1));
	    //p2Out.writeUTF(Arrays.toString(b2));
	    
	    for(int i = 0; i < boardSize; i++){
		System.out.println(Arrays.toString(b1[i]));
	    }
	    
	    server.logEvent("PLACE_PHASE", "Server is waiting for clients to place ships");
	    
	    
	    
	    stop();
	} catch (IOException ex) {
	    Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
