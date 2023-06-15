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
public class Knight extends Fixed {

    private PImage[] idle;
    private int width, height, xk, yk;
    private int t = 0;

    public Knight(PImage[] idle, int width, int height, int x, int y, int xk, int yk) {
        super(x, y, idle);
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xk = xk;
        this.yk = yk;
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

    public int getXk() {
        return xk;
    }

    public void setXk(int xk) {
        this.xk = xk;
    }

    public int getYk() {
        return yk;
    }

    public void setYk(int yk) {
        this.yk = yk;
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
        app.image(idle[t], xk, yk, width, height);
    }

}
