package com.warofcosmo.cosmo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Enemy extends AbstractEntity{
	int[] p;
        int dir=-1;
        int _startX;
        int _startY;
        int dy=1;
	public Enemy(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty,int width,int height) {
		super(brd,imgcount,imgname,imgextension,startx,starty,width,height);
                _speed=-2;
                _width=width;
                _height=height;
                _startX=startx;
                _startY=starty;
                

	}

	@Override
	public void move() {
          
          
          
            

            System.out.println(_y);
            
            _x = _x+_speed;
           _y = _y + dy;
;
            if(_startY+100 > _y){
              dy=-dir;
          }
            if(_startY-100 < _y){
              dy=dir;
          }
		
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
            //if(_dy<0)
            //_gfx=_shipimg.get(1).getImage();
            //if(_dy>0)
            //_gfx=_shipimg.get(2).getImage();
            
	}

}
