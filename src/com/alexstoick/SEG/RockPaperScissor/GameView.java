package com.alexstoick.SEG.RockPaperScissor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by alexstoick on 10/8/14.
 */
public class GameView {

	private JButton paperButton;
	private JButton scissorsButton;

	public JPanel getRootPanel () {
		return rootPanel;
	}

	private JButton rockButton;
	private JTextArea statusTextArea;
	private JPanel rootPanel;

	public JTextArea getStatusTextArea () {
		return statusTextArea;
	}

	private final Client client ;

	public GameView ( final Client client) {
		this.client =  client ;
		try {
			System.out.println ( "321" ) ;
			statusTextArea.append ("Connected:" + client.getLastLine() + "\n");
			System.out.println ( "3213" ) ;
		} catch ( IOException exception ) {
			statusTextArea.append ( "Lost connection" ) ;
		}

		paperButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice("paper");
			}
		});
	}
}
