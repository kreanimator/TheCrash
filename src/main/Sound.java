package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[100];
    FloatControl fc;
    int volumeScale = 3;
    float volume;


    public Sound() {

        soundURL[0] = getClass().getResource("/resources/sounds/music/Dawn - slow - scary.wav");
        soundURL[1] = getClass().getResource("/resources/sounds/pickup.wav");
        soundURL[2] = getClass().getResource("/resources/sounds/door.wav");
        soundURL[3] = getClass().getResource("/resources/sounds/coin.wav");
        soundURL[4] = getClass().getResource("/resources/sounds/swing.wav");
        soundURL[5] = getClass().getResource("/resources/sounds/hitslime.wav");
        soundURL[6] = getClass().getResource("/resources/sounds/locker.wav");
        soundURL[7] = getClass().getResource("/resources/sounds/receivedamage.wav");
        soundURL[8] = getClass().getResource("/resources/sounds/levelup.wav");
        soundURL[9] = getClass().getResource("/resources/sounds/cursor.wav");
        soundURL[10] = getClass().getResource("/resources/sounds/pistolreload.wav");
        soundURL[11] = getClass().getResource("/resources/sounds/hppack.wav");
        soundURL[12] = getClass().getResource("/resources/sounds/pistol.wav");
        soundURL[13] = getClass().getResource("/resources/sounds/shotgun.wav");
        soundURL[14] = getClass().getResource("/resources/sounds/shotgunreload.wav");
        soundURL[15] = getClass().getResource("/resources/sounds/boxcrush.wav");
        soundURL[16] = getClass().getResource("/resources/sounds/monsterhurt.wav");
        soundURL[17] = getClass().getResource("/resources/sounds/hurt.wav");
        soundURL[18] = getClass().getResource("/resources/sounds/vase.wav");
        soundURL[19] = getClass().getResource("/resources/sounds/die.wav");
        soundURL[20] = getClass().getResource("/resources/sounds/insectdie.wav");
        soundURL[21] = getClass().getResource("/resources/sounds/mutantdie.wav");
        soundURL[22] = getClass().getResource("/resources/sounds/cave.wav");
        soundURL[23] = getClass().getResource("/resources/sounds/tent.wav");
        soundURL[24] = getClass().getResource("/resources/sounds/acid.wav");
        soundURL[25] = getClass().getResource("/resources/sounds/block.wav");
        soundURL[26] = getClass().getResource("/resources/sounds/parry.wav");
        soundURL[27] = getClass().getResource("/resources/sounds/bunker.wav");
        soundURL[28] = getClass().getResource("/resources/sounds/bunkerdoor.wav");
        soundURL[29] = getClass().getResource("/resources/sounds/rock.wav");
        soundURL[30] = getClass().getResource("/resources/sounds/bossfight.wav");
        soundURL[31] = getClass().getResource("/resources/sounds/background.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play() {

        clip.start();

    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop() {
        clip.stop();

    }

    public void checkVolume() {
        switch (volumeScale) {
            case 0 -> volume = -80f;
            case 1 -> volume = -20f;
            case 2 -> volume = -12f;
            case 3 -> volume = -6f;
            case 4 -> volume = 1f;
            case 5 -> volume = 6f;
        }
        fc.setValue(volume);

    }
}
