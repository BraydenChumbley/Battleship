package battleship.server;

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
public class ServerGameController {

    private final ServerSocket ss;
    private final Server server;

    private Socket[] clients;

    public ServerGameController(int port, Server server) throws UnknownHostException, IOException {
	ss = new ServerSocket(port, 1, InetAddress.getLocalHost());
	clients = new Socket[2];
	this.server = server;
    }

    public void startGame() {
	clients[0] = connectClient();
	clients[1] = connectClient();
	runGame();
    }

    public void stopGame() {
	
    }

    public Socket connectClient() {
	boolean clientConnected = false;
	Socket s = null;
	while (!clientConnected) {
	    clientConnected = true;
	    try {
		s = ss.accept();
		clientConnected = true;
	    } catch (IOException ex) {
		Logger.getLogger(ServerGameController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return s;
    }

    private void runGame() {
	stopGame();
    }

}
