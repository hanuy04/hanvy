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
public class Vampire extends Fixed {

    private PImage[] idle;
    private int width, height, xv, yv, hpv;
    private int t = 0;

    public Vampire(PImage[] idle, int width, int height, int x, int y, int xv, int yv, int hpv) {
        super(x, y, idle);
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xv = xv;
        this.yv = yv;
        this.hpv = 120;
    }

    public int getHpv() {
        return hpv;
    }

    public void setHpv(int hpv) {
        this.hpv = hpv;
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

    public int getXv() {
        return xv;
    }

    public void setXv(int xv) {
        this.xv = xv;
    }

    public int getYv() {
        return yv;
    }

    public void setYv(int yv) {
        this.yv = yv;
    }

    public void bergerak(boolean right, boolean left, boolean up, boolean down) {
        if (right) {
            xv += 3;
        } else if (left) {
            xv -= 3;
        } else if (up) {
            yv -= 3;
        } else if (down) {
            yv += 3;
        }
    }

    public void drawIdle(PApplet app, int f) {
        if (f == -1) {
            t = 0;
            f = 0;
        }
        if (f % 10 == 0) {
            t++;
        }
        if (t >= 1) {
            t = 0;
        }
        app.image(idle[t], xv, yv, width, height);
    }

}
