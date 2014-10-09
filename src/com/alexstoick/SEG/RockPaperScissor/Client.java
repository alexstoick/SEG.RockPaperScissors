package com.alexstoick.SEG.RockPaperScissor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by alexstoick on 10/8/14.
 */
public class Client {

	private String serverIPAddress ;
	private PrintWriter out ;
	private BufferedReader in ;
	private Socket socket;
	private int client_number ;
	private static final int SERVER_PORT = 4444 ;

	public Client (String serverIPAddress) {
		this.serverIPAddress = serverIPAddress;
	}

	public String getLastLine() throws IOException{
		return in.readLine ();
	}

	public String getStatus() {
		return GameManagement.getCurrentState () ;
	}

	public void sendChoice(String choice) {
		out.println ( "client" + client_number + ":" + choice );
	}

	public boolean connect() throws Exception {
		System.out.println("trying to connect" ) ;

		try {
			this.socket = new Socket ( serverIPAddress , SERVER_PORT ) ;
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in  = new BufferedReader( new InputStreamReader (socket.getInputStream()));
			this.client_number = Integer.parseInt (in.readLine ());
			System.out.println("connected");
			return true;
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host localhost " );
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to localhost" );
			System.exit(1);
		}
		return false ;
	}
}
