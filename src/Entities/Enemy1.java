package Entities;

import com.warofcosmo.cosmo.Board;
import java.awt.event.ActionEvent;
import projectiles.ProjectileSpawner;

public class Enemy1 extends Enemy implements Runnable{
        
	public Enemy1(Board brd,int startx, int starty) {
		super(brd,1,"er",".png",startx,starty);
                _speed=-1;
                _startX=startx;
                _startY=starty;
				
		ProjectileSpawner _projSpawner = new ProjectileSpawner(this,1000);
                
                for(int x=0;x<200;x++){
                    
                    if(x <= 101){
                        marrayY[x]=-1;
                    }else{
                        marrayY[x]=1;    
                    }
                    
                    marrayX[x]=-1;

                    
                    
                }
// shouldn't need this new Thread here, could just call super.move() to add any functionality
// to your original move method, or just leave it overriden since the class you are extending
// will automatically generate it's own Thread and start
				
                //Thread enemythread=new Thread(this);
                //enemythread.start();
                
            //    _brd.addEnemy(new Enemy(_brd,3,"e3l",".png",px,300));

	}

	@Override
	public void move() {
       //super.move();
          //_x = _x + -1;
          //_y = _y + dy;

          if(leave==0){
              if(count< 100){
                _x = _x + marrayX[step];
              }
              else{
                  _x = _x + 0;
              }
          }else{
          _x = _x + +_speed;
          }
          
          _y = _y + marrayY[step];
          
          step++;
          
          if(step==200){
              step=0;
              
              
          }
          count++;
          if(count>400){leave=1;}
          else{_dx=0;}

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
