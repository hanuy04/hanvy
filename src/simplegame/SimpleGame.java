/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplegame;

import java.util.ArrayList;
import java.util.Random;
import processing.core.*;

/**
 *
 * @author Hanvy
 */
public class SimpleGame extends PApplet {

    // default screen
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int FPS = 60;

    // background dragon_fight
    PImage bgdragonfight;
    PImage bgWin, bgLose;

    // peluru
    ArrayList<Peluru> pel = new ArrayList<>();
    PImage[] peluru;

    // panah
    ArrayList<Panah> pan = new ArrayList<>();
    PImage[] panah;

    // vampire
    ArrayList<Vampire> vam = new ArrayList<>();
    PImage[] vampire;

    // knight
    ArrayList<KnightJalan> kn = new ArrayList<>();
    PImage[] knight;

    // runningman
    ArrayList<RunningManJalan> rn = new ArrayList<>();
    PImage[] runningman;

    PImage[] knattack;
    PImage[] rnattack;

    // enemy
    // player
    PImage bg;
    Knight k;
    Castle c;
    Vampire v;
    Bomber b;
    Archer a;
    Archer be;
    Archer ce;
    Archer d;
    Archer e;
    Archer ef;
    Archer g;
    Archer h;
    Archer i;
    Archer j;
    Archer ka;
    Archer l;
    KnightJalan kj;
    RunningMan r;

    // enemy
    FlappyRider fr;
    FlappyRider fr2;
    FlappyRider fr3;
    RedWitch rw;
    RedWitch rw2;
    RedWitch rw3;
    RedWitch rw4;
    RedWitch rw5;
    Zombie z;
    Zombie z1;
    Zombie z2;
    Zombie z3;
    Zombie z4;
    Zombie z5;
    Zombie z6;
    Zombie z7;
    Zombie z8;
    Zombie z9;

    int f = 0;
    int score;
    int hp = 1000;
    int hpfr = 200;
    int hpfr2 = 200;
    int hpfr3 = 200;
    int hprw = 300;
    int hprw2 = 300;
    int hprw3 = 300;
    int hprw4 = 300;
    int hprw5 = 300;
    int hpz = 400;
    int hpz1 = 400;
    int hpz2 = 400;
    int hpz3 = 400;
    int hpz4 = 400;
    int hpz5 = 400;
    int hpz6 = 400;
    int hpz7 = 400;
    int hpz8 = 400;
    int hpz9 = 400;
    int level = 0;
    int wave = 1;
    int koorXfr = 0;
    int koorYfr = 0;
    int koorXfr2 = 0;
    int koorYfr2 = 0;
    int koorXfr3 = 0;
    int koorYfr3 = 0;
    int koorXrw = 0;
    int koorYrw = 0;
    int koorXrw2 = 0;
    int koorYrw2 = 0;
    int koorXrw3 = 0;
    int koorYrw3 = 0;
    int koorXrw4 = 0;
    int koorYrw4 = 0;
    int koorXrw5 = 0;
    int koorYrw5 = 0;
    int koorXz = 0;
    int koorYz = 0;
    int koorXz1 = 0;
    int koorYz1 = 0;
    int koorXz2 = 0;
    int koorYz2 = 0;
    int koorXz3 = 0;
    int koorYz3 = 0;
    int koorXz4 = 0;
    int koorYz4 = 0;
    int koorXz5 = 0;
    int koorYz5 = 0;
    int koorXz6 = 0;
    int koorYz6 = 0;
    int koorXz7 = 0;
    int koorYz7 = 0;
    int koorXz8 = 0;
    int koorYz8 = 0;
    int koorXz9 = 0;
    int koorYz9 = 0;

    private HighScoreManager highScoreManager;

    // boolean untuk button lawan dragon
    private boolean start_dragon_fight = false;
    private boolean createNewWindow = false;
    PApplet newWindow;

    // boolean untuk opsi gerakan
    private boolean left = false, right = false, up = false, down = false;

    // boolean untuk posisi nembak
    private boolean tembak = false;
    private boolean tembakPanah = false;

    // boolean untuk mengeluarkan vampire
    private boolean vamOut = false;

    // boolean untuk mengeluarkan knight
    private boolean knOut = false;

    // boolean untuk mengeluarkan runningman
    private boolean rnOut = false;

    // button
    private Button dragon_fight = new Button(800, 100, 40, 160);

    public static void main(String[] args) {
        // TODO code application logic here
        PApplet.main("simplegame.SimpleGame");
    }

    public void settings() {
        // setting default screen
        size(WIDTH, HEIGHT); // 1280x720
    }

    // membaca file dari asset
    String bip = "src/assets/sound/ostMain.wav";

    // memanggil class SoundFile
    public SoundFile pm = new SoundFile(bip);

