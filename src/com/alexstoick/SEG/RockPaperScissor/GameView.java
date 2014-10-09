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

	private void disableButtons ()
	{
		rockButton.setEnabled ( false );
		paperButton.setEnabled ( false );
		scissorsButton.setEnabled ( false );
	}

	private final Client client ;

	public GameView ( final Client client) {
		this.client =  client ;

		statusTextArea.append ("Connected:" + client.getStatus() + "\n");

		paperButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice("paper");
				statusTextArea.append ( "Selected Paper! \n");
				disableButtons();
			}
		});

		scissorsButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice ( "scissors" );
				statusTextArea.append ( "Selected Scissors! \n");
				disableButtons();
			}
		});

		rockButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice ( "rock" );
				statusTextArea.append ( "Selected Rock! \n");
				disableButtons();
			}
		});
	}
}
