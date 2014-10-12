package com.alexstoick.SEG.RockPaperScissor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by alexstoick on 10/8/14.
 */
public class ServerListener extends Thread {

	private Socket socket ;
	private static int client_count = 0 ;
	private int myClient ;

	public ServerListener( Socket clientSocket) {
		super("ServerThread");
		this.socket = clientSocket ;
	}

	public void run () {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader (
							socket.getInputStream()));
			if ( client_count + 1 > 2 ){
				socket.close();
				return ;
			}
			myClient = ++client_count ;
			out.println ( myClient ) ;
			System.out.println(client_count);
			out.println ( GameManagement.playerJoined() );
			String inputLine ;
			while ( (inputLine = in.readLine ()) != null ){
				System.out.println ( "client " + myClient + " sent " + inputLine );
				if ( inputLine.equals("status") )
					out.println( GameManagement.getCurrentState () ) ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