    // sound system
    public void setup() {
        // highscore
        highScoreManager = new HighScoreManager();
        score = 0;

        // font setting
        PFont font = createFont("Courier New", 22);
        textFont(font);
        fill(0, 0, 0);

        // memainkan music
        pm.PlayMusic();

        // background
        bg = loadImage("src/assets/background/bgstone.jpg");
        PImage[] temp = new PImage[1];
        frameRate(FPS);

        //background win
        bgWin = loadImage("src/assets/background/win.png");

        //background lose
        bgLose = loadImage("src/assets/background/lose.png");

        // castle
        PImage[] fixed = new PImage[4];
        fixed[0] = loadImage("src/assets/castle/castle.png");
        c = new Castle(1000, 130, 280, fixed);

        // knight
        PImage[] fixedChar = new PImage[1];
        fixedChar[0] = loadImage("src/assets/player/knight4.png");
        k = new Knight(fixedChar, 55, 75, 780, 480, 278, 430);

        // runningman
        PImage[] fixedChar5 = new PImage[1];
        fixedChar5[0] = loadImage("src/assets/player/runningman7.png");
        r = new RunningMan(fixedChar5, 55, 75, 780, 480, 200, 418);

        // vampire
        PImage[] fixedChar2 = new PImage[1];
        fixedChar2[0] = loadImage("src/assets/player/vampire.png");
        v = new Vampire(fixedChar2, 90, 90, 780, 480, 215, 420, 80);

        // bomber
        PImage[] fixedChar3 = new PImage[1];
        fixedChar3[0] = loadImage("src/assets/player/bomber.png");
        b = new Bomber(fixedChar3, 90, 90, 780, 480, 260, 295);

        // archer
        PImage[] fixedChar4 = new PImage[12];
        fixedChar4[0] = loadImage("src/assets/backup/archer.png");
        a = new Archer(fixedChar4, 80, 50, 780, 480, 100, 450);

        fixedChar4[1] = loadImage("src/assets/backup/archer.png");
        be = new Archer(fixedChar4, 80, 50, 780, 480, 100, 500);

        fixedChar4[2] = loadImage("src/assets/backup/archer.png");
        ce = new Archer(fixedChar4, 80, 50, 780, 480, 100, 550);

        fixedChar4[3] = loadImage("src/assets/backup/archer.png");
        d = new Archer(fixedChar4, 80, 50, 780, 480, 100, 600);

        fixedChar4[4] = loadImage("src/assets/backup/archer.png");
        e = new Archer(fixedChar4, 80, 50, 780, 480, 60, 450);

        fixedChar4[5] = loadImage("src/assets/backup/archer.png");
        ef = new Archer(fixedChar4, 80, 50, 780, 480, 60, 500);

        fixedChar4[6] = loadImage("src/assets/backup/archer.png");
        g = new Archer(fixedChar4, 80, 50, 780, 480, 60, 550);

        fixedChar4[7] = loadImage("src/assets/backup/archer.png");
        h = new Archer(fixedChar4, 80, 50, 780, 480, 60, 600);

        fixedChar4[8] = loadImage("src/assets/backup/archer.png");
        i = new Archer(fixedChar4, 80, 50, 780, 480, 20, 450);

        fixedChar4[9] = loadImage("src/assets/backup/archer.png");
        j = new Archer(fixedChar4, 80, 50, 780, 480, 20, 500);

        fixedChar4[10] = loadImage("src/assets/backup/archer.png");
        ka = new Archer(fixedChar4, 80, 50, 780, 480, 20, 550);

        fixedChar4[11] = loadImage("src/assets/backup/archer.png");
        l = new Archer(fixedChar4, 80, 50, 780, 480, 20, 600);

        // random untuk merandom tinggi di mana enemy muncul
        Random rand = new Random();
        int random = rand.nextInt(280, 600);

        // MUSUH
        // flappy rider
        PImage[] fixedEn = new PImage[7];
        for (int m = 0; m < fixedEn.length; m++) {
            fixedEn[m] = loadImage("src/assets/enemy/flappyrider" + (m + 1) + ".png");
        }
        fr = new FlappyRider(fixedEn, 70, 70, 1000, random);
        random = rand.nextInt(280, 600);
        fr2 = new FlappyRider(fixedEn, 70, 70, 1000, random);
        random = rand.nextInt(280, 600);
        fr3 = new FlappyRider(fixedEn, 70, 70, 1000, random);

        // red witch
        int random2 = rand.nextInt(300, 600);
        PImage[] fixedEn2 = new PImage[1];
        fixedEn2[0] = loadImage("src/assets/enemy/redwitch.png");
        rw = new RedWitch(fixedEn2, 50, 50, 1000, random2);
        random2 = rand.nextInt(300, 600);
        rw2 = new RedWitch(fixedEn2, 50, 50, 1000, random2);
        random2 = rand.nextInt(300, 600);
        rw3 = new RedWitch(fixedEn2, 50, 50, 1000, random2);
        random2 = rand.nextInt(300, 600);
        rw4 = new RedWitch(fixedEn2, 50, 50, 1000, random2);
        random2 = rand.nextInt(300, 600);
        rw5 = new RedWitch(fixedEn2, 50, 50, 1000, random2);

        // zombie
        int random3 = rand.nextInt(300, 600);
        PImage[] fixedEn3 = new PImage[4];
        for (int m = 0; m < fixedEn3.length; m++) {
            fixedEn3[m] = loadImage("src/assets/enemy/zombie" + (m + 1) + ".png");
        }
        z = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z1 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z2 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z3 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z4 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z5 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z6 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z7 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z8 = new Zombie(fixedEn3, 60, 70, 1000, random3);
        random3 = rand.nextInt(300, 600);
        z9 = new Zombie(fixedEn3, 60, 70, 1000, random3);

        // panggil vampire
        vampire = new PImage[3];
        for (int m = 0; m < vampire.length; m++) {
            vampire[m] = loadImage("src/assets/player/vampire.png");
        }

        // panggil peluru
        peluru = new PImage[1];
        peluru[0] = loadImage("src/assets/bullets/peluru.png");

        // panggil panah
        panah = new PImage[4];
        for (int m = 0; m < panah.length; m++) {
            panah[m] = loadImage("src/assets/arrows/panah.png");
        }

        // panggil knight
        knight = new PImage[6];
        for (int m = 0; m < knight.length; m++) {
            knight[m] = loadImage("src/assets/player/knight" + (m + 1) + ".png");
        }

        knattack = new PImage[4];
        for (int m = 0; m < 4; m++) {
            knattack[m] = loadImage("src/assets/player/knightattack" + (m + 1) + ".png");
        }

        // panggil runningman
        runningman = new PImage[7];
        for (int m = 0; m < runningman.length; m++) {
            runningman[m] = loadImage("src/assets/player/runningman" + (m + 1) + ".png");
        }

        rnattack = new PImage[6];
        for (int m = 0; m < 6; m++) {
            rnattack[m] = loadImage("src/assets/player/runningmanattack" + (m + 1) + ".png");
        }

        bgdragonfight = loadImage("src/assets/background/bg2.jpg");
    }

