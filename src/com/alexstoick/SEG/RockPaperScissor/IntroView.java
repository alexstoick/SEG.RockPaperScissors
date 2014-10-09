package com.alexstoick.SEG.RockPaperScissor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexstoick on 10/8/14.
 */
public class IntroView {
	private JPanel rootPanel;
	private JButton clientButton;
	private JButton serverButton;

	public JPanel getRootPanel () {
		return rootPanel;
	}

	public IntroView () {
		clientButton.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				JFrame clientFrame = new JFrame ("Client") ;
				ClientView clientView = new ClientView ( clientFrame ) ;
				clientFrame.setContentPane ( clientView.getRootPanel () );
				clientFrame.setMinimumSize ( new Dimension (400,400));
				clientFrame.pack();
				clientFrame.setVisible (true);
			}
		});
		serverButton.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				//keep this view but open the server view
				JFrame serverFrame = new JFrame ( "Server" ) ;
				ServerView serverView = new ServerView ();
				serverFrame.setContentPane ( serverView.getRootPanel () );
				serverFrame.setMinimumSize ( new Dimension (400,200));
				serverFrame.pack();
				serverFrame.setVisible (true);
			}
		});
	}
}
