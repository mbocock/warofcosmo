package projectiles;

import Entities.AbstractEntity;
import com.warofcosmo.cosmo.Board;
import java.awt.Rectangle;

/**
 *
 * @author blitzkriegdevelopment <blitzkriegdevelopment.com>
 */
public class ProjectileSpawner implements Runnable{
	
	private AbstractEntity _entity;								
	private Board _board;
	private int _fireSpeed = 1000;
	private int _x;
	private int _y;
	private int _width;
	private int _height;
	private int _dx;
	private int _dy;
	private Thread _running;
        private boolean _isBoss=false;
	
	public ProjectileSpawner(AbstractEntity ae,int speed, int width, int height) {
		_entity = ae;
		_board = _entity.getBoard();
		_fireSpeed=speed;
                _width=width;
                _height=height;
		Thread _running = new Thread(this);
		ae.setProjectileThread(_running);
		_running.start();
	}
        
        public ProjectileSpawner(AbstractEntity ae,int speed,int width, int height, int x, int y) {
            
		_entity = ae;
		_board = _entity.getBoard();
		_fireSpeed=speed;
                _isBoss=true;
                _x=x;
                _y=y;
		Thread _running = new Thread(this);
                Thread _running2 = new Thread(this);
		ae.setProjectileThread(_running);
                ae.setProjectileThread2(_running2);
		_running.start();
	}
        
	
	@Override
	public void run() {
			while(true){
			try{
				fire();
				Thread.sleep(_fireSpeed);
			} catch(InterruptedException ex){
				Thread.currentThread().interrupt(); // very important
				break;
			}
		}
	}
	
	
	private void fire() {

            int posX;
            int posY;
        
            if(_isBoss){
                posX=_x;
                posY=_y;
            }else{
                posX=_entity.getX();
                posY=_entity.getY();
            }

		Projectile p = new Projectile(_entity.getX(),_entity.getY(),_board.getPlayer(),_width,_height);
		_board.addProjectile(p);
                
	}
        public void stop(){_running=null;}
        
	
}
