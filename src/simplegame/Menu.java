/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplegame;

import processing.core.PApplet;
import processing.core.PImage;
import static simplegame.SimpleGame.FPS;
import static simplegame.SimpleGame.HEIGHT;
import static simplegame.SimpleGame.WIDTH;

/**
 *
 * @author asus
 */
public class Menu extends PApplet{
    
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int FPS = 60;

    
    public int mouseX;
    public int mouseY;
    public int pmouseX;
    public int pmouseY;
    
    PImage menu;
    PImage welcome;
    PImage start;
    PImage exit;
    
    String bip = "src/assets/sound/ostMain.wav";

    public SoundFile pm = new SoundFile(bip);
    
    private boolean start_game = false;
    private boolean createNewWindow = false;
    
    private Button tombol_start = new Button(480, 370, 100, 340);
    private Button tombol_exit = new Button(500, 510, 100, 280);
    
    public static void main(String[] args) {
        
        PApplet.main("simplegame.Menu");
        
    }
    
    public void settings() {
        // setting default screen
        size(WIDTH, HEIGHT); // 1280x720
    }

    
    public void setup() {
        
        // background
        menu = loadImage("src/assets/background/menu.jpg");
        PImage[] temp = new PImage[1];
        frameRate(FPS);
        
        welcome = loadImage("src/assets/background/welcome.png");
        PImage[] wel = new PImage[1];
        frameRate(FPS);
        
        start = loadImage("src/assets/background/start.png");
        PImage[] sta = new PImage[1];
        frameRate(FPS);

        exit = loadImage("src/assets/background/exit.png");
        PImage[] ex = new PImage[1];
        frameRate(FPS);

    }
    
    public void trans(float v1, float v2, float v3, float v4) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      #580                // Field recorder:Lprocessing/core/PGraphics;
         * 4: ifnull        17
         * 7: aload_0
         * 8: getfield      #580                // Field recorder:Lprocessing/core/PGraphics;
         * 11: fload_1
         * 12: fload_2
         * 13: fload_3
         * 14: invokevirtual #2984               // Method processing/core/PGraphics.fill:(FFF)V
         * 17: aload_0
         * 18: getfield      #343                // Field g:Lprocessing/core/PGraphics;
         * 21: fload_1
         * 22: fload_2
         * 23: fload_3
         * 24: invokevirtual #2984               // Method processing/core/PGraphics.fill:(FFF)V
         * 27: return
         *  */
        // </editor-fold>
    }
    
    public void draw() {
        
        background(menu);
        
        image(welcome,395 ,-80);
        image(start,395 ,300);
        image(exit,395 ,450);
        
        // muncul button dan tulisan
        fill(255, 255, 255, 128); // Alpha diatur menjadi 128 (setengah transparan)
        
        // untuk mengenali sensor mouse apakah sudah di button
        sensor();

        // mengubah bg saat dragon_fight
        if (createNewWindow) {
            pm.stop();
            String[] simpleG = {"simpleG"};
            PApplet.runSketch(simpleG, new DragonFight());
            createNewWindow = false;
        }

    }
    
    public void mousePressed() {
        if (start_game) {
            createNewWindow = true;
            start_game = false;
        }
    }

    public void sensor() {
        if (cekButton(tombol_start.getX(), tombol_start.getY(), tombol_start.getWidth(), tombol_start.getHeight())) {
            start_game = true;
        } else {
            start_game = false;
        }
        
        if (cekButton(tombol_exit.getX(), tombol_exit.getY(), tombol_exit.getWidth(), tombol_exit.getHeight())) {
            start_game = true;
        } else {
            start_game = false;
        }
    }

    public boolean cekButton(int x, int y, int width, int height) {
        if (mouseX >= x && mouseX <= (x + width) && mouseY >= y && mouseY <= (y + height)) {
            return true;
        } else {
            return false;
        }
    }


}
