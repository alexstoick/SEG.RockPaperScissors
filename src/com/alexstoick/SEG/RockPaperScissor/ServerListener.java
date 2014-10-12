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
	private int myClientID ;

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
			myClientID = ++client_count ;
			out.println ( myClientID ) ;
			System.out.println(client_count);
			out.println ( GameManagement.playerJoined() );
			String inputLine ;
			while ( (inputLine = in.readLine ()) != null ){
				System.out.println ( "client " + myClientID + " sent " + inputLine);
				if ( inputLine.equals("status") ) {
					System.out.println ( "response: " + GameManagement.getCurrentState () ) ;
					out.println (GameManagement.getCurrentState ());
				}
				if ( inputLine.contains ( "choice") ) {
					String choice = inputLine.split ( ":" )[1];
					GameManagement.playerMadeChoice ( myClientID , choice );
				} else if ( inputLine.equals ("getWinner") ) {
					out.println ( GameManagement.getWinnerID () ) ;
				} else if ( inputLine.equals ( "getOtherPlayerChoice") ) {
				    out.println ( GameManagement.getOtherPlayerChoice( myClientID ) ) ;
				} else {
					out.println ( "Wrong!" ) ;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
