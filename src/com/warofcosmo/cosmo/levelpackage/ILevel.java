/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warofcosmo.cosmo.levelpackage;

import java.awt.Image;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public interface ILevel {
    public void LoadBGM(String ibgm);
    public abstract void Move();
    public int getX();
    public int getY();
    public AudioStream getBGM();
    public Image getBG();
    public int getLength();
}
