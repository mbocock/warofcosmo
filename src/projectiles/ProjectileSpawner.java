package projectiles;

import Entities.AbstractEntity;
import com.warofcosmo.cosmo.Board;
import java.awt.Rectangle;

/**
 *
 * @author blitzkriegdevelopment <blitzkriegdevelopment.com>
 */
public class ProjectileSpawner implements Runnable{
	
	private AbstractEntity _entity;								// I add _ to Class variables to differ them from local vars
	private Board _board;
	private int _fireSpeed = 1000;
	private int _x;
	private int _y;
        private int _width;
	private int _height;
	private int _dx;
	private int _dy;
        private volatile Thread _running;
	
	public ProjectileSpawner(AbstractEntity ae,int speed) {
		_entity = ae;
		_board = _entity.getBoard();
                _fireSpeed=speed;
		Thread _running = new Thread(this);
		_running.start();
	}
	
	@Override
	public void run() {

		try{
			while(true){
				fire();
				Thread.sleep(_fireSpeed);
			}
		}catch(Exception ignore){ }
	}
	
	private void fire() {
		Projectile p = new Projectile(_entity.getX(),_entity.getY(),_board.getPlayer());
		_board.addProjectile(p);
	}
        public void stop(){_running=null;}
        
	
}
