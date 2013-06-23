package projectiles;

import Entities.AbstractEntity;
import com.warofcosmo.cosmo.Board;

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
	private int _dx;
	private int _dy;
	
	public ProjectileSpawner(AbstractEntity ae) {
		_entity = ae;
		_board = _entity.getBoard();
		Thread t = new Thread(this);
		t.start();
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
	
}
