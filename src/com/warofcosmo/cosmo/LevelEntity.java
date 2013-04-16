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
    
    public LevelEntity(String Ibg,String Ibgm,int ispeed,int ilength,Board brd){
        ImageIcon i = new ImageIcon(getClass().getResource("/"+Ibg));
        _bgfx= i.getImage(); 
        _bgm=Ibgm;
        _speed=ispeed;
        _length=ilength;
        _brd=brd;
        LoadBGM(_bgm);
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
