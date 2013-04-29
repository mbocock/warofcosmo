package Entities;

import com.warofcosmo.cosmo.Board;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Enemy extends AbstractEntity{
	int[] p;
        int dir=-1;
        int _startX;
        int _startY;
        int dy=1;
	public Enemy(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty) {
		super(brd,imgcount,imgname,imgextension,startx,starty);
                _speed=-2;
                _startX=startx;
                _startY=starty;
                

	}

	@Override
	public void move() {
            
          _x = _x+_speed;
          _y = _y + dy;
/*
            if(_startY+100 > _y){
              dy=-dir;
          }
            if(_startY-100 < _y){
              dy=dir;
          }
*/		
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
            //if(_dy<0)
            //_gfx=_shipimg.get(1).getImage();
            //if(_dy>0)
            //_gfx=_shipimg.get(2).getImage();
            
	}

}
