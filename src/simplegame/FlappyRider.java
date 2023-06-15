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
public class FlappyRider {

    private PImage[] idle;
    private int width, height, xfr, yfr;
    private int t = 0;

    public FlappyRider(PImage[] idle, int width, int height, int xfr, int yfr) {
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xfr = xfr;
        this.yfr = yfr;
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

    public int getXfr() {
        return xfr;
    }

    public void setXfr(int xfr) {
        this.xfr = xfr;
    }

    public int getYfr() {
        return yfr;
    }

    public void setYfr(int yfr) {
        this.yfr = yfr;
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
        app.image(idle[t], xfr, yfr, width, height);
    }

    public void bergerak(boolean left) {
        if (left) {
            xfr -= 1;
        }
    }
}