    public void draw() {
        // kalau dipencet b
        if (tembak) {
            pel.add(new Peluru(peluru, 50, 10, 265, 330));

            tembak = false;
        }

        // kalau dipencet p
        if (tembakPanah) {
            // panah dari baris depan
            pan.add(new Panah(panah, 90, 60, 100, 450));
            pan.add(new Panah(panah, 90, 60, 100, 500));
            pan.add(new Panah(panah, 90, 60, 100, 550));
            pan.add(new Panah(panah, 90, 60, 100, 600));

            // panah dari baris tengah
            pan.add(new Panah(panah, 90, 60, 60, 450));
            pan.add(new Panah(panah, 90, 60, 60, 500));
            pan.add(new Panah(panah, 90, 60, 60, 550));
            pan.add(new Panah(panah, 90, 60, 60, 600));

            // panah baris belakang
            pan.add(new Panah(panah, 90, 60, 20, 450));
            pan.add(new Panah(panah, 90, 60, 20, 500));
            pan.add(new Panah(panah, 90, 60, 20, 550));
            pan.add(new Panah(panah, 90, 60, 20, 600));

            tembakPanah = false;
        }

        // kalau dipencet v
        if (vamOut) {
            vam.add(new Vampire(vampire, 90, 90, 100, 100, 250, 260, 80));
            vam.add(new Vampire(vampire, 90, 90, 100, 100, 250, 330, 80));
            vam.add(new Vampire(vampire, 90, 90, 100, 100, 250, 400, 80));

            vamOut = false;
        }

        // kalau dipencet k
        if (knOut) {
            kn.add(new KnightJalan(knight, 45, 65, 100, 100, 300, 450, 120));
            kn.add(new KnightJalan(knight, 45, 65, 100, 100, 300, 500, 120));
            kn.add(new KnightJalan(knight, 45, 65, 100, 100, 300, 550, 120));
            kn.add(new KnightJalan(knight, 45, 65, 100, 100, 300, 600, 120));

            knOut = false;
        }

        // kalau dipencet r
        if (rnOut) {
            rn.add(new RunningManJalan(runningman, 45, 65, 100, 100, 300, 470, 70));
            rn.add(new RunningManJalan(runningman, 45, 65, 100, 100, 300, 530, 70));
            rn.add(new RunningManJalan(runningman, 45, 65, 100, 100, 300, 590, 70));

            rnOut = false;
        }

        // background
        background(bg);

        // koordinat gold
        int xG = 100;
        int yG = 50;
        text("Score: " + score, xG, yG);

        // koordinat HP castle
        int xHP = 600;
        int yHP = 50;
        text("HP: " + hp, xHP, yHP);

        // koordinat wave
        int xW = 600;
        int yW = 100;
        text("Wave " + wave, xW, yW);

        // gambar karakter
        // castle
        c.drawIdle(this, f);

        // knight
        k.drawIdle(this, f);

        // vampire
        v.drawIdle(this, f);

        // bomber
        b.drawIdle(this, f);

        // runningman
        r.drawIdle(this, f);

        // archer
        a.drawIdle(this, f);

        // backup
        be.drawIdle(this, f);
        ce.drawIdle(this, f);
        d.drawIdle(this, f);
        e.drawIdle(this, f);
        ef.drawIdle(this, f);
        g.drawIdle(this, f);
        h.drawIdle(this, f);
        i.drawIdle(this, f);
        j.drawIdle(this, f);
        ka.drawIdle(this, f);
        l.drawIdle(this, f);

        if (wave == 1) {
            // flappy rider
            fr.drawIdle(this, f);
            fr2.drawIdle(this, f);
            fr3.drawIdle(this, f);
            // pergerakan enemy
            // flappy rider
            if (fr.getXfr() > c.getX() + 200) {
                fr.bergerak(true);
            } else if (fr.getXfr() <= c.getX() + 200) {
                fr.bergerak(false);
                hp -= 2;
                if (hp <= 0) {
                    hp = 0;
                    fr.setXfr(-10000);
                    fr.bergerak(false);
                }
            }
            if (fr2.getXfr() > c.getX() + 200) {
                fr2.bergerak(true);
            } else if (fr2.getXfr() <= c.getX() + 200) {
                fr2.bergerak(false);
                hp -= 2;
                if (hp <= 0) {
                    hp = 0;
                    fr2.setXfr(-10000);
                    fr.bergerak(false);
                }
            }

            if (fr3.getXfr() > c.getX() + 200) {
                fr3.bergerak(true);
            } else if (fr3.getXfr() <= c.getX() + 200) {
                fr3.bergerak(false);
                hp -= 2;
                if (hp <= 0) {
                    hp = 0;
                    fr3.setXfr(-10000);
                    fr.bergerak(false);
                }
            }
        } else if (wave == 2) {
            // red witch
            rw.drawIdle(this, f);
            rw2.drawIdle(this, f);
            rw3.drawIdle(this, f);
            rw4.drawIdle(this, f);
            rw5.drawIdle(this, f);

            // red witch
            if (rw.getXrw() > c.getX() + 200) {
                rw.bergerak(true);
            } else if (rw.getXrw() <= c.getX() + 200) {
                rw.bergerak(false);
                hp -= 3;
                if (hp <= 0) {
                    hp = 0;
                    rw.setXrw(-10000);
                    rw.bergerak(false);
                }
            }
            if (rw2.getXrw() > c.getX() + 200) {
                rw2.bergerak(true);
            } else if (rw2.getXrw() <= c.getX() + 200) {
                rw2.bergerak(false);
                hp -= 3;
                if (hp < 0) {
                    hp = 0;
                    rw2.setXrw(-10000);
                    rw.bergerak(false);
                }
            }
            if (rw3.getXrw() > c.getX() + 200) {
                rw3.bergerak(true);
            } else if (rw3.getXrw() <= c.getX() + 200) {
                rw3.bergerak(false);
                hp -= 3;
                if (hp <= 0) {
                    hp = 0;
                    rw3.setXrw(-10000);
                    rw.bergerak(false);
                }
            }
            if (rw4.getXrw() > c.getX() + 200) {
                rw4.bergerak(true);
            } else if (rw4.getXrw() <= c.getX() + 200) {
                rw4.bergerak(false);
                hp -= 3;
                if (hp <= 0) {
                    hp = 0;
                    rw4.setXrw(-10000);
                    rw.bergerak(false);
                }
            }
            if (rw5.getXrw() > c.getX() + 200) {
                rw5.bergerak(true);
            } else if (rw5.getXrw() <= c.getX() + 200) {
                rw5.bergerak(false);
                hp -= 3;
                if (hp <= 0) {
                    hp = 0;
                    rw5.setXrw(-10000);
                    rw.bergerak(false);
                }
            }
        } else if (wave == 3) {
            // zombie
            z.drawIdle(this, f);
            z1.drawIdle(this, f);
            z2.drawIdle(this, f);
            z3.drawIdle(this, f);
            z4.drawIdle(this, f);
            z5.drawIdle(this, f);
            z6.drawIdle(this, f);
            z7.drawIdle(this, f);
            z8.drawIdle(this, f);
            z9.drawIdle(this, f);

            // zombie
            if (z.getXz() > c.getX() + 200) {
                z.bergerak(true);
            } else if (z.getXz() <= c.getX() + 200) {
                z.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z.setXz(-10000);
                }
            }
            if (z2.getXz() > c.getX() + 200) {
                z2.bergerak(true);
            } else if (z2.getXz() <= c.getX() + 200) {
                z2.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z2.setXz(-10000);
                }
            }
            if (z3.getXz() > c.getX() + 200) {
                z3.bergerak(true);
            } else if (z3.getXz() <= c.getX() + 200) {
                z.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z3.setXz(10000);
                }
            }
            if (z4.getXz() > c.getX() + 200) {
                z4.bergerak(true);
            } else if (z4.getXz() <= c.getX() + 200) {
                z4.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z4.setXz(-10000);
                }
            }
            if (z5.getXz() > c.getX() + 200) {
                z5.bergerak(true);
            } else if (z5.getXz() <= c.getX() + 200) {
                z5.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z5.setXz(-10000);
                }
            }
            if (z6.getXz() > c.getX() + 200) {
                z6.bergerak(true);
            } else if (z6.getXz() <= c.getX() + 200) {
                z6.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z6.setXz(-10000);
                }
            }
            if (z7.getXz() > c.getX() + 200) {
                z7.bergerak(true);
            } else if (z7.getXz() <= c.getX() + 200) {
                z7.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z7.setXz(-10000);
                }
            }
            if (z8.getXz() > c.getX() + 200) {
                z8.bergerak(true);
            } else if (z8.getXz() <= c.getX() + 200) {
                z8.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z8.setXz(-10000);
                }
            }
            if (z9.getXz() > c.getX() + 200) {
                z9.bergerak(true);
            } else if (z9.getXz() <= c.getX() + 200) {
                z9.bergerak(false);
                hp -= 4;
                if (hp <= 0) {
                    hp = 0;
                    z9.setXz(-10000);
                }
            }
        }

        // tampilin peluru
        for (int i = pel.size() - 1; i >= 0; i--) {
            pel.get(i).bergerak(true);
            pel.get(i).drawIdle(this, f);
            // kalau kena enemy
            // bomb
            if (wave == 1) {
                if (pel.get(i).getX() >= fr.getXfr() && pel.get(i).getY() <= fr.getYfr() + 25 && pel.get(i).getY() >= fr.getYfr() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hpfr -= 20; // kurangi hp Enemy sebesar 10
                    if (hpfr <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXfr = fr.getXfr();
                        koorYfr = fr.getYfr();
                        // kalau 0 dihilangkan dan player dapet gold
                        fr.setXfr(-15500);
                        score += 10;
                    }
                } else if (pel.get(i).getX() >= fr2.getXfr() && pel.get(i).getY() <= fr2.getYfr() + 25 && pel.get(i).getY() >= fr2.getYfr() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hpfr2 -= 20; // kurangi hp Enemy sebesar 10
                    if (hpfr2 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXfr2 = fr2.getXfr();
                        koorYfr2 = fr2.getYfr();
                        // kalau 0 dihilangkan dan player dapet gold
                        fr2.setXfr(-15500);
                        score += 10;
                    }
                } else if (pel.get(i).getX() >= fr3.getXfr() && pel.get(i).getY() <= fr3.getYfr() + 25 && pel.get(i).getY() >= fr3.getYfr() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hpfr3 -= 20; // kurangi hp Enemy sebesar 10
                    if (hpfr3 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXfr3 = fr3.getXfr();
                        koorYfr3 = fr3.getYfr();
                        // kalau 0 dihilangkan dan player dapet gold
                        fr3.setXfr(-15500);
                        score += 10;
                    }
                }
            } else if (wave == 2) {
                if (pel.get(i).getX() >= rw.getXrw() && pel.get(i).getY() <= rw.getYrw() + 25 && pel.get(i).getY() >= rw.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hprw -= 35;
                    if (hprw <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw = rw.getXrw();
                        koorYrw = rw.getYrw();
                        rw.setXrw(-15500);
                        score += 10;
                    }
                } else if (pel.get(i).getX() >= rw2.getXrw() && pel.get(i).getY() <= rw2.getYrw() + 25 && pel.get(i).getY() >= rw2.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hprw2 -= 35;
                    if (hprw2 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw2 = rw2.getXrw();
                        koorYrw2 = rw2.getYrw();
                        rw2.setXrw(-15500);
                        score += 10;
                    }
                } else if (pel.get(i).getX() >= rw3.getXrw() && pel.get(i).getY() <= rw3.getYrw() + 25 && pel.get(i).getY() >= rw3.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hprw3 -= 35;
                    if (hprw3 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw3 = rw3.getXrw();
                        koorYrw3 = rw3.getYrw();
                        rw3.setXrw(-15500);
                        score += 10;
                    }
                } else if (pel.get(i).getX() >= rw4.getXrw() && pel.get(i).getY() <= rw4.getYrw() + 25 && pel.get(i).getY() >= rw4.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hprw4 -= 35;
                    if (hprw4 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw4 = rw4.getXrw();
                        koorYrw4 = rw4.getYrw();
                        rw4.setXrw(-15500);
                        score += 10;
                    }
                } else if (pel.get(i).getX() >= rw5.getXrw() && pel.get(i).getY() <= rw5.getYrw() + 25 && pel.get(i).getY() >= rw5.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pel.remove(i); // hapus peluru
                    hprw5 -= 35;
                    if (hprw5 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw5 = rw5.getXrw();
                        koorYrw5 = rw5.getYrw();
                        rw5.setXrw(-15500);
                        score += 10;
                    }
                }
            }
        }

        // tampilin panah
        for (int i = pan.size() - 1; i >= 0; i--) {
            pan.get(i).bergerak(true);
            pan.get(i).drawIdle(this, f);

            if (wave == 1) {
                if (pan.get(i).getX() >= fr.getXfr() && pan.get(i).getY() <= fr.getYfr() + 25 && pan.get(i).getY() >= fr.getYfr() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpfr -= 15;
                    if (hpfr <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXfr = fr.getXfr();
                        koorYfr = fr.getYfr();
                        fr.setXfr(15500);
                        fr.bergerak(false);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= fr2.getXfr() && pan.get(i).getY() <= fr2.getYfr() + 25 && pan.get(i).getY() >= fr2.getYfr() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpfr2 -= 15;
                    if (hpfr2 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXfr2 = fr2.getXfr();
                        koorYfr2 = fr2.getYfr();
                        fr2.setXfr(15500);
                        fr2.bergerak(false);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= fr3.getXfr() && pan.get(i).getY() <= fr3.getYfr() + 25 && pan.get(i).getY() >= fr3.getYfr() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpfr3 -= 15;
                    if (hpfr3 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXfr3 = fr3.getXfr();
                        koorYfr3 = fr3.getYfr();
                        fr3.setXfr(15500);
                        fr3.bergerak(false);
                        score += 10;
                    }
                }
            } else if (wave == 2) {
                if (pan.get(i).getX() >= rw.getXrw() && pan.get(i).getY() <= rw.getYrw() + 25 && pan.get(i).getY() >= rw.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i); // hapus peluru
                    hprw -= 20;
                    if (hprw <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw = rw.getXrw();
                        koorYrw = rw.getYrw();
                        rw.setXrw(-15500);
                        rw.bergerak(false);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= rw2.getXrw() && pan.get(i).getY() <= rw2.getYrw() + 25 && pan.get(i).getY() >= rw2.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i); // hapus peluru
                    hprw2 -= 20;
                    if (hprw2 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw2 = rw2.getXrw();
                        koorYrw2 = rw2.getYrw();
                        rw2.setXrw(-15500);
                        rw2.bergerak(false);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= rw3.getXrw() && pan.get(i).getY() <= rw3.getYrw() + 25 && pan.get(i).getY() >= rw3.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i); // hapus peluru
                    hprw3 -= 20;
                    if (hprw3 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw3 = rw3.getXrw();
                        koorYrw3 = rw3.getYrw();
                        rw3.setXrw(-15500);
                        rw3.bergerak(false);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= rw4.getXrw() && pan.get(i).getY() <= rw4.getYrw() + 25 && pan.get(i).getY() >= rw4.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i); // hapus peluru
                    hprw4 -= 20;
                    if (hprw4 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw4 = rw4.getXrw();
                        koorYrw4 = rw4.getYrw();
                        rw4.setXrw(-15500);
                        rw4.bergerak(false);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= rw5.getXrw() && pan.get(i).getY() <= rw5.getYrw() + 25 && pan.get(i).getY() >= rw5.getYrw() - 25) {
                    String bip = "src/assets/sound/bommeledak.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i); // hapus peluru
                    hprw5 -= 35;
                    if (hprw5 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXrw5 = rw5.getXrw();
                        koorYrw5 = rw5.getYrw();
                        rw5.setXrw(-15500);
                        rw5.bergerak(false);
                        score += 10;
                    }
                }
            } else if (wave == 3) {
                // kalau kena enemy
                if (pan.get(i).getX() >= z.getXz() && pan.get(i).getY() <= z.getYz() + 25 && pan.get(i).getY() >= z.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz -= 35;
                    if (hpz <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz = z.getXz();
                        koorYz = z.getYz();
                        z.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z1.getXz() && pan.get(i).getY() <= z1.getYz() + 25 && pan.get(i).getY() >= z1.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz1 -= 35;
                    if (hpz1 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz1 = z1.getXz();
                        koorYz1 = z1.getYz();
                        z1.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z2.getXz() && pan.get(i).getY() <= z2.getYz() + 25 && pan.get(i).getY() >= z2.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz2 -= 35;
                    if (hpz2 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz2 = z2.getXz();
                        koorYz2 = z2.getYz();
                        z2.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z3.getXz() && pan.get(i).getY() <= z3.getYz() + 25 && pan.get(i).getY() >= z3.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz3 -= 35;
                    if (hpz3 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz3 = z3.getXz();
                        koorYz3 = z3.getYz();
                        z3.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z4.getXz() && pan.get(i).getY() <= z4.getYz() + 25 && pan.get(i).getY() >= z4.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz4 -= 35;
                    if (hpz4 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz4 = z4.getXz();
                        koorYz4 = z4.getYz();
                        z4.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z5.getXz() && pan.get(i).getY() <= z5.getYz() + 25 && pan.get(i).getY() >= z5.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz5 -= 35;
                    if (hpz5 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz5 = z5.getXz();
                        koorYz5 = z5.getYz();
                        z5.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z6.getXz() && pan.get(i).getY() <= z6.getYz() + 25 && pan.get(i).getY() >= z6.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz6 -= 35;
                    if (hpz6 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz6 = z6.getXz();
                        koorYz6 = z6.getYz();
                        z6.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z7.getXz() && pan.get(i).getY() <= z7.getYz() + 25 && pan.get(i).getY() >= z7.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz7 -= 35;
                    if (hpz7 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz7 = z7.getXz();
                        koorYz7 = z7.getYz();
                        z7.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z8.getXz() && pan.get(i).getY() <= z8.getYz() + 25 && pan.get(i).getY() >= z8.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz8 -= 35;
                    if (hpz8 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz8 = z8.getXz();
                        koorYz8 = z8.getYz();
                        z8.setXz(15500);
                        score += 10;
                    }
                } else if (pan.get(i).getX() >= z9.getXz() && pan.get(i).getY() <= z9.getYz() + 25 && pan.get(i).getY() >= z9.getYz() - 25) {
                    String bip = "src/assets/sound/kenapanah.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    pan.remove(i);
                    hpz9 -= 35;
                    if (hpz9 <= 0) {
                        // tampung koordinat terakhir di variabel baru
                        koorXz9 = z9.getXz();
                        koorYz9 = z9.getYz();
                        z9.setXz(15500);
                        score += 10;
                    }
                }
            }
        }

        // tampilin vampire
        for (int i = vam.size() - 1; i >= 0; i--) {
            vam.get(i).bergerak(true, false, false, false);
            vam.get(i).drawIdle(this, f);
            if (wave == 1) {
                if (vam.get(i).getXv() >= fr.getXfr() && vam.get(i).getYv() <= fr.getYfr() + 25 && vam.get(i).getYv() >= fr.getYfr() - 25) {
                    // kalau sudah sampe, vampire ke kiri sampai enemy mati
                    vam.get(i).bergerak(false, true, false, false);
                    hpfr -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 10);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 10);
                    }
                    if (hpfr <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hpfr <= 0) {
                            vam.remove(i);
                            koorXfr = fr.getXfr();
                            koorYfr = fr.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr.setXfr(-15500);
                            score += 10;
                            hpfr = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                } else if (vam.get(i).getXv() >= fr2.getXfr() && vam.get(i).getYv() <= fr2.getYfr() + 25 && vam.get(i).getYv() >= fr2.getYfr() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hpfr2 -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 10);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 10);
                    }
                    if (hpfr2 <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hpfr2 <= 0) {
                            vam.remove(i);
                            koorXfr2 = fr2.getXfr();
                            koorYfr2 = fr2.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr2.setXfr(-15500);
                            score += 10;
                            hpfr2 = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                } else if (vam.get(i).getXv() >= fr3.getXfr() && vam.get(i).getYv() <= fr3.getYfr() + 25 && vam.get(i).getYv() >= fr3.getYfr() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hpfr3 -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 10);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 10);
                    }
                    if (hpfr3 <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hpfr3 <= 0) {
                            vam.remove(i);
                            koorXfr3 = fr3.getXfr();
                            koorYfr3 = fr3.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr3.setXfr(-15500);
                            score += 10;
                            hpfr = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                }
            } else if (wave == 2) {
                if (vam.get(i).getXv() >= rw.getXrw() && vam.get(i).getYv() <= rw.getYrw() + 25 && vam.get(i).getYv() >= rw.getYrw() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hprw -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    }
                    if (hprw <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hprw <= 0) {
                            vam.remove(i);
                            koorXrw = rw.getXrw();
                            koorYrw = rw.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw.setXrw(-15500);
                            score += 10;
                            hprw = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                } else if (vam.get(i).getXv() >= rw2.getXrw() && vam.get(i).getYv() <= rw2.getYrw() + 25 && vam.get(i).getYv() >= rw2.getYrw() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hprw2 -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    }
                    if (hprw2 <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hprw2 <= 0) {
                            vam.remove(i);
                            koorXrw2 = rw2.getXrw();
                            koorYrw2 = rw2.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw2.setXrw(-15500);
                            score += 10;
                            hprw2 = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                } else if (vam.get(i).getXv() >= rw3.getXrw() && vam.get(i).getYv() <= rw3.getYrw() + 25 && vam.get(i).getYv() >= rw3.getYrw() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hprw3 -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    }
                    if (hprw3 <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hprw3 <= 0) {
                            vam.remove(i);
                            koorXrw3 = rw3.getXrw();
                            koorYrw3 = rw3.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw3.setXrw(-15500);
                            score += 10;
                            hprw3 = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                } else if (vam.get(i).getXv() >= rw4.getXrw() && vam.get(i).getYv() <= rw4.getYrw() + 25 && vam.get(i).getYv() >= rw4.getYrw() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hprw4 -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    }
                    if (hprw4 <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hprw4 <= 0) {
                            vam.remove(i);
                            koorXrw4 = rw4.getXrw();
                            koorYrw4 = rw4.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw4.setXrw(-15500);
                            score += 10;
                            hprw4 = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                } else if (vam.get(i).getXv() >= rw5.getXrw() && vam.get(i).getYv() <= rw5.getYrw() + 25 && vam.get(i).getYv() >= rw5.getYrw() - 25) {
                    vam.get(i).bergerak(false, true, false, false);
                    hprw5 -= 20;
                    vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    if (vam.get(i).getHpv() >= 0) {
                        vam.get(i).setHpv(vam.get(i).getHpv() - 15);
                    }
                    if (hprw5 <= 0 || vam.get(i).getHpv() <= 0) {
                        if (hprw5 <= 0) {
                            vam.remove(i);
                            koorXrw5 = rw5.getXrw();
                            koorYrw5 = rw5.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw5.setXrw(-15500);
                            score += 10;
                            hprw = 0;
                        } else {
                            vam.get(i).setHpv(0);
                            vam.remove(i);
                        }
                    }
                }
            }
        }

        // tampilin knight
        for (int i = kn.size() - 1; i >= 0; i--) {
            kn.get(i).bergerak(true, false, false, false);
            kn.get(i).drawIdle(this, f);
            if (wave == 1) {
                if (kn.get(i).getXkj() >= fr.getXfr() && kn.get(i).getYkj() <= fr.getYfr() + 25 && kn.get(i).getYkj() >= fr.getYfr() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpfr -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpfr <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpfr <= 0) {
                            pm.stop();
                            koorXfr = fr.getXfr();
                            koorYfr = fr.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr.setXfr(15500);
                            score += 10;
                            hpfr = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= fr2.getXfr() && kn.get(i).getYkj() <= fr2.getYfr() + 25 && kn.get(i).getYkj() >= fr2.getYfr() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpfr2 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpfr2 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpfr2 <= 0) {
                            pm.stop();
                            koorXfr2 = fr2.getXfr();
                            koorYfr2 = fr2.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr2.setXfr(15500);
                            score += 10;
                            hpfr2 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= fr3.getXfr() && kn.get(i).getYkj() <= fr3.getYfr() + 25 && kn.get(i).getYkj() >= fr3.getYfr() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpfr3 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpfr3 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpfr3 <= 0) {
                            pm.stop();
                            koorXfr3 = fr3.getXfr();
                            koorYfr3 = fr3.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr3.setXfr(15500);
                            score += 10;
                            hpfr3 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                }
            } else if (wave == 2) {
                if (kn.get(i).getXkj() >= rw.getXrw() && kn.get(i).getYkj() <= rw.getYrw() + 25 && kn.get(i).getYkj() >= rw.getYrw() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hprw -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hprw <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hprw <= 0) {
                            pm.stop();
                            koorXrw = rw.getXrw();
                            koorYrw = rw.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw.setXrw(15500);
                            score += 10;
                            hprw = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= rw2.getXrw() && kn.get(i).getYkj() <= rw2.getYrw() + 25 && kn.get(i).getYkj() >= rw2.getYrw() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hprw2 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hprw2 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hprw2 <= 0) {
                            pm.stop();
                            koorXrw2 = rw2.getXrw();
                            koorYrw2 = rw2.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw2.setXrw(15500);
                            score += 10;
                            hprw2 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= rw3.getXrw() && kn.get(i).getYkj() <= rw3.getYrw() + 25 && kn.get(i).getYkj() >= rw3.getYrw() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hprw3 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hprw3 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hprw3 <= 0) {
                            pm.stop();
                            koorXrw3 = rw3.getXrw();
                            koorYrw3 = rw3.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw3.setXrw(15500);
                            score += 10;
                            hprw3 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= rw4.getXrw() && kn.get(i).getYkj() <= rw4.getYrw() + 25 && kn.get(i).getYkj() >= rw4.getYrw() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hprw4 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hprw4 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hprw4 <= 0) {
                            pm.stop();
                            koorXrw4 = rw4.getXrw();
                            koorYrw4 = rw4.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw4.setXrw(15500);
                            score += 10;
                            hprw4 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= rw5.getXrw() && kn.get(i).getYkj() <= rw5.getYrw() + 25 && kn.get(i).getYkj() >= rw5.getYrw() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hprw5 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hprw5 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hprw5 <= 0) {
                            pm.stop();
                            koorXrw5 = rw5.getXrw();
                            koorYrw5 = rw5.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw5.setXrw(15500);
                            score += 10;
                            hprw5 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                }
            } else if (wave == 3) {
                if (kn.get(i).getXkj() >= z.getXz() && kn.get(i).getYkj() <= z.getYz() + 25 && kn.get(i).getYkj() >= z.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz <= 0) {
                            pm.stop();
                            koorXz = z.getXz();
                            koorYz = z.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z.setXz(15500);
                            score += 10;
                            hpz = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z1.getXz() && kn.get(i).getYkj() <= z1.getYz() + 25 && kn.get(i).getYkj() >= z1.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz1 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz1 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz1 <= 0) {
                            pm.stop();
                            koorXz1 = z1.getXz();
                            koorYz1 = z1.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z1.setXz(15500);
                            score += 10;
                            hpz1 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z2.getXz() && kn.get(i).getYkj() <= z2.getYz() + 25 && kn.get(i).getYkj() >= z2.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz2 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz2 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz2 <= 0) {
                            pm.stop();
                            koorXz2 = z2.getXz();
                            koorYz2 = z2.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z2.setXz(15500);
                            score += 10;
                            hpz2 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z3.getXz() && kn.get(i).getYkj() <= z3.getYz() + 25 && kn.get(i).getYkj() >= z3.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz3 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz3 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz3 <= 0) {
                            pm.stop();
                            koorXz3 = z3.getXz();
                            koorYz3 = z3.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z3.setXz(15500);
                            score += 10;
                            hpz3 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z4.getXz() && kn.get(i).getYkj() <= z4.getYz() + 25 && kn.get(i).getYkj() >= z4.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz4 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz4 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz4 <= 0) {
                            pm.stop();
                            koorXz4 = z4.getXz();
                            koorYz4 = z4.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z4.setXz(15500);
                            score += 10;
                            hpz4 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z5.getXz() && kn.get(i).getYkj() <= z5.getYz() + 25 && kn.get(i).getYkj() >= z5.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz5 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz5 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz5 <= 0) {
                            pm.stop();
                            koorXz5 = z5.getXz();
                            koorYz5 = z5.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z5.setXz(15500);
                            score += 10;
                            hpz5 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z6.getXz() && kn.get(i).getYkj() <= z6.getYz() + 25 && kn.get(i).getYkj() >= z6.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz6 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz6 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz6 <= 0) {
                            pm.stop();
                            koorXz6 = z6.getXz();
                            koorYz6 = z6.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z6.setXz(15500);
                            score += 10;
                            hpz6 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z7.getXz() && kn.get(i).getYkj() <= z7.getYz() + 25 && kn.get(i).getYkj() >= z7.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz7 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz7 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz7 <= 0) {
                            pm.stop();
                            koorXz7 = z7.getXz();
                            koorYz7 = z7.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z7.setXz(15500);
                            score += 10;
                            hpz7 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z8.getXz() && kn.get(i).getYkj() <= z8.getYz() + 25 && kn.get(i).getYkj() >= z8.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz8 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz8 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz8 <= 0) {
                            pm.stop();
                            koorXz8 = z8.getXz();
                            koorYz8 = z8.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z8.setXz(15500);
                            score += 10;
                            hpz8 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                } else if (kn.get(i).getXkj() >= z9.getXz() && kn.get(i).getYkj() <= z9.getYz() + 25 && kn.get(i).getYkj() >= z9.getYz() - 25) {
                    kn.get(i).setIdle(knattack, 4);
                    kn.get(i).bergerak(false, true, false, false);
                    String bip = "src/assets/sound/perang.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle(); // untuk sekali diputar
                    hpz9 -= 40;
                    kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                    if (kn.get(i).getHpk() >= 0) {
                        kn.get(i).setHpk(kn.get(i).getHpk() - 10);
                        pm.stop();
                    }
                    if (hpz9 <= 0 || kn.get(i).getHpk() <= 0) {
                        if (hpz9 <= 0) {
                            pm.stop();
                            koorXz9 = z9.getXz();
                            koorYz9 = z9.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z9.setXz(15500);
                            score += 10;
                            hpz9 = 0;
                        } else {
                            kn.get(i).setHpk(0);
                            kn.remove(i);
                        }
                    }
                }
            }
        }

        // tampilin runningman
        for (int i = rn.size() - 1; i >= 0; i--) {
            rn.get(i).bergerak(true, false, false, false);
            rn.get(i).drawIdle(this, f);
            if (wave == 1) {
                if (rn.get(i).getXrj() >= fr.getXfr() && rn.get(i).getYrj() <= fr.getYfr() + 25 && rn.get(i).getYrj() >= fr.getYfr() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpfr -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpfr <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpfr <= 0) {
                            koorXfr = fr.getXfr();
                            koorYfr = fr.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr.setXfr(15500);
                            score += 10;
                            hpfr = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= fr2.getXfr() && rn.get(i).getYrj() <= fr2.getYfr() + 25 && rn.get(i).getYrj() >= fr2.getYfr() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpfr2 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpfr2 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpfr2 <= 0) {
                            koorXfr2 = fr2.getXfr();
                            koorYfr2 = fr2.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr2.setXfr(15500);
                            score += 10;
                            hpfr2 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= fr3.getXfr() && rn.get(i).getYrj() <= fr3.getYfr() + 25 && rn.get(i).getYrj() >= fr3.getYfr() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpfr3 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpfr3 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpfr3 <= 0) {
                            koorXfr3 = fr3.getXfr();
                            koorYfr3 = fr3.getYfr();
                            // kalau 0 dihilangkan dan player dapet gold
                            fr3.setXfr(15500);
                            score += 10;
                            hpfr3 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                }
            } else if (wave == 2) {
                if (rn.get(i).getXrj() >= rw.getXrw() && rn.get(i).getYrj() <= rw.getYrw() + 25 && rn.get(i).getYrj() >= rw.getYrw() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hprw -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hprw <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hprw <= 0) {
                            koorXrw = rw.getXrw();
                            koorYrw = rw.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw.setXrw(15500);
                            score += 10;
                            hprw = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= rw2.getXrw() && rn.get(i).getYrj() <= rw2.getYrw() + 25 && rn.get(i).getYrj() >= rw2.getYrw() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hprw2 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hprw2 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hprw2 <= 0) {
                            koorXrw2 = rw2.getXrw();
                            koorYrw2 = rw2.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw2.setXrw(15500);
                            score += 10;
                            hprw2 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= rw3.getXrw() && rn.get(i).getYrj() <= rw3.getYrw() + 25 && rn.get(i).getYrj() >= rw3.getYrw() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hprw3 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hprw3 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hprw3 <= 0) {
                            koorXrw3 = rw3.getXrw();
                            koorYrw3 = rw3.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw3.setXrw(15500);
                            score += 10;
                            hprw3 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= rw4.getXrw() && rn.get(i).getYrj() <= rw4.getYrw() + 25 && rn.get(i).getYrj() >= rw4.getYrw() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hprw4 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hprw4 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hprw4 <= 0) {
                            koorXrw4 = rw4.getXrw();
                            koorYrw4 = rw4.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw4.setXrw(15500);
                            score += 10;
                            hprw4 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= rw5.getXrw() && rn.get(i).getYrj() <= rw5.getYrw() + 25 && rn.get(i).getYrj() >= rw5.getYrw() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hprw5 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hprw5 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hprw5 <= 0) {
                            koorXrw5 = rw5.getXrw();
                            koorYrw5 = rw5.getYrw();
                            // kalau 0 dihilangkan dan player dapet gold
                            rw.setXrw(15500);
                            score += 10;
                            hprw5 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                }
            } else if (wave == 3) {
                if (rn.get(i).getXrj() >= z.getXz() && rn.get(i).getYrj() <= z.getYz() + 25 && rn.get(i).getYrj() >= z.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz <= 0) {
                            koorXz = z.getXz();
                            koorYz = z.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z.setXz(15500);
                            score += 10;
                            hpz = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z1.getXz() && rn.get(i).getYrj() <= z1.getYz() + 25 && rn.get(i).getYrj() >= z1.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz1 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz1 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz1 <= 0) {
                            koorXz1 = z1.getXz();
                            koorYz1 = z1.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z1.setXz(15500);
                            score += 10;
                            hpz1 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z2.getXz() && rn.get(i).getYrj() <= z2.getYz() + 25 && rn.get(i).getYrj() >= z2.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz2 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz2 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz2 <= 0) {
                            koorXz2 = z2.getXz();
                            koorYz2 = z2.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z2.setXz(15500);
                            score += 10;
                            hpz2 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z3.getXz() && rn.get(i).getYrj() <= z3.getYz() + 25 && rn.get(i).getYrj() >= z3.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz3 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz3 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz3 <= 0) {
                            koorXz3 = z3.getXz();
                            koorYz3 = z3.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z3.setXz(15500);
                            score += 10;
                            hpz3 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z4.getXz() && rn.get(i).getYrj() <= z4.getYz() + 25 && rn.get(i).getYrj() >= z4.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz4 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz4 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz4 <= 0) {
                            koorXz4 = z4.getXz();
                            koorYz4 = z4.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z4.setXz(15500);
                            score += 10;
                            hpz4 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z5.getXz() && rn.get(i).getYrj() <= z5.getYz() + 25 && rn.get(i).getYrj() >= z5.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz5 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz5 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz5 <= 0) {
                            koorXz5 = z5.getXz();
                            koorYz5 = z5.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z5.setXz(15500);
                            score += 10;
                            hpz5 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z6.getXz() && rn.get(i).getYrj() <= z6.getYz() + 25 && rn.get(i).getYrj() >= z6.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz6 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz6 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz6 <= 0) {
                            koorXz6 = z6.getXz();
                            koorYz6 = z6.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z6.setXz(15500);
                            score += 10;
                            hpz6 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z7.getXz() && rn.get(i).getYrj() <= z7.getYz() + 25 && rn.get(i).getYrj() >= z7.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz7 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz7 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz7 <= 0) {
                            koorXz7 = z7.getXz();
                            koorYz7 = z7.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z.setXz(15500);
                            score += 10;
                            hpz7 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z8.getXz() && rn.get(i).getYrj() <= z8.getYz() + 25 && rn.get(i).getYrj() >= z8.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz8 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz8 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz8 <= 0) {
                            koorXz8 = z8.getXz();
                            koorYz8 = z8.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z8.setXz(15500);
                            score += 10;
                            hpz8 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                } else if (rn.get(i).getXrj() >= z9.getXz() && rn.get(i).getYrj() <= z9.getYz() + 25 && rn.get(i).getYrj() >= z9.getYz() - 25) {
                    rn.get(i).setIdle(rnattack, 6);
                    String bip = "src/assets/sound/tinju.wav";
                    SoundFile pm = new SoundFile(bip);
                    pm.PlayMusicSingle();
                    rn.get(i).bergerak(false, true, false, false);
                    hpz9 -= 20;
                    rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    if (rn.get(i).getHpr() >= 0) {
                        rn.get(i).setHpr(rn.get(i).getHpr() - 15);
                    }
                    if (hpz9 <= 0 || rn.get(i).getHpr() <= 0) {
                        if (hpz9 <= 0) {
                            koorXz9 = z9.getXz();
                            koorYz9 = z9.getYz();
                            // kalau 0 dihilangkan dan player dapet gold
                            z9.setXz(15500);
                            score += 10;
                            hpz9 = 0;
                        } else {
                            rn.get(i).setHpr(0);
                            rn.remove(i);
                        }
                    }
                }
            }
        }

        // announcement waktu enemy sudah dibunuh
        if (hprw <= 0) {
            // koordinat kill enemy
            int xKillEnemy = koorXrw;
            int yKillEnemy = koorYrw;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hprw2 <= 0) {
            // koordinat kill enemy
            int xKillEnemy = koorXrw2;
            int yKillEnemy = koorYrw2;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hprw3 <= 0) {
            // koordinat kill enemy
            int xKillEnemy = koorXrw3;
            int yKillEnemy = koorYrw3;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hprw4 <= 0) {
            // koordinat kill enemy
            int xKillEnemy = koorXrw4;
            int yKillEnemy = koorYrw4;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hprw5 <= 0) {
            // koordinat kill enemy
            int xKillEnemy = koorXrw5;
            int yKillEnemy = koorYrw5;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpfr <= 0) {
            int xKillEnemy = koorXfr;
            int yKillEnemy = koorYfr;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpfr2 <= 0) {
            int xKillEnemy = koorXfr2;
            int yKillEnemy = koorYfr2;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpfr3 <= 0) {
            int xKillEnemy = koorXfr3;
            int yKillEnemy = koorYfr3;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz <= 0) {
            int xKillEnemy = koorXz;
            int yKillEnemy = koorYz;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz1 <= 0) {
            int xKillEnemy = koorXz1;
            int yKillEnemy = koorYz1;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz2 <= 0) {
            int xKillEnemy = koorXz2;
            int yKillEnemy = koorYz2;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz2 <= 0) {
            int xKillEnemy = koorXz2;
            int yKillEnemy = koorYz2;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz3 <= 0) {
            int xKillEnemy = koorXz3;
            int yKillEnemy = koorYz3;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz4 <= 0) {
            int xKillEnemy = koorXz4;
            int yKillEnemy = koorYz4;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz5 <= 0) {
            int xKillEnemy = koorXz5;
            int yKillEnemy = koorYz5;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz6 <= 0) {
            int xKillEnemy = koorXz6;
            int yKillEnemy = koorYz6;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz7 <= 0) {
            int xKillEnemy = koorXz7;
            int yKillEnemy = koorYz7;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz8 <= 0) {
            int xKillEnemy = koorXz8;
            int yKillEnemy = koorYz8;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        } else if (hpz9 <= 0) {
            int xKillEnemy = koorXz9;
            int yKillEnemy = koorYz9;
            text("(Gold+10)", xKillEnemy, yKillEnemy);
        }

        
        // cek apakah score sebelumnya > score sekarang
        highScoreManager.updateHighScore(score);

        // tampilkan highscore
        text("High Score: " + highScoreManager.getHighScore(), 300, 50);

        // muncul button dan tulisan
        fill(255, 255, 255);
        rect(dragon_fight.getX(), dragon_fight.getY(), dragon_fight.getWidth(), dragon_fight.getHeight());

        fill(0, 0, 0);
        text("Dragon Fight", (dragon_fight.getX() + dragon_fight.getWidth() / 2) - 78, (dragon_fight.getY() + dragon_fight.getHeight() / 2) + 5);

        // untuk mengenali sensor mouse apakah sudah di button
        sensor();

        // mengubah bg saat dragon_fight
        if (createNewWindow) {
            pm.stop();
            String[] dragonF = {"dragonF"};
            PApplet.runSketch(dragonF, new DragonFight());
            createNewWindow = false;
        }
        
        // game over
        if (hp <= 0) {
            
            pm.stop();
            String bip = "src/assets/sound/Lose.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusicSingle();
            image(bgLose, 0, 0);
            // koordinat gold
            xG = 100;
            yG = 50;
            fill(255);
            text("Score: " + score, xG, yG);
            // tampilkan highscore
            text("High Score: " + highScoreManager.getHighScore(), 300, 50);
            fill(0);
            
            tembak = false;
            tembakPanah = false;
            knOut = false;
            rnOut = false;
            vamOut = false;

            // menghilangkan enemy
            fr.setXfr(10000);
            fr2.setXfr(10000);
            fr3.setXfr(10000);
            rw.setXrw(10000);
            rw2.setXrw(10000);
            rw3.setXrw(10000);
            rw4.setXrw(10000);
            rw5.setXrw(10000);
            z.setXz(10000);
            z1.setXz(10000);
            z2.setXz(10000);
            z3.setXz(10000);
            z4.setXz(10000);
            z5.setXz(10000);
            z6.setXz(10000);
            z7.setXz(10000);
            z8.setXz(10000);
            z9.setXz(10000);

            // hp enemy
            hpfr = 500;
            hpfr2 = 500;
            hpfr3 = 500;
            hprw = 800;
            hprw2 = 800;
            hprw3 = 800;
            hprw4 = 800;
            hprw5 = 800;
            hpz = 1000;
            hpz1 = 1000;
            hpz2 = 1000;
            hpz3 = 1000;
            hpz4 = 1000;
            hpz5 = 1000;
            hpz6 = 1000;
            hpz7 = 1000;
            hpz8 = 1000;
            hpz9 = 1000;

            int xGO = 640;
            int yGO = 360;

//            text("GAME OVER! You Lose...", xGO, yGO);
        } else if (hpfr <= 0 && hpfr2 <= 0 && hpfr3 <= 0) {
            // hp enemy
            fr.setXfr(-10000);
            fr2.setXfr(-10000);
            fr3.setXfr(-10000);

            // hp enemy
            hpfr = 500;
            hpfr2 = 500;
            hpfr3 = 500;
            hprw = 800;
            hprw2 = 800;
            hprw3 = 800;
            hprw4 = 800;
            hprw5 = 800;
            hpz = 1000;
            hpz1 = 1000;
            hpz2 = 1000;
            hpz3 = 1000;
            hpz4 = 1000;
            hpz5 = 1000;
            hpz6 = 1000;
            hpz7 = 1000;
            hpz8 = 1000;
            hpz9 = 1000;

            int xGO = 640;
            int yGO = 360;
            text("Wave +1", xGO, yGO);
            wave++;
            hp += 200;
        } else if (hprw <= 0 && hprw2 <= 0 && hprw3 <= 0 && hprw4 <= 0 && hprw5 <= 0) {
            // hp enemy
            rw.setXrw(-10000);
            rw2.setXrw(-10000);
            rw3.setXrw(-10000);
            rw4.setXrw(-10000);
            rw5.setXrw(-10000);

            // hp enemy
            hpfr = 500;
            hpfr2 = 500;
            hpfr3 = 500;
            hprw = 800;
            hprw2 = 800;
            hprw3 = 800;
            hprw4 = 800;
            hprw5 = 800;
            hpz = 1000;
            hpz1 = 1000;
            hpz2 = 1000;
            hpz3 = 1000;
            hpz4 = 1000;
            hpz5 = 1000;
            hpz6 = 1000;
            hpz7 = 1000;
            hpz8 = 1000;
            hpz9 = 1000;

            int xGO = 640;
            int yGO = 360;
            text("Wave +1", xGO, yGO);
            wave++;
            hp += 400;
        } else if (hpz <= 0 && hpz1 <= 0 && hpz2 <= 0 && hpz3 <= 0 && hpz4 <= 0 && hpz5 <= 0 && hpz6 <= 0 && hpz7 <= 0 && hpz8 <= 0 && hpz9 <= 0) {
            pm.stop();
            String bip = "src/assets/sound/Win.wav";
            SoundFile pm = new SoundFile(bip);
            image(bgWin, 0, 0);
            // koordinat gold
            xG = 100;
            yG = 50;
            fill(255);
            text("Score: " + score, xG, yG);
            // tampilkan highscore
            text("High Score: " + highScoreManager.getHighScore(), 300, 50);
            fill(0);
            // hp enemy
            z.setXz(-10000);
            z1.setXz(-10000);
            z2.setXz(-10000);
            z3.setXz(-10000);
            z4.setXz(-10000);
            z5.setXz(-10000);
            z6.setXz(-10000);
            z7.setXz(-10000);
            z8.setXz(-10000);
            z9.setXz(-10000);

            // hp enemy
            hpfr = 500;
            hpfr2 = 500;
            hpfr3 = 500;
            hprw = 800;
            hprw2 = 800;
            hprw3 = 800;
            hprw4 = 800;
            hprw5 = 800;
            hpz = 1000;
            hpz1 = 1000;
            hpz2 = 1000;
            hpz3 = 1000;
            hpz4 = 1000;
            hpz5 = 1000;
            hpz6 = 1000;
            hpz7 = 1000;
            hpz8 = 1000;
            hpz9 = 1000;

            int xGO = 640;
            int yGO = 360;
        }

        if (wave == 4) {
            exit();
        }
//
//        // cek apakah score sebelumnya > score sekarang
//        highScoreManager.updateHighScore(score);
//
//        // tampilkan highscore
//        text("High Score: " + highScoreManager.getHighScore(), 300, 50);
//
//        // muncul button dan tulisan
//        fill(255, 255, 255);
//        rect(dragon_fight.getX(), dragon_fight.getY(), dragon_fight.getWidth(), dragon_fight.getHeight());
//
//        fill(0, 0, 0);
//        text("Dragon Fight", (dragon_fight.getX() + dragon_fight.getWidth() / 2) - 78, (dragon_fight.getY() + dragon_fight.getHeight() / 2) + 5);
//
//        // untuk mengenali sensor mouse apakah sudah di button
//        sensor();
//
//        // mengubah bg saat dragon_fight
//        if (createNewWindow) {
//            pm.stop();
//            String[] dragonF = {"dragonF"};
//            PApplet.runSketch(dragonF, new DragonFight());
//            createNewWindow = false;
//        }

        f++;
//        if (hp <= 0) {
//            pm.stop();
//            String bip = "src/assets/sound/Lose.wav";
//            SoundFile pm = new SoundFile(bip);
//            pm.PlayMusicSingle();
//            image(bgLose, 0, 0);
//            // koordinat gold
//            xG = 100;
//            yG = 50;
//            fill(255);
//            text("Score: " + score, xG, yG);
//            // tampilkan highscore
//            text("High Score: " + highScoreManager.getHighScore(), 300, 50);
//            fill(0);
//        }
//        if (hpz <= 0 && hpz1 <= 0 && hpz2 <= 0 && hpz3 <= 0 && hpz4 <= 0 && hpz5 <= 0 && hpz6 <= 0 && hpz7 <= 0 && hpz8 <= 0 && hpz9 <= 0) {
//            
//            pm.stop();
//            String bip = "src/assets/sound/Win.wav";
//            SoundFile pm = new SoundFile(bip);
//            image(bgWin, 0, 0);
//            // koordinat gold
//            xG = 100;
//            yG = 50;
//            fill(255);
//            text("Score: " + score, xG, yG);
//            // tampilkan highscore
//            text("High Score: " + highScoreManager.getHighScore(), 300, 50);
//            fill(0);
//        }
    }

    public void keyPressed() {
        // pencet b untuk mengeluarkan bomb dari bomber
        if (key == 'b') {
            tembak = true;
            // suara saat dipencet
            String bip = "src/assets/sound/tembakbom.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusicSingle();
        } else if (key == 'p') {
            tembakPanah = true;
            String bip = "src/assets/sound/lepaspanah.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusicSingle();
        } else if (key == 'v') {
            vamOut = true;
            String bip = "src/assets/sound/vampiresound.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusicSingle();
        } else if (key == 'k') {
            knOut = true;
        } else if (key == 'r') {
            rnOut = true;
            String bip = "src/assets/sound/lari.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusic();
        }
    }

    public void keyRelease() {
        // lepas b untuk berhenti mengeluarkan bomb dari bomber
        if (key == 'b') {
            tembak = false;
        } else if (key == 'p') {
            tembakPanah = false;
        } else if (key == 'v') {
            vamOut = false;
        } else if (key == 'k') {
            knOut = false;
        } else if (key == 'r') {
            rnOut = false;
        }
    }

    public void mousePressed() {
        if (start_dragon_fight) {
            createNewWindow = true;
            start_dragon_fight = false;
        }
    }

    public void sensor() {
        if (cekButton(dragon_fight.getX(), dragon_fight.getY(), dragon_fight.getWidth(), dragon_fight.getHeight())) {
            start_dragon_fight = true;
        } else {
            start_dragon_fight = false;
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
