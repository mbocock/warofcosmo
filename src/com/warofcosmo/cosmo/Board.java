package com.warofcosmo.cosmo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import sun.audio.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel implements ActionListener, KeyListener {
	
	private Image bgimg;
        private Timer time;
        private Player p;
        private ArrayList weaps;
	
	// contructor method
	public Board(){
                weaps = new ArrayList();
		ImageIcon i = new ImageIcon(getClass().getResource("/map.png"));
		bgimg = i.getImage();
                
                addKeyListener(this);
                setFocusable(true);
                setFocusTraversalKeysEnabled(false); 
                
                p = new Player(this);
                
                time = new Timer(5,this);
		time.start();
                
           try{     
                String path = new java.io.File(".").getCanonicalPath();
                InputStream in = new FileInputStream(path+"/resources/project4.wav");
                AudioStream as = new AudioStream(in);
                AudioPlayer.player.start(as);
                
           }
           catch(Exception e){
               System.out.println(e);
           }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
                p.move();
		repaint();
	}
        
        @Override
        public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(bgimg,0,0,null);
                g2d.drawImage(p.getImage(),p.getX(),p.getY(),null);
                
                for (int i = 0 ; i < weaps.size(); i++){
			AbstractWeaponn weap = ((AbstractWeaponn)weaps.get(i));
			g2d.drawImage(weap.getImage(),weap.getX(),weap.getY(),null);
			
			if(weap.getX() >= p.getX()+weap.getDistance()){
				weaps.remove(weap);
			}
                        if(weap.getX() <= p.getX()-weap.getDistance()){
				weaps.remove(weap);
			}
			
			/*for(int j=0; j < enemies.size();j++){
				Enemy e = enemies.get(j);
				if(weap.getBounds().intersects(e.getBounds())){
					//enemy at j was hit by current weapon, remove both bullet and enemy
					weaps.remove(weap);
					enemies.remove(e);
				}
			}*/
			
		}

        }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
        
        public void addBullit(AbstractWeaponn b) {
		weaps.add(b);
	}
}
