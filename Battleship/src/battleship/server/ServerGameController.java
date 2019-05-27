package battleship.server;

import battleship.game.Game;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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

    public ServerGameController(int port, Server server) throws UnknownHostException, IOException {
	ss = new ServerSocket(port, 1, InetAddress.getLocalHost());
	clients = new Socket[2];
	this.server = server;
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
	boolean serverFull = false;
	while(!serverFull){
	    try {
		if(clients[0] == null){
		    clients[0] = connectClient();
		}
		else if(clients[1] == null){
		    clients[1] = connectClient();
		}
		else{
		    serverFull = true;
		}
	    } catch (IOException ex) {
		Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	stop();
    }

}
