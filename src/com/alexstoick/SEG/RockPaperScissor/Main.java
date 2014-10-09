package com.alexstoick.SEG.RockPaperScissor;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
	    JFrame frame = new JFrame ("FirstWindow");
	    IntroView introView= new IntroView () ;
	    frame.setContentPane ( introView.getRootPanel() );
	    frame.setMinimumSize (new Dimension (400, 200));
	    frame.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
	    frame.pack ();
	    frame.setVisible (true);
    }
}
