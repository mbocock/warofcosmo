package com.warofcosmo.cosmo;

import Weapons.PlayerWeapon;
import java.awt.event.KeyEvent;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class KeySpace extends AbstractKeyEvent{

        private final AudioClip click;
        
        public KeySpace(Player p){
            super(p);
                URL urlClick = Player.class.getResource("/cosmo1.wav");
                click = Applet.newAudioClip(urlClick);
        }

@Override
public void pressAction(int key) {
                if(key == 32) //70 for letter F
                {
                   click.play();
                   PlayerWeapon weap = new PlayerWeapon(p.getX(),p.getY(), 1);
                   b.addBullit(weap);
        
                   //System.out.println("X: " + p.getX() + " Y: " + p.getY() + " Direction: " + p.getDirection());
                }

/*if(key == KeyEvent.VK_RIGHT){
p.setDx(p._speed);
}*/
}

        @Override
        public void releaseAction(int key ) {
            if(key == KeyEvent.VK_RIGHT){
                p.setDx(0);
            }
        }
}