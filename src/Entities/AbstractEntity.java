package Entities;

import com.warofcosmo.cosmo.Board;
import com.warofcosmo.cosmo.Player;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.net.URL;
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
	protected int curhealth;
	protected ArrayList<ImageIcon> _staticimg;
	protected Thread _projectileThread;
        protected Thread _projectileThread2;
	public ArrayList<ImageIcon> _shipimg;
        public ArrayList<ImageIcon> _deathimg;
	private int maxhealth=20;
        private int dCount=0;
        private int TCount=0;
        private final AudioClip _deathFX;
        protected int _points=50;
        protected int _pwidth=5;
        protected int _pheight=5;
	
	public AbstractEntity(Board brd,int imgcount, String imgname, String imgextension,int startx, int starty,String DeathWav, int inmaxHealth){
		
		_shipimg = new ArrayList<ImageIcon>();
                _deathimg = new ArrayList<ImageIcon>();
                _x=startx;
                _y=starty;
                maxhealth=inmaxHealth;
		fillCycleImages(imgname,imgextension,imgcount);	
                fillDeathCycleImages("death",".png",4);
		_board = brd;
                curhealth=maxhealth;
                URL urlClick = Player.class.getResource("/"+DeathWav+".wav");
                _deathFX = Applet.newAudioClip(urlClick);
                
                
                
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
       
        protected void fillDeathCycleImages(String imgname,String imgextension,int imgcount){
           
		for(int i = 0; i < imgcount; i++){
			_deathimg.add(new ImageIcon(getClass().getResource("/"+ imgname + i + imgextension)));
                }
                //starting neutral image usualy 0 in array
                //_gfx = _shipimg.get(0).getImage();
                //_width=_gfx.getWidth(_board);
                //_height=_gfx.getHeight(_board);
	}
        
	public Rectangle getBounds() {return new Rectangle(_x, _y, _width, _height);}
	
        public boolean death(){
          if(TCount>7){
            if(dCount<4){  
                if(dCount==1){getDeathFX().play();}
                setDeath(dCount);
                dCount++;
                TCount=0;
                return false;
            }else{
                TCount=0;
                return true;
            }
            
          }
          else{
              TCount++;
              return false;
          }
        }
        
	@Override
	public int getX() {return _x;}

	@Override
	public int getY() {return _y;}

	@Override
	public void setX(int x) {_x = x;}

	@Override
	public void setY(int y) {_y = y;}

	@Override
	public int getHealth() {return curhealth;}

	@Override
	public int getMaxHealth() {return maxhealth;}
        public void setMaxHealth(int health) {maxhealth=health;}

	@Override
	public Image getImage() {return _gfx;}
        
	public Image getImage(int img) {return _shipimg.get(img).getImage();}
	
	@Override
	public int getDx() {return _dx;}
	
	@Override
	public int getDy() {return _dy;}
		
	public int getSpeed() {return _speed;}
	
	@Override
	public void setDx(int dx) {_dx = dx;}
	
	@Override
	public void setDy(int dy) {_dy = dy;}
	
	@Override
	public void setGFX(Image i) {_gfx = i;}
        
	@Override
	public Board getBoard() {return _board;}
        
	@Override
	public int getDirection() {return _direction;}
        
	@Override
	public void setDirection(int dir) {_direction = dir;}
        @Override
	public void setHealth(int hit){curhealth=curhealth-hit;}
	@Override	
	public void setProjectileThread(Thread pthread){_projectileThread = pthread;}
	@Override
	public Thread getProjectileThread(){return _projectileThread; }
        	
	public void setProjectileThread2(Thread pthread){_projectileThread2 = pthread;}
	
	public Thread getProjectileThread2(){return _projectileThread2; }
        @Override
	public void setDeath(int n) {
            _gfx=_deathimg.get(n).getImage();
        }
        public AudioClip getDeathFX() {return _deathFX;}
        @Override
        public int getpoints(){
            return _points;
        }
}
