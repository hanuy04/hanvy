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
public class RedWitch {

    private PImage[] idle;
    private int width, height, xrw, yrw;
    private int t = 0;

    public RedWitch(PImage[] idle, int width, int height, int xrw, int yrw) {
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xrw = xrw;
        this.yrw = yrw;
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

    public int getXrw() {
        return xrw;
    }

    public void setXrw(int xrw) {
        this.xrw = xrw;
    }

    public int getYrw() {
        return yrw;
    }

    public void setYrw(int yrw) {
        this.yrw = yrw;
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
        app.image(idle[t], xrw, yrw, width, height);
    }

    public void bergerak(boolean left) {
        if (left) {
            xrw -= 2;
        }
    }
}
