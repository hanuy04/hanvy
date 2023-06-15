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
public class RunningManJalan {

    private PImage[] idle;
    private int width, height, xrj, yrj, hpr;
    private int t = 0;

    public RunningManJalan(PImage[] idle, int width, int height, int x, int y, int xrj, int yrj, int hpr) {
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xrj = xrj;
        this.yrj = yrj;
        this.hpr = hpr;
    }

    public int getHpr() {
        return hpr;
    }

    public void setHpr(int hpr) {
        this.hpr = hpr;
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

    public int getXrj() {
        return xrj;
    }

    public void setXrj(int xrj) {
        this.xrj = xrj;
    }

    public int getYrj() {
        return yrj;
    }

    public void setYrj(int yrj) {
        this.yrj = yrj;
    }

    public void drawIdle(PApplet app, int f) {
        if (f == -1) {
            t = 0;
            f = 0;
        }
        if (f % 10 == 0) {
            t++;
        }
        if (t >= 7) {
            t = 0;
        }
        app.image(idle[t], xrj, yrj, width, height);
    }

    public void bergerak(boolean right, boolean left, boolean up, boolean down) {
        if (right) {
            xrj += 2;
        } else if (left) {
            xrj -= 2;
        } else if (up) {
            yrj -= 2;
        } else if (down) {
            yrj += 2;
        }
    }
}
