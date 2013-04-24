package com.warofcosmo.cosmo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Enemy extends AbstractEntity{
	

	public Enemy(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty,int width,int height) {
		super(brd,imgcount,imgname,imgextension,startx,starty,width,height);
                _speed=0;
                _width=width;
                _height=height;
	}

	@Override
	public void move() {
   
            _x = _x+_speed;
           // _y = _y+_speed;
		
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
            //if(_dy<0)
            //_gfx=_shipimg.get(1).getImage();
            //if(_dy>0)
            //_gfx=_shipimg.get(2).getImage();
            
	}

}
