package com.warofcosmo.cosmo;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Frame extends JFrame {
	
	// contructor method
	public Frame(){
		
		add(new Board());
		setTitle("War of Cosmos");
		setSize(920, 820); 
                setResizable( false );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}

}
