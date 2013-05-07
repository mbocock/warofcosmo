package Entities;

import com.warofcosmo.cosmo.Board;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Enemy extends AbstractEntity implements Runnable{
	int[] p;
        int dir=-1;
        int _startX;
        int _startY;
        int dy=1;
        int[] marrayX;
        int[] marrayY;
        int step=0;
        int count=0;
        
	public Enemy(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty) {
		super(brd,imgcount,imgname,imgextension,startx,starty);
                _speed=-10;
                _startX=startx;
                _startY=starty;
                marrayX=new int[100];
                marrayY=new int[100];
                
                marrayX[0]=_speed;
                marrayX[1]=_speed;
                marrayX[2]=_speed;
                marrayX[3]=_speed;
                marrayX[4]=_speed;
                marrayX[5]=_speed;
                marrayX[6]=_speed;
                marrayX[7]=_speed;
                marrayX[8]=_speed;
                marrayX[9]=_speed;
                marrayX[10]=_speed;
                marrayX[11]=_speed;
                marrayX[12]=_speed;
                marrayX[13]=_speed;
                marrayX[14]=_speed;
                marrayX[15]=_speed;
                marrayX[16]=_speed;
                marrayX[17]=_speed;
                marrayX[18]=_speed;
                marrayX[19]=_speed;
                marrayX[20]=_speed;
                marrayX[21]=_speed;
                marrayX[22]=_speed;
                marrayX[23]=_speed;
                marrayX[24]=_speed;
                marrayX[25]=_speed;
                marrayX[26]=_speed;
                marrayX[27]=_speed;
                marrayX[28]=_speed;
                marrayX[29]=_speed;
                marrayX[30]=_speed;
                marrayX[41]=_speed;
                marrayX[42]=_speed;
                marrayX[43]=_speed;
                marrayX[44]=_speed;
                marrayX[45]=_speed;
                marrayX[46]=_speed;
                marrayX[47]=_speed;
                marrayX[48]=_speed;
                marrayX[49]=_speed;
                marrayX[50]=_speed;
                marrayX[51]=_speed;
                marrayX[52]=_speed;
                marrayX[53]=_speed;
                marrayX[54]=_speed;
                marrayX[55]=_speed;
                marrayX[56]=_speed;
                marrayX[57]=_speed;
                marrayX[58]=_speed;
                marrayX[59]=_speed;
                marrayX[50]=_speed;
                marrayX[51]=_speed;
                marrayX[52]=_speed;
                marrayX[53]=_speed;
                marrayX[54]=_speed;
                marrayX[55]=_speed;
                marrayX[56]=_speed;
                marrayX[57]=_speed;
                marrayX[58]=_speed;
                marrayX[59]=_speed;
                marrayX[60]=_speed;
                marrayX[61]=_speed;
                marrayX[62]=_speed;
                marrayX[63]=_speed;
                marrayX[64]=_speed;
                marrayX[65]=_speed;
                marrayX[66]=_speed;
                marrayX[67]=_speed;
                marrayX[68]=_speed;
                marrayX[69]=_speed;
                marrayX[70]=_speed;
                marrayX[71]=_speed;
                marrayX[72]=_speed;
                marrayX[73]=_speed;
                marrayX[74]=_speed;
                marrayX[75]=_speed;
                marrayX[76]=_speed;
                marrayX[77]=_speed;
                marrayX[78]=_speed;
                marrayX[79]=_speed;
                marrayX[80]=_speed;
                marrayX[81]=_speed;
                marrayX[82]=_speed;
                marrayX[83]=_speed;
                marrayX[84]=_speed;
                marrayX[85]=_speed;
                marrayX[86]=_speed;
                marrayX[87]=_speed;
                marrayX[88]=_speed;
                marrayX[89]=_speed;
                marrayX[90]=_speed;
                
                marrayY[0]=0;
                marrayY[1]=0;
                marrayY[2]=0;
                marrayY[3]=0;
                marrayY[4]=0;
                marrayY[5]=0;
                marrayY[6]=0;
                marrayY[7]=0;
                marrayY[8]=0;
                marrayY[9]=0;
                marrayY[10]=0;
                marrayY[11]=0;
                marrayY[12]=0;
                marrayY[13]=0;
                marrayY[14]=0;
                marrayY[15]=0;
                marrayY[16]=0;
                marrayY[17]=0;
                marrayY[18]=0;
                marrayY[19]=0;
                marrayY[20]=0;
                marrayY[21]=0;
                marrayY[22]=0;
                marrayY[23]=0;
                marrayY[24]=0;
                marrayY[25]=0;
                marrayY[26]=0;
                marrayY[27]=0;
                marrayY[28]=0;
                marrayY[29]=0;
                marrayY[30]=0;
                marrayY[41]=0;
                marrayY[42]=0;
                marrayY[43]=0;
                marrayY[44]=0;
                marrayY[45]=0;
                marrayY[46]=-1;
                marrayY[47]=-1;
                marrayY[48]=-1;
                marrayY[49]=-1;
                marrayY[50]=-1;
                marrayY[51]=-1;
                marrayY[52]=-1;
                marrayY[53]=-1;
                marrayY[54]=-1;
                marrayY[55]=-1;
                marrayY[56]=-1;
                marrayY[57]=-1;
                marrayY[58]=-1;
                marrayY[59]=-1;
                marrayY[50]=-1;
                marrayY[51]=-1;
                marrayY[52]=-1;
                marrayY[53]=-1;
                marrayY[54]=-1;
                marrayY[55]=-1;
                marrayY[56]=-1;
                marrayY[57]=-1;
                marrayY[58]=-1;
                marrayY[59]=-1;
                marrayY[60]=-1;
                marrayY[61]=-1;
                marrayY[62]=-1;
                marrayY[63]=-1;
                marrayY[64]=-1;
                marrayY[65]=-1;
                marrayY[66]=-1;
                marrayY[67]=-1;
                marrayY[68]=-1;
                marrayY[69]=-1;
                marrayY[70]=-1;
                marrayY[71]=-1;
                marrayY[72]=-1;
                marrayY[73]=-1;
                marrayY[74]=-1;
                marrayY[75]=-1;
                marrayY[76]=-1;
                marrayY[77]=-1;
                marrayY[78]=-1;
                marrayY[79]=-1;
                marrayY[80]=-1;
                marrayY[81]=-1;
                marrayY[82]=-1;
                marrayY[83]=-1;
                marrayY[84]=-1;
                marrayY[85]=-1;
                marrayY[86]=-1;
                marrayY[87]=-1;
                marrayY[88]=-1;
                marrayY[89]=-1;
                marrayY[90]=-1;
                
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
            
          
          step++;
          
          if(step==90)step=0;*/
            
          System.out.println(dy);
            if(_startY+100 > _y && dy!=1){
              dy=-dir;
              
          }
            if(_startY-100 < _y && dy!=-1){
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
        
        @Override
	public void run() {
            
            while(true){
                try{
                    move();
                    Thread.sleep(10);
                }
                catch(Exception ignore){}
            }
	}

}
