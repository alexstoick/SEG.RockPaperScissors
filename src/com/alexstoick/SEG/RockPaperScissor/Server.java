package com.alexstoick.SEG.RockPaperScissor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by alexstoick on 10/8/14.
 */
public class Server {
	//handles all the sockets logic

	private String localIPAddress ;
	private ServerSocket socket;
	private BufferedReader in ;
	private PrintWriter out ;

	public Server() throws UnknownHostException {
		this.localIPAddress = InetAddress.getLocalHost().getHostAddress();
	}

	public ServerSocket getSocket () {
		return socket;
	}

	public String getLocalIPAddress () {
		return localIPAddress;
	}

	public void start() throws Exception {
		this.socket = new ServerSocket (4444);
		System.out.println( "Started server" ) ;
		while ( true ) {
			new ServerListener( socket.accept() ).start() ;
		}
//		ServerListener client1 = new ServerListener( socket.accept() ) ;
//		client1.start() ;
//		ServerListener client2 = new ServerListener( socket.accept() ) ;
//		client2.start() ;
	}
}
