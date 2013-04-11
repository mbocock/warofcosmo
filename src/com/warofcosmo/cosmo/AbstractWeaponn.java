package com.warofcosmo.cosmo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
*
* @author mayalabs
*/
public abstract class AbstractWeaponn implements IWeapon {
    
        private int startx;
private int starty;
private int x;
private int y;
private int offsetx = 25;
private int offsety = 10;
private int distance= 1050;
private int direction;
private Image basebullit;
private int speed=2;
private int width = 9;
private int height = 8;

AbstractWeaponn(int nx, int ny, int dir){
ImageIcon i = new ImageIcon(getClass().getResource("/shotbasic.png"));
basebullit = i.getImage();
direction=dir;
startx=nx;
starty=ny;

if(direction==1){
x = nx + (offsetx+10);
} else if(direction==0){
x = nx - (offsetx-15);
}
y = ny + offsety;
fireProjectile();
}

        @Override
public void fireProjectile(){

}
        
        @Override
public Rectangle getBounds() {
return new Rectangle(x, y, width, height);
}

        @Override
public int getX() {
if(direction==1){
x+=speed;
} else if(direction==0){
x-=speed;
}
return x;
}

        @Override
public int getY() {
return y;
}

        @Override
public Image getImage() {
return basebullit;
}
        
        @Override
        public int getDistance(){
            return distance;
        }
        
        //Abstract Method
        //public abstract void velocityBullet();
    
}