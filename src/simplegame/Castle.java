/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplegame;

import processing.core.*;

/**
 *
 * @author Hanvy
 */
public class Castle extends Fixed {

    private int hp;
    private int gold = 0;

    public Castle(int hp, int x, int y, PImage[] idle) {
        super(x, y, idle);
        this.hp = 1000;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
