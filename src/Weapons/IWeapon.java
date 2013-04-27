package Weapons;

import java.awt.Image;
import java.awt.Rectangle;

/**
*
* @author mayalabs
*/
public interface IWeapon {
    public void fireProjectile();
    public Rectangle getBounds();
    public int getX();
    public int getY();
    public Image getImage();
    public int getDistance();
}