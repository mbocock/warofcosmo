package Keys;

import Entities.AbstractKeyEvent;
import com.warofcosmo.cosmo.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public class KeyUp extends AbstractKeyEvent{
	
	public KeyUp(Player p){
		super(p);
	}
	
	@Override
	 public void pressAction(int key) {
		if(key == KeyEvent.VK_UP){
			p.setDy(-p.getSpeed());
			p.setGFX(p.getImage(1));
		 }
	 }
	 
	@Override
	  public void releaseAction(int key ) {
		if(key == KeyEvent.VK_UP){
			p.setDy(0);
			p.setGFX(p._shipimg.get(0).getImage());
		}
	  }
}
