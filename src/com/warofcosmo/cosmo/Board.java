package com.warofcosmo.cosmo;

import Entities.Enemy;
import Entities.AbstractEntity;
import Weapons.AbstractWeaponn;
import levelpackage.level1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import sun.audio.*;
import javax.swing.JPanel;



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
                catch(Exception ignore){}
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
                    
                    //If Player hits j restart
                    if(p.getBounds().intersects(en.getBounds())){
                        //enemy at j was hit by current weapon, remove both bullet and enemy
                        //Enemies.remove(en);
                        stopBGM(l.getBGM());
                        try{
                            Thread.sleep(5000);
                        }
                        catch(Exception ignore){}
                        Enemies.removeAll(Enemies);
                        
                        l.setX(0);
                        l.setY(0);
                        
                        p.setX(startX);
                        p.setY(startY);
                        
                        playBGM(l.getBGM());
                    }

                    //IF Enemy leaves board delete them from array
                    if(en.getY() < 0 || en.getY() > this.getSize().height){
                        Enemies.remove(i);
                    }
                    if(en.getX() < 0 ){
                        Enemies.remove(i);
                    }
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
                        //enemy at j was hit by current Reduce health and check if destroyed
			if(weap.getBounds().intersects(e.getBounds())){
                            weaps.remove(weap);
                            e.setHealth(weap.getDamage());
                            if(e.getHealth() <=0){
                                Enemies.remove(e);
                            }
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

	public void addBullit(AbstractWeaponn b) {
		weaps.add(b);
	}
	
	public void addEnemy(AbstractEntity e) {
            Enemies.add(e);
	}

}
