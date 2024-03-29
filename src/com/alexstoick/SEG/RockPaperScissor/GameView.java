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

	private void setButtonsEnabled (boolean state)
	{
		rockButton.setEnabled ( state );
		paperButton.setEnabled ( state );
		scissorsButton.setEnabled ( state );
	}

	private final Client client ;

	public GameView ( final Client client) {
		this.client = client;

		addButtonListeners ();
		setButtonsEnabled ( false );
		try {
			statusTextArea.append ("Connected\n" + client.getLastLine () + "\n");
		} catch (IOException e) {
			e.printStackTrace ();
		}
		System.out.println ( client.getGameStatus () );

		waitUntilChoiceIsAvailable();


	}

	private void waitUntilChoiceIsAvailable() {
		( new Thread() {
			public void run () {
				while ( ! client.canMakeChoice()) ;
				System.out.println ( client.getGameStatus () );
				setButtonsEnabled ( true );
				statusTextArea.append ( client.getGameStatus () ) ;
				Thread.currentThread ().interrupt ();
			}
		}).start();
	}

	private void waitUntilFinished() {
		( new Thread() {
			public void run () {
				while ( ! client.isFinished()) ;
				System.out.println ( client.getGameStatus () );
				setButtonsEnabled ( true );
				statusTextArea.append ( client.getGameStatus () ) ;
				String[] results = client.getGameResults();
				statusTextArea.append ( "You "+ results[0] + ". The other player chose: " + results[1] ) ;
				Thread.currentThread ().interrupt ();
			}
		}).start();
	}

	private void addButtonListeners() {
		paperButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice("paper");
				statusTextArea.append ( "Selected Paper! \n");
				setButtonsEnabled ( false );
				waitUntilFinished();
			}
		});

		scissorsButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice ( "scissors" );
				statusTextArea.append ( "Selected Scissors! \n");
				setButtonsEnabled ( false );
				waitUntilFinished();
			}
		});

		rockButton.addActionListener ( new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				client.sendChoice ( "rock" );
				statusTextArea.append ( "Selected Rock! \n");
				setButtonsEnabled ( false );
				waitUntilFinished();
			}
		});
	}
}
