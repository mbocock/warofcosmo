/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warofcosmo.cosmo;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public class LevelEntity {
    private Image _bgfx;
    private int _speed;
    private int _length;
    private int _frlength=920;
    private int _dx=0;
    private int _dy=0;
    private String _bgm;
    private AudioStream as;
    private AudioStream bs;
    private Board _brd;
    
    public LevelEntity(String Array[],Board brd){
        
       // String Ibg,String Ibgm,int ispeed,int ilength,Board brd)
        
        
		ImageIcon i = new ImageIcon(getClass().getResource("/"+Array[0]));
		_bgfx= i.getImage();
		_bgm=Array[1];
		_speed= Integer.parseInt(Array[2]);
		_length= Integer.parseInt(Array[3]);
		_brd=brd;
		LoadBGM(_bgm);
        
		//Enemy E = new Enemy(brd,1,"s2",".png",600,400);
		_brd.addEnemy(new Enemy(_brd,1,"er",".png",600,400,96,45));
		_brd.addEnemy(new Enemy(_brd,3,"e3l",".png",600,300,32,16));
                _brd.addEnemy(new Enemy(_brd,3,"e3l",".png",600,600,32,16));
        
    }
    
    private void LoadBGM(String ibgm){
        try{
            String path = new java.io.File(".").getCanonicalPath();
            InputStream in = new FileInputStream(path+"/resources/"+ibgm);
            as = new AudioStream(in);
	   InputStream inb = new FileInputStream(path+"/resources/boss.wav");
            bs = new AudioStream(inb);
        }
        catch(Exception e){
            System.out.println("Grumpy Cat says, 'Error Loading media, good!'");
        }
        
    }
    public void Move(){
        _dx=_dx-_speed;
		if(_dx- _brd.getSize().width<=-_length){
			_speed=0;
			_brd.stopBGM(as);
			//_brd.playBGM(bs);
                        _brd.LoadNext();
		}
    }
    public int getX(){
        return _dx;
    }
    public int getY(){
        return _dy;
    }
    public AudioStream getBGM(){
        return as;
    }
    
    public Image getBG(){        
        return _bgfx;
    }
    
    public int getLength(){
        return _length;
    }

}
