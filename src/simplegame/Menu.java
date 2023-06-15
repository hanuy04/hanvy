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
    
    public int pmouseX;
    public int pmouseY;
    
    PImage menu;
    PImage welcome;
    PImage start;
    PImage exit;
    
    String bip = "src/assets/sound/ostMain.wav";

    public SoundFile pm = new SoundFile(bip);
    
    private boolean start_game = false;
    private boolean exit_game = false;
    private boolean createNewWindow = false;
    
    private Button tombol_start = new Button(480 ,385, 100, 340);
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
        
        // welcome
        welcome = loadImage("src/assets/background/welcome.png");
        PImage[] wel = new PImage[1];
        frameRate(FPS);
        
        // start
        start = loadImage("src/assets/background/start.png");
        PImage[] sta = new PImage[1];
        frameRate(FPS);

        // exit
        exit = loadImage("src/assets/background/exit.png");
        PImage[] ex = new PImage[1];
        frameRate(FPS);

    }
    
    public void draw() {
        
        background(menu);
        
        // ngatur posisi
        image(welcome,395 ,-80);
        image(start,395 ,300);
        image(exit,395 ,450);
        
        // muncul button dan tulisan
        fill(255, 255, 255, 128); // Alpha diatur menjadi 128 (setengah transparan)
        
        // untuk mengenali sensor mouse apakah sudah di button
        sensor();

    }
    
    public void mousePressed() {
        if (start_game) {
            System.out.println("start");
            String[] simpleG = {"simpleG"};
            PApplet.runSketch(simpleG, new SimpleGame());
            createNewWindow = false;
            surface.setVisible(false);
            stop();
            start_game = false;
        }
        if(exit_game){
            exit();
        }
    }

    public void sensor() {
        if (cekButton(tombol_start.getX(), tombol_start.getY(), tombol_start.getWidth(), tombol_start.getHeight())) {
            start_game = true;
            System.out.println("kena");
        } else {
            start_game = false;
        }
        
        if (cekButton(tombol_exit.getX(), tombol_exit.getY(), tombol_exit.getWidth(), tombol_exit.getHeight())) {
            exit_game = true;
        } else {
            exit_game = false;
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
