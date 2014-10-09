package com.alexstoick.SEG.RockPaperScissor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexstoick on 10/8/14.
 */
public class ServerView{
	public JPanel getRootPanel () {
		return rootPanel;
	}

	private JPanel rootPanel;
	private JButton startButton;
	private JLabel serverStatus;

	public ServerView () {
		serverStatus.setText ( "Server not running!");
		startButton.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				try {
					Server server = new Server();
					String ip_address = server.getLocalIPAddress () ;
					server.start();
					startButton.setEnabled ( false );
					serverStatus.setText ( "Server running at:" + ip_address);
				} catch ( Exception exception ) {
					serverStatus.setText ( "Server failed starting!" + exception);
				} finally {
					startButton.setEnabled ( true );
				}

			}
		});
	}
}
