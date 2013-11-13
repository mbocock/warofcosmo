package Entities;

import com.warofcosmo.cosmo.Board;
import java.awt.event.ActionEvent;
import projectiles.ProjectileSpawner;

public class Enemy2 extends Enemy implements Runnable{
        
	public Enemy2(Board brd,int startx, int starty) {

		super(brd,3,"e3l",".png",startx,starty,"Enemy_Hit",15,15,20);
                
                _speed=-1;
                _startX=startx;
                _startY=starty;
                _points=150;
                
                for(int x=0;x<200;x++){
                    marrayY[x]=0;

                    marrayX[x]=-3;     
                }
                
              //  ProjectileSpawner _projSpawner = new ProjectileSpawner(this,500,_pwidth,_pheight);
                
             //   Thread enemythread=new Thread(this);
             //   enemythread.start();
                
            //    _brd.addEnemy(new Enemy(_brd,3,"e3l",".png",px,300));

	}

	@Override
	public void move() {
       
          //_x = _x + -1;
          //_y = _y + dy;

                _x = _x + marrayX[step];
          
          if(count<230){
            _y = _y + marrayY[step];
          }else{
            _y = _y + -1;
          }
          
          step++;
          
          if(step==200){
              step=0;   
          }
          count++;


/*
            if(_startY+100 > _y && dy!=1){
              dy=-dir;
              
          }
            if(_startY-100 < _y && dy!=-1){
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
