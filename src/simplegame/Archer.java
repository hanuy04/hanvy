/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplegame;

import processing.core.PImage;

/**
 *
 * @author Hanvy
 */
public class Archer extends Fixed {

    private PImage[] idle;
    private int width, height, xa, ya;
    private int t = 0;

    public Archer(PImage[] idle, int width, int height, int xa, int ya, int x, int y) {
        super(x, y, idle);
        this.idle = idle;
        this.width = width;
        this.height = height;
        this.xa = xa;
        this.ya = ya;
    }

    public PImage[] getIdle() {
        return idle;
    }

    public void setIdle(PImage[] idle) {
        this.idle = idle;
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

    public int getXa() {
        return xa;
    }

    public void setXa(int xa) {
        this.xa = xa;
    }

    public int getYa() {
        return ya;
    }

    public void setYa(int ya) {
        this.ya = ya;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

}
