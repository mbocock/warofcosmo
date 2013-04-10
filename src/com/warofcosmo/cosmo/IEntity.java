package com.warofcosmo.cosmo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public interface IEntity {
	public void move();
	
	public int getX();
	public int getY();
	public int getHealth();
	public int getMaxHealth();
        public int getDirection();
	public int getDx();
	public int getDy();
	public Image getImage();
	public Image getGFX();
	public Board getBoard();
	
	public void setX(int x);
	public void setY(int y);
	public void setDx(int dx);
	public void setDy(int dy);
	public void setGFX(Image i);
	public void setDirection(int dir);
	
}
