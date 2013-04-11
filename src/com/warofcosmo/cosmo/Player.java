package com.warofcosmo.cosmo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class Player extends AbstractEntity implements IPlayer{
	
	private ArrayList<IKeyEvent> keyevents = new ArrayList();
	
	public Player(Board brd) {
		super(brd);
		
		_x=100;
		_y=400;
		
		AbstractKeyEvent kright = new KeyRight(this);
		AbstractKeyEvent kleft = new KeyLeft(this);
		AbstractKeyEvent kup = new KeyUp(this);
		AbstractKeyEvent kdown = new KeyDown(this);
                AbstractKeyEvent kspace = new KeySpace(this);
					
				  
		addKeyEvent(kright);
		addKeyEvent(kleft);
		addKeyEvent(kup);
		addKeyEvent(kdown);
		addKeyEvent(kspace);

		
	}

	@Override
	public void move() {
		_x = _x+_dx;
		_y = _y+_dy;
		
	}	
	
	public void addKeyEvent(IKeyEvent ike){
		keyevents.add(ike);
	}
	public void removeKeyEvent(IKeyEvent ike) {
		keyevents.remove(ike);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
            System.out.println("Action");
            if(_dy<0)
            _gfx=_shipimg.get(1).getImage();
            if(_dy>0)
            _gfx=_shipimg.get(2).getImage();
            
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i=0; i < keyevents.size(); i++){
			IKeyEvent ike = keyevents.get(i);
			ike.pressAction(key);
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i=0; i < keyevents.size(); i++){
			IKeyEvent ike = keyevents.get(i);
			ike.releaseAction(key);
		}
	}
	


}
