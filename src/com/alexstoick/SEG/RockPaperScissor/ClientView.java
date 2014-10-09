package com.alexstoick.SEG.RockPaperScissor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexstoick on 10/8/14.
 */
public class ClientView {
	private JPanel rootPanel;
	private JButton goButton;
	private JLabel connectionStatus;

	public ClientView (final JFrame parentFrame) {
		goButton.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				Client client = new Client( "localhost") ;
				boolean response = false ;
				try {
					response = client.connect ();
				} catch ( Exception exception ) {
					connectionStatus.setText( exception.toString () ) ;
				}
				if ( response == true )
				{
					GameView gameView = new GameView ( client );
					parentFrame.setContentPane ( gameView.getRootPanel () );
					parentFrame.pack();
				}
			}
		});
	}

	public JPanel getRootPanel () {
		return rootPanel;
	}
}
