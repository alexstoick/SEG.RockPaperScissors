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
			out.println ( ++client_count ) ;
			GameManagement.playerJoined() ;
			String inputLine ;

			while ((inputLine = in.readLine()) != null) {
				System.out.println ( inputLine ) ;
				out.println(inputLine);
				if (inputLine.equals("Bye"))
					break;
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
