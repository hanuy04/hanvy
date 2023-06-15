/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplegame;

import processing.core.PApplet;
import processing.core.PImage;
import static simplegame.SimpleGame.FPS;

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
    
    String bip = "src/assets/sound/ostMain.wav";

    public SoundFile pm = new SoundFile(bip);
    
    private boolean start_game = false;
    private boolean createNewWindow = false;
    
    private Button menu_button = new Button(800, 100, 40, 160);
    
    public static void main(String[] args) {
        
        
    }
    
    public void setup() {
        
        // background
        menu = loadImage("src/assets/background/menu.jpg");
        PImage[] temp = new PImage[1];
        frameRate(FPS);
        
    }
    
    public void draw() {
        
        // muncul button dan tulisan
        fill(255, 255, 255);
        rect(menu_button.getX(), menu_button.getY(), menu_button.getWidth(), menu_button.getHeight());
        
        // untuk mengenali sensor mouse apakah sudah di button
        sensor();

        // mengubah bg saat dragon_fight
        if (createNewWindow) {
            pm.stop();
            String[] dragonF = {"dragonF"};
            PApplet.runSketch(dragonF, new DragonFight());
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
        if (cekButton(menu_button.getX(), menu_button.getY(), menu_button.getWidth(), menu_button.getHeight())) {
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
