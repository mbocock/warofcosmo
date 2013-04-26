package com.warofcosmo.cosmo;

import com.warofcosmo.cosmo.levelpackage.level1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import sun.audio.*;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel implements Runnable, KeyListener {
	
        private Image bgimg;
        private Player p;
        private level1 l;
        protected AudioStream as;
        private int level;
	private int size;
        private ArrayList weaps;
        private ArrayList Enemies;
        private ArrayList LevelArr;
        private int startX;
        private int startY;
        private int BWidth=5020;
        private int BHeight=920;
	
	// contructor method
	public Board(){
                 
                level=0;
                LevelArr = new ArrayList();
                weaps = new ArrayList();
                Enemies = new ArrayList();
                
                // TESTING
                l=new level1(this);
                
                bgimg=l.getBG();
                as=l.getBGM();
                size=bgimg.getWidth(this);
                AudioPlayer.player.start(as);
	      
	        playBGM(as);	
               
	        addKeyListener(this);
                setFocusable(true);
                setFocusTraversalKeysEnabled(false); 
                
                p = new Player(this);
                
                startX=p.getX();
                startY=p.getY();

                //time = new Timer(5,this);
	        //time.start();
                Thread mainthread=new Thread(this);
                mainthread.start();
           System.out.println(this.getWidth());
	}
	
 
        
	public void playBGM(AudioStream bgm){
		AudioPlayer.player.start(bgm);
	}
	
	public void stopBGM(AudioStream bgm){
		AudioPlayer.player.stop(bgm);
	}
        
        public void LoadNext(){
            level++;
            System.out.println(level);
            l=(level1) LevelArr.get(level);
            bgimg=l.getBG();
            as=l.getBGM();
            playBGM(as);
            size=bgimg.getWidth(null);
            p.setX(startX);
            p.setY(startY);
        }
	

	@Override
	public void run() {
            
            while(true){
                try{
                    p.move();
                    l.Move();
                
                    for(int i=0; i<Enemies.size();i++){
                        Enemy en=((Enemy)Enemies.get(i));
                        en.move();
                    }
                
                    repaint();
                    Thread.sleep(5);
                    
                }
                catch(Exception ignore){
                
                }
            }
	}
        
        @Override
        public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(bgimg,l.getX(),0,null);
                g2d.drawImage(p.getImage(),p.getX(),p.getY(),null);
                
                for(int i=0; i<Enemies.size();i++){
                    Enemy en=((Enemy)Enemies.get(i));
                    g2d.drawImage(en.getImage(),en.getX(),en.getY(),null);
                }
                
                for (int i = 0 ; i < weaps.size(); i++){
                    AbstractWeaponn weap = ((AbstractWeaponn)weaps.get(i));
                    g2d.drawImage(weap.getImage(),weap.getX(),weap.getY(),null);

                    if(weap.getX() >= p.getX()+weap.getDistance()){
                        weaps.remove(weap);
                    }
                    if(weap.getX() <= p.getX()-weap.getDistance()){
                        weaps.remove(weap);
                    }
                    for(int j=0; j < Enemies.size();j++){
				Enemy e = ((Enemy)Enemies.get(j));
				if(weap.getBounds().intersects(e.getBounds())){
					//enemy at j was hit by current weapon, remove both bullet and enemy
					weaps.remove(weap);
					Enemies.remove(e);
                                        System.out.println(Enemies.size());
				}
			}

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

	public void addBullit(AbstractWeaponn b) {;
		weaps.add(b);
	}
	
	public void addEnemy(AbstractEntity e) {
		//Enemies ArrayList had not been initialized at this point when you try to call this function
		//from LevelEntity, fix was just initialize your ArrayList before instantiating any LevelEntity
		Enemies.add(e);
	}

}
