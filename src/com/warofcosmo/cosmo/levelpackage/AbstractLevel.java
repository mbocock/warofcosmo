/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warofcosmo.cosmo.levelpackage;

import com.warofcosmo.cosmo.Board;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public abstract class AbstractLevel implements ILevel{
    private Image _bgfx;
    private int _length;
    protected int _dx;
    protected int _dy;
    private String _bgm;
    private AudioStream as;
    private AudioStream bs;
    private Board _brd;
    
    public AbstractLevel(Board brd,String ibg,String ibgm,int istartX,int istartY){
		ImageIcon i = new ImageIcon(getClass().getResource("/"+ibg));
		_bgfx= i.getImage();
		_bgm=ibgm;
		_brd=brd;
		LoadBGM(_bgm);   
                _dx=istartX;
                _dy=istartY;
    }
    
    @Override
    public void LoadBGM(String ibgm){
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
    @Override
    public abstract void Move();
    
    @Override
    public int getX(){
        return _dx;
    }
    @Override
    public int getY(){
        return _dy;
    }
    @Override
    public AudioStream getBGM(){
        return as;
    }
    @Override
    public Image getBG(){        
        return _bgfx;
    }
    @Override
    public int getLength(){
        return _length;
    }

}
