/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplegame;

import java.util.ArrayList;
import java.util.Random;
import processing.core.*;

/**
 *
 * @author Hanvy
 */
public class DragonFight extends PApplet {

    // default screen
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int FPS = 60;

    // background dragon_fight
    PImage bgdragonfight;

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

    // naga
    ArrayList<Dragon> drag = new ArrayList<>();
    PImage[] naga;

    // api
    ArrayList<Fire> fire = new ArrayList<>();
    PImage[] api;

    // player
    PImage bg;
    Knight k;
    PImage bg2;
    Vampire v;
    Bomber b;
    Peluru p;
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
    RunningManJalan rj;

    // enemy
    Dragon dr;
    Fire fi;

    int f = 0;
    int score = 0;
    int hp = 1000;
    int hpv = 80;
    int hpkn = 120;
    int hprn = 70;
    int hpdr = 5000;
    int level = 0;
    int wave = 1;
    int koorXdr = 0;
    int koorYdr = 0;
    int ctrnaga = 0;

    // boolean untuk button lawan dragon
    private boolean start_dragon_fight = false;
    private boolean createNewWindow = false;
    PApplet newWindow;

    // boolean untuk posisi tetap
    private boolean idle = true;

    // boolean untuk posisi jalan
    private boolean running = false;

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

    // boolean untuk mengeluarkan naga
    private boolean ngOut = false;

    // boolean untuk mengeluarkan api
    private boolean fireOut = false;

    // button
    private Button dragon_fight = new Button(800, 100, 40, 120);

    int riderFlapHeight;
    int gravity;
    int wingAnimationSpeed;
    int currentWingImageIndex;

    public static void main(String[] args) {
//        // TODO code application logic here
//        PApplet.main("simplegame.DragonFight");
    }

    public void settings() {
        // setting default screen
        size(WIDTH, HEIGHT); // 1280x720
    }

    String bip = "src/assets/sound/dragonbattle.wav";
    public SoundFile pm = new SoundFile(bip);

    // sound system
    public void setup() {
        // font setting
        PFont font = createFont("Courier New", 22);
        textFont(font);
        fill(0, 0, 0);

        // panggil musik
        pm.PlayMusic();

        PImage[] temp = new PImage[1];
        frameRate(FPS);

        // background
        bg2 = loadImage("src/assets/background/bg2.jpg");

        // panggil karakter
        // knight
        PImage[] fixedChar = new PImage[1];
        fixedChar[0] = loadImage("src/assets/player/knight4.png");
        k = new Knight(fixedChar, 55, 75, 780, 480, 278, 480);

        // runningman
        PImage[] fixedChar5 = new PImage[1];
        fixedChar5[0] = loadImage("src/assets/player/runningman7.png");
        r = new RunningMan(fixedChar5, 55, 75, 780, 480, 190, 475);

        // vampire
        PImage[] fixedChar2 = new PImage[1];
        fixedChar2[0] = loadImage("src/assets/player/vampire.png");
        v = new Vampire(fixedChar2, 90, 90, 780, 480, 350, 460, 80);

        // bomber
        PImage[] fixedChar3 = new PImage[1];
        fixedChar3[0] = loadImage("src/assets/player/bomber.png");
        b = new Bomber(fixedChar3, 90, 90, 780, 480, 260, 295);

        // bakcup
        // archer (masih salah)
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
        int random = rand.nextInt(280, 350);

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

        // panggil runningman
        runningman = new PImage[7];
        for (int m = 0; m < runningman.length; m++) {
            runningman[m] = loadImage("src/assets/player/runningman" + (m + 1) + ".png");
        }

        naga = new PImage[3];
        for (int m = 0; m < naga.length; m++) {
            naga[m] = loadImage("src/assets/enemy/flyingdragon" + (m + 1) + ".png");
        }
        dr = new Dragon(naga, 600, 300, 700, 340);

        api = new PImage[1];
        api[0] = loadImage("src/assets/fire/api.png");
        fi = new Fire(api, 400, 200, 700, 340);

        bgdragonfight = loadImage("src/assets/background/bg2.jpg");
    }

