package projectiles;

import Entities.AbstractEntity;
import java.awt.Color;

/**
 * @todo need to remove these projectiles when they fly off screen
 * @todo need to add collision detection vs our Player
 * @author blitzkriegdevelopment <blitzkriegdevelopment.com>
 */
public class Projectile implements Runnable{
	
	private int _x;
	private int _y;
	private int _dx;
	private int _dy;
	private int _width;
	private int _height;
	private Color _color;
	private AbstractEntity _target;
	private int _projectileSpeed = 2;
	
	public Projectile(int x, int y, AbstractEntity t) {
		//System.out.println("Creating new projectile...");
		_target = t;
		setX(x);
		setY(y);
		
		int targX = _target.getX();
		int targY = _target.getY();
		
		//dist between both pts.
		double dist = Math.sqrt((targX - _x)*(targX - _x) + (targY - _y)*(targY - _y));
		
		//actual change in x and y speed that is needed...
		double dx = (targX - _x) /dist * _projectileSpeed;
		double dy = (targY - _y) /dist * _projectileSpeed;
		
		//since we're drawing pixels and using integers, will round to get 'quazi accurate' 
		//projectile fire towards our Player...
		dx = (int)Math.round(dx);
		dy = (int)Math.round(dy);
		
		setDx((int)dx);
		setDy((int)dy);
		
		setWidth(5);
		setHeight(5);
		setColor(Color.GREEN);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	private void move() {
		setX(getX() + getDx());
		setY(getY() + getDy());
	}
	
	@Override
	public void run() {
		
		try{
			while(true){
				move();
				Thread.sleep(5);
			}
		}catch(Exception ignore){}
		
	}

	public int getX() {return _x;}
	public int getY() {return _y;}
	public int getDx() {return _dx;}
	public int getDy() {return _dy;}
	public int getWidth() {return _width;}
	public int getHeight() {return _height;}
	public void setX(int x) {this._x = x;}
	public void setY(int y) {this._y = y;}
	public void setDx(int dx) {this._dx = dx;}
	public void setDy(int dy) {this._dy = dy;}
	public void setWidth(int w) {_width = w;}
	public void setHeight(int h) {_height = h;}
	public Color getColor() {return _color;}
	public void setColor(Color color) {this._color = color;}
	
}
