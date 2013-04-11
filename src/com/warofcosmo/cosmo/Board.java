package com.warofcosmo.cosmo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import sun.audio.*;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel implements ActionListener, KeyListener {
	
        private Image bgimg;
        private Timer time;
        private Player p;
        private LevelEntity l;
        protected AudioStream as;
        private int level;
	private int size;
        private ArrayList weaps; 
	
	// contructor method
	public Board(){
            
                level=1;

                if(level==1){
                l=new LevelEntity("bg2.png","project4.wav",1,3000,this);
                }else{
                l=new LevelEntity("mountains1.png","front-line.wav",1,3000,this);    
                }
                weaps = new ArrayList();
                bgimg=l.getBG();
                as=l.getBGM();
                size=bgimg.getWidth(this);
                //AudioPlayer.player.start(as);
	      
	       playBGM(as);	
               
	       addKeyListener(this);
                setFocusable(true);
                setFocusTraversalKeysEnabled(false); 
                
                p = new Player(this);
                
                time = new Timer(5,this);
	       time.start();
	}
	
	public void playBGM(AudioStream bgm){
		AudioPlayer.player.start(bgm);
	}
	
	public void stopBGM(AudioStream bgm){
		AudioPlayer.player.stop(bgm);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
                p.move();
                l.Move();
		repaint();
	}
        
        @Override
        public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(bgimg,l.getX(),0,null);
		g2d.drawImage(bgimg,size-l.getX(),0,null);
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
