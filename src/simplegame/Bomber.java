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
public class Bomber extends Fixed {

    private PImage[] idle;
    private int width, height, xb, yb;
    private int t = 0;

    public Bomber(PImage[] idle, int width, int height, int x, int y, int xb, int yb) {
        super(x, y, idle);
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xb = xb;
        this.yb = yb;
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

    public int getXb() {
        return xb;
    }

    public void setXb(int xb) {
        this.xb = xb;
    }

    public int getYb() {
        return yb;
    }

    public void setYb(int yb) {
        this.yb = yb;
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
        app.image(idle[t], xb, yb, width, height);
    }

}
