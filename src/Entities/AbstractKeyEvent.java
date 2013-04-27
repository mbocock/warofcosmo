package Entities;

import com.warofcosmo.cosmo.Board;
import com.warofcosmo.cosmo.Player;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public abstract class AbstractKeyEvent implements IKeyEvent{
	protected Player p;
	protected Board b;
	
	public AbstractKeyEvent(Player p){
		this.p=p;
		this.b=p.getBoard();
	}
}
