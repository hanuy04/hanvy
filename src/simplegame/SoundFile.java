package simplegame;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author LENOVO
 */
public class SoundFile {

    String filepath;
    Clip clip;

    public SoundFile(String filepath) {
        this.filepath = filepath;
    }

    public void PlayMusic() {
        try {
            File musicpath = new File(filepath);
            if (musicpath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                Thread.sleep(100);

            } else {
                System.out.println("File doesn't exist.");
            }
        } catch (Exception e) {

        }
    }

    public void PlayMusicSingle() {
        try {
            File musicpath = new File(filepath);
            if (musicpath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                Thread.sleep(100);

            } else {
                System.out.println("File doesn't exist.");
            }
        } catch (Exception e) {

        }
    }

    public void stop() {
        clip.stop();
    }

}
