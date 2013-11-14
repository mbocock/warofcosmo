package Entities;

import com.warofcosmo.cosmo.Board;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import projectiles.ProjectileSpawner;

public abstract class Enemy extends AbstractEntity implements Runnable{
	int[] p;
        int dir=-1;
        int _startX;
        int _startY;
        int dy=1;
        int[] marrayX;
        int[] marrayY;
        int step=0;
        int count=0;
        int leave=0;
        

	public Enemy(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty,String deathwav,int health) {
		super(brd,imgcount,imgname,imgextension,startx,starty,deathwav,health);
                _speed=-1;
                _startX=startx;
                _startY=starty;
                marrayX=new int[200];
                marrayY=new int[200];

                //ProjectileSpawner _projSpawner = new ProjectileSpawner(this,500,_pwidth,_pheight);
                Thread enemythread=new Thread(this);
                enemythread.start();
                
                

	}

	@Override
	public void move() {
       
          _x = _x + -1;
          _y = _y + dy;

            /*
          _x = _x + marrayX[step];
          _y = _y + marrayY[step];
            
          
          
          
          if(step==90)step=0;*/
          
         
	
        }	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
            //if(_dy<0)
            //_gfx=_shipimg.get(1).getImage();
            //if(_dy>0)
            //_gfx=_shipimg.get(2).getImage();
            
	}
        
        @Override
	public void run() {
            
            while(true){
                try{
                    move();
                    Thread.sleep(30);
                }
                catch(Exception ignore){}
            }
	}

}
