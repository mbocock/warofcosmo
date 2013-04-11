package com.warofcosmo.cosmo;

import java.awt.event.KeyEvent;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public class KeyRight extends AbstractKeyEvent{
	
	public KeyRight(Player p){
		super(p);
	}
	
	@Override
	 public void pressAction(int key) {
		if(key == KeyEvent.VK_RIGHT){
          	p.setDx(p.getSpeed());}
	 }
	 
	@Override
	  public void releaseAction(int key ) {
		if(key == KeyEvent.VK_RIGHT){
			p.setDx(0);
		}
	  }
}
