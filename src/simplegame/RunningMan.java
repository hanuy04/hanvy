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
public class RunningMan extends Fixed {

    private PImage[] idle;
    private int width, height, xr, yr;
    private int t = 0;

    public RunningMan(PImage[] idle, int width, int height, int x, int y, int xr, int yr) {
        super(x, y, idle);
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xr = xr;
        this.yr = yr;
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

    public int getXr() {
        return xr;
    }

    public void setXr(int xr) {
        this.xr = xr;
    }

    public int getYr() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr = yr;
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
        app.image(idle[t], xr, yr, width, height);
    }

}
