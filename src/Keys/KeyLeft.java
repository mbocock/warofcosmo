package Keys;

import Entities.AbstractKeyEvent;
import com.warofcosmo.cosmo.Player;
import java.awt.event.KeyEvent;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public class KeyLeft extends AbstractKeyEvent{
	
	public KeyLeft(Player p){
		super(p);
	}
	
	@Override
	 public void pressAction(int key) {
		if(key == KeyEvent.VK_LEFT){
			p.setDx(-p.getSpeed());
		 }
	 }
	 
	@Override
	  public void releaseAction(int key ) {
		if(key == KeyEvent.VK_LEFT){
			p.setDx(0);
		}
	  }
}
