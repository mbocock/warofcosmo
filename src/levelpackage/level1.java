/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package levelpackage;

import com.warofcosmo.cosmo.Board;
import Entities.*;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public class level1 extends AbstractLevel{
    private int _speed=10;
    private String _bgm;
    private AudioStream as;
    private int _isBoss=0;
    
    public level1(Board brd){
        super(brd,"bg2.png","project4.wav",0,0);   
    }
   
    @Override
    public void Move(){
        _dx=_dx-_speed;
        _dy=_dy-0;
     
        int px=_brd.getSize().width;
      
                if(_dx-px<=-_length && _isBoss==0){
                    _speed=0;
                    _brd.stopBGM(as);
                    _brd.addEnemy(new Boss(_brd,px-450,300));
                    _isBoss=1;
                    //_brd.playBGM(bs);
                    // _brd.LoadNext();
		}
               
//                if(_dx == -300){
//                     _brd.addEnemy(new Enemy1(_brd,px,300));
//                     _brd.addEnemy(new Enemy1(_brd,px,500));
//                     _brd.addEnemy(new Enemy1(_brd,px,700));
//                     
//                     _brd.addEnemy(new Enemy2(_brd,px,400));
//                     _brd.addEnemy(new Enemy2(_brd,px,600));
//                     
//                }
//               
//                if(_dx == -1500){
//                     _brd.addEnemy(new Enemy1(_brd,px,200));
//                     _brd.addEnemy(new Enemy1(_brd,px,700));
//                     
//                     _brd.addEnemy(new Enemy2(_brd,px,300));
//                     _brd.addEnemy(new Enemy2(_brd,px,400));
//                     _brd.addEnemy(new Enemy2(_brd,px,500));
//                     _brd.addEnemy(new Enemy2(_brd,px,600));
//                }
//                if(_dx == -2700){
//                     _brd.addEnemy(new Enemy1(_brd,px,300));
//                     _brd.addEnemy(new Enemy1(_brd,px,500));
//                     _brd.addEnemy(new Enemy1(_brd,px,700));
//                }
//                
                if(_dx == -13700){
                    _speed=1;
                }
                
    }
}
