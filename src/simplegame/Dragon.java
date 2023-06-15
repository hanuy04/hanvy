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
public class Dragon {

    private PImage[] idle;
    private int width, height, xn, yn;
    private int t = 0;

    public Dragon(PImage[] idle, int width, int height, int xn, int yn) {
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xn = xn;
        this.yn = yn;
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

    public int getXn() {
        return xn;
    }

    public void setXn(int xn) {
        this.xn = xn;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public void drawIdle(PApplet app, int f) {
        if (f == -1) {
            t = 0;
            f = 0;
        }
        if (f % 10 == 0) {
            t++;
        }
        if (t >= 3) {
            t = 0;
        }
        app.image(idle[t], xn, yn, width, height);
    }
}
