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
public class KnightJalan {

    private PImage[] idle;
    private int width, height, xkj, ykj, hpk;
    private int t = 0;

    public KnightJalan(PImage[] idle, int width, int height, int x, int y, int xkj, int ykj, int hpk) {
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xkj = xkj;
        this.ykj = ykj;
        this.hpk = hpk;
    }

    public int getHpk() {
        return hpk;
    }

    public void setHpk(int hpk) {
        this.hpk = hpk;
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

    public int getXkj() {
        return xkj;
    }

    public void setXkj(int xkj) {
        this.xkj = xkj;
    }

    public int getYkj() {
        return ykj;
    }

    public void setYkj(int ykj) {
        this.ykj = ykj;
    }

    public void drawIdle(PApplet app, int f) {
        if (f == -1) {
            t = 0;
            f = 0;
        }
        if (f % 10 == 0) {
            t++;
        }
        if (t >= 6) {
            t = 0;
        }
        app.image(idle[t], xkj, ykj, width, height);
    }

    public void bergerak(boolean right, boolean left, boolean up, boolean down) {
        if (right) {
            xkj += 3;
        } else if (left) {
            xkj -= 3;
        } else if (up) {
            ykj -= 3;
        } else if (down) {
            ykj += 3;
        }
    }
}
