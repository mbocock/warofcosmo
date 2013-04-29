package Entities;

import com.warofcosmo.cosmo.Board;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class AbstractEntity implements ActionListener,IEntity{
	
	protected Image _gfx;
	protected Board _board;
	protected int _x;
	protected int _y;
	protected int _width;
	protected int _height;
	protected int _speed;
	protected int _direction;
	protected int _dy;
	protected int _dx;
	public ArrayList<ImageIcon> _shipimg;
	protected int curhealth;
	private int maxhealth=20;
        protected ArrayList<ImageIcon> _staticimg;
	
	public AbstractEntity(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty){
		
		_shipimg = new ArrayList<ImageIcon>();
                _x=startx;
                _y=starty;
		fillCycleImages(imgname,imgextension,imgcount);		
		_board = brd;
                curhealth=maxhealth;
	}
	
	protected void fillCycleImages(String imgname,String imgextension,int imgcount){
           
		for(int i = 0; i < imgcount; i++){
			_shipimg.add(new ImageIcon(getClass().getResource("/"+ imgname + i + imgextension)));
                }
                //starting neutral image usualy 0 in array
                _gfx = _shipimg.get(0).getImage();
                _width=_gfx.getWidth(_board);
                _height=_gfx.getHeight(_board);
	}
        
        public Rectangle getBounds() {
            return new Rectangle(_x, _y, _width, _height);
	}
   
	
	@Override
	public int getX() {
		return _x;
	}

	@Override
	public int getY() {
		return _y;
	}


	@Override
	public void setX(int x) {
		_x = x;
	}

	@Override
	public void setY(int y) {
		_y = y;
	}

	
	@Override
	public int getHealth() {
		return curhealth;
	}

	@Override
	public int getMaxHealth() {
		return maxhealth;
	}

	
	@Override
	public Image getImage() {
		return _gfx;
	}
        
        //@Override
        public Image getImage(int img) {
            return _shipimg.get(img).getImage();
        }
	
	@Override
	public int getDx() {
		return _dx;
	}
	
        @Override
	public int getDy() {
		return _dy;
	}
		
	public int getSpeed() {
		return _speed;
	}
	
        @Override
	public void setDx(int dx) {
		_dx = dx;
	}
	
        @Override
	public void setDy(int dy) {
		_dy = dy;
	}
	
        @Override
	public void setGFX(Image i) {
		_gfx = i;
	}
        /*
        @Override
	public Image getGFX() {
		return _gfx;
	}
	*/
        @Override
	public Board getBoard() {
		return _board;
	}
        
         @Override
        public int getDirection() {
            return _direction;
        }
        
        @Override
        public void setDirection(int dir) {
            _direction = dir;
        }
        
        public void setHealth(int hit){
            curhealth=curhealth-hit;
        }
}
