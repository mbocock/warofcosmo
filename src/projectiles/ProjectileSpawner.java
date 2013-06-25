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
	
	public ProjectileSpawner(AbstractEntity ae,int speed) {
		_entity = ae;
		_board = _entity.getBoard();
		_fireSpeed=speed;
		Thread _running = new Thread(this);
		ae.setProjectileThread(_running);
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
		Projectile p = new Projectile(_entity.getX(),_entity.getY(),_board.getPlayer());
		_board.addProjectile(p);
	}
        public void stop(){_running=null;}
        
	
}
