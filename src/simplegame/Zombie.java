/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplegame;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author Hanvy
 */
public class Zombie {

    private PImage[] idle;
    private int width, height, xz, yz;
    private int t = 0;

    public Zombie(PImage[] idle, int width, int height, int xz, int yz) {
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xz = xz;
        this.yz = yz;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getXz() {
        return xz;
    }

    public void setXz(int xz) {
        this.xz = xz;
    }

    public int getYz() {
        return yz;
    }

    public void setYz(int yz) {
        this.yz = yz;
    }

    public void drawIdle(PApplet app, int f) {
        if (f == -1) {
            t = 0;
            f = 0;
        }
        if (f % 10 == 0) {
            t++;
        }
        if (t >= 4) {
            t = 0;
        }
        app.image(idle[t], xz, yz, width, height);
    }

    public void bergerak(boolean left) {
        if (left) {
            xz -= 1;
        }
    }
}
