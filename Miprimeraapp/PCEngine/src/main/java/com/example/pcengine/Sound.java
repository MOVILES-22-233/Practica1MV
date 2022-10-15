package com.example.pcengine;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Sound implements com.example.engine.Sound {
    private Clip sound;

    public Sound(String filename) {
        try {
            sound = AudioSystem.getClip();
            try {
                sound.open(AudioSystem.getAudioInputStream(new File(filename)));
                sound.loop(Clip.LOOP_CONTINUOUSLY);
                sound.setFramePosition(0);
            } catch (Exception e) {
                System.err.println("Couldn't find file " + filename);
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            System.err.println("" + e);
            e.printStackTrace();
        }
    }

    @Override
    public void play() {
        sound.start();
    }

    @Override
    public void stop() {
        if (sound.isRunning())
            sound.stop();
    }
}