    public void draw() {
        // pergerakan enemy
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

        if (ngOut) {
            drag.add(new Dragon(naga, 600, 300, 700, 340));
            fireOut = true;

            ngOut = false;
        }

        if (fireOut) {
            if (ctrnaga % 30 == 0 && hp > 0) {
                fire.add(new Fire(api, 200, 80, 700, 500));
            }
        }

        // kalau dipencet r
        if (rnOut) {
            rn.add(new RunningManJalan(runningman, 45, 65, 100, 100, 300, 470, 70));
            rn.add(new RunningManJalan(runningman, 45, 65, 100, 100, 300, 530, 70));
            rn.add(new RunningManJalan(runningman, 45, 65, 100, 100, 300, 590, 70));

            rnOut = false;
        }

        // background
        background(bg2);

        // koordinat gold
        int xG = 100;
        int yG = 50;
        text("Gold: " + score, xG, yG);

        // koordinat level
        int xL = 300;
        int yL = 50;
        text("LV" + level, xL, yL);

        // koordinat HP castle
        int xHP = 600;
        int yHP = 50;
        text("HP: " + hp, xHP, yHP);

        // koordinat wave
        int xW = 600;
        int yW = 100;
        text("Wave " + wave, xW, yW);

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

        // enemy dragon
        for (int m = 0; m < drag.size(); m++) {
            drag.get(m).drawIdle(this, f);
        }

        // api
        for (int m = 0; m < fire.size(); m++) {
            fire.get(m).drawIdle(this, f);
            fire.get(m).bergerak(true);

            if (fire.get(m).getX() <= 400) {
                fire.remove(m);
                hp -= 50;
            }
        }

        // tampilin peluru
        for (int m = pel.size() - 1; m >= 0; m--) {
            if (hp < 0 || hpdr > 0) {
                pel.get(m).bergerak(true);
                pel.get(m).drawIdle(this, f);
            }

            if (pel.get(m).getX() >= dr.getXn() && pel.get(m).getY() <= dr.getYn() + 300 && pel.get(m).getY() >= dr.getYn() - 300) {
                pel.remove(m);
                hpdr -= 20;
                if (hpdr <= 0) {
                    koorXdr = dr.getXn();
                    koorYdr = dr.getYn();
                    dr.setXn(15500);
                    score += 1000;
                }
            }
        }

        // tampilin panah
        for (int m = pan.size() - 1; m >= 0; m--) {
            if (hp < 0 || hpdr > 0) {
                pan.get(m).bergerak(true);
                pan.get(m).drawIdle(this, f);
            }

            if (pan.get(m).getX() >= dr.getXn() && pan.get(m).getY() <= dr.getYn() + 300 && pan.get(m).getY() >= dr.getYn() - 300) {
                String bip = "src/assets/sound/kenapanah.wav";
                SoundFile pm = new SoundFile(bip);
                pm.PlayMusicSingle();
                pan.remove(m);
                hpdr -= 15;
                if (hpdr <= 0) {
                    koorXdr = dr.getXn();
                    koorYdr = dr.getYn();
                    dr.setXn(15500);
                    score += 1000;
                }
            }
        }

        // tampilin vampire
        for (int i = vam.size() - 1; i >= 0; i--) {
            vam.get(i).bergerak(true, false, false, false);
            vam.get(i).drawIdle(this, f);
            if (vam.get(i).getXv() >= dr.getXn() && vam.get(i).getYv() <= dr.getYn() + 300 && vam.get(i).getYv() >= dr.getYn() - 300) {
                // kalau sudah sampe, vampire ke kiri sampai enemy mati
                vam.get(i).bergerak(false, true, false, false);
                hpdr -= 25;
                vam.get(i).setHpv(vam.get(i).getHpv() - 50);
                if (vam.get(i).getHpv() >= 0) {
                    vam.get(i).setHpv(vam.get(i).getHpv() - 50);
                }
                if (hpdr <= 0 || vam.get(i).getHpv() <= 0) {
                    if (hpdr <= 0) {
                        vam.remove(i);
                        koorXdr = dr.getXn();
                        koorYdr = dr.getYn();
                        // kalau 0 dihilangkan dan player dapet gold
                        dr.setXn(15500);
                        score += 10;
                        hpdr = 0;
                    } else {
                        vam.get(i).setHpv(0);
                        vam.remove(i);
                    }
                }
            }
        }

        // tampilin knight
        for (int i = kn.size() - 1; i >= 0; i--) {
            kn.get(i).bergerak(true, false, false, false);
            kn.get(i).drawIdle(this, f);
            if (kn.get(i).getXkj() >= dr.getXn() && kn.get(i).getYkj() <= dr.getYn() + 300 && kn.get(i).getYkj() >= dr.getYn() - 300) {
                String bip = "src/assets/sound/perang.wav";
                SoundFile pm = new SoundFile(bip);
                pm.PlayMusic();
                // kalau sudah sampe, vampire ke kiri sampai enemy mati
                kn.get(i).bergerak(false, true, false, false);
                hpdr -= 20;
                kn.get(i).setHpk(kn.get(i).getHpk() - 50);
                if (kn.get(i).getHpk() >= 0) {
                    kn.get(i).setHpk(kn.get(i).getHpk() - 50);
                }
                if (hpdr <= 0 || kn.get(i).getHpk() <= 0) {
                    if (hpdr <= 0) {
                        koorXdr = dr.getXn();
                        koorYdr = dr.getYn();
                        // kalau 0 dihilangkan dan player dapet gold
                        dr.setXn(15500);
                        score += 10;
                        hpdr = 0;
                    } else {
                        kn.get(i).setHpk(0);
                        kn.remove(i);
                    }
                }
            }
        }

        // tampilin runningman
        for (int i = rn.size() - 1; i >= 0; i--) {
            rn.get(i).bergerak(true, false, false, false);
            rn.get(i).drawIdle(this, f);
            if (rn.get(i).getXrj() >= dr.getXn() && rn.get(i).getYrj() <= dr.getYn() + 300 && rn.get(i).getYrj() >= dr.getYn() - 300) {
                // kalau sudah sampe, vampire ke kiri sampai enemy mati
                String bip = "src/assets/sound/tinju.wav";
                SoundFile pm = new SoundFile(bip);
                pm.PlayMusicSingle();
                rn.get(i).bergerak(false, true, false, false);
                hpdr -= 15;
                rn.get(i).setHpr(rn.get(i).getHpr() - 50);
                if (rn.get(i).getHpr() >= 0) {
                    rn.get(i).setHpr(rn.get(i).getHpr() - 50);
                }
                if (hpdr <= 0 || rn.get(i).getHpr() <= 0) {
                    if (hpdr <= 0) {
                        koorXdr = dr.getXn();
                        koorYdr = dr.getYn();
                        // kalau 0 dihilangkan dan player dapet gold
                        dr.setXn(15500);
                        score += 10;
                        hpdr = 0;
                    } else {
                        rn.get(i).setHpr(0);
                        rn.remove(i);
                    }
                }
            }
        }

        // game over
        if (hp <= 0) {
            tembak = false;
            tembakPanah = false;
            knOut = false;
            rnOut = false;
            vamOut = false;
            ngOut = false;
            fireOut = false;

            // menghilangkan enemy
            // hp enemy
            int xGO = 640;
            int yGO = 360;
            text("GAME OVER! You Lose...", xGO, yGO);
        } else if (hpdr <= 0) {
            tembak = false;
            tembakPanah = false;
            knOut = false;
            rnOut = false;
            vamOut = false;
            ngOut = false;
            fireOut = false;

            // announcement waktu enemy sudah dibunuh
            int xEnemyKilled = 640;
            int yEnemyKilled = 360;
            text("(Gold+1000)", xEnemyKilled, yEnemyKilled);

            // hp enemy
            int xGO = 640;
            int yGO = 360;
            text("GAME OVER! You Win...", xGO, yGO);
        }

        // muncul button
        fill(255, 255, 255);
        rect(dragon_fight.getX(), dragon_fight.getY(), dragon_fight.getWidth(), dragon_fight.getHeight());

        fill(0, 0, 0);
        text("EXIT", (dragon_fight.getX() + dragon_fight.getWidth() / 2) - 27, (dragon_fight.getY() + dragon_fight.getHeight() / 2) + 5);

        // untuk mengenali sensor mouse apakah sudah di button
        sensor();

        // mengubah bg saat dragon_fight
        if (createNewWindow) {
            pm.stop();
            tembak = false;
            tembakPanah = false;
            knOut = false;
            rnOut = false;
            vamOut = false;
            ngOut = false;
            fireOut = false;
            createNewWindow = false;
            exit();
        }

        f++;
        ctrnaga++;
    }

    int ctr = 0;

    public void keyPressed() {
        // pencet b untuk mengeluarkan bomb dari bomber
        if (key == 'b') {
            tembak = true;
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
        } else if (key == 'k') {
            knOut = true;
        } else if (key == 'r') {
            rnOut = true;
            String bip = "src/assets/sound/lari.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusic();
        } else if (key == 'e') {
            ngOut = true;
            ctr++;
            String bip = "src/assets/sound/DragonRoar.wav";
            SoundFile pm = new SoundFile(bip);
            pm.PlayMusic();
            if (ctr > 1) {
                ngOut = false;
            }
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
        } else if (key == 'e') {
            ngOut = false;
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
