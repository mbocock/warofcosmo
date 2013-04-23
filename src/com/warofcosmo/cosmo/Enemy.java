package com.warofcosmo.cosmo;

import java.awt.event.ActionEvent;

public class Enemy extends AbstractEntity{
	

	public Enemy(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty) {
		super(brd,imgcount,imgname,imgextension,startx,starty);
                _speed=-1;
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
