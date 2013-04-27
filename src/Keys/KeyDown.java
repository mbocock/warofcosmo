package Keys;

import Entities.AbstractKeyEvent;
import com.warofcosmo.cosmo.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public class KeyDown extends AbstractKeyEvent{
	
	public KeyDown(Player p){
		super(p);
	}
	
	@Override
	 public void pressAction(int key) {
		if(key == KeyEvent.VK_DOWN){
			p.setDy(p.getSpeed());
			p.setGFX(p.getImage(2));
		 }
	 }
	 
	@Override
	  public void releaseAction(int key ) {
		if(key == KeyEvent.VK_DOWN){
			p.setDy(0);
			p.setGFX(p._shipimg.get(0).getImage());
		}
	  }
}
