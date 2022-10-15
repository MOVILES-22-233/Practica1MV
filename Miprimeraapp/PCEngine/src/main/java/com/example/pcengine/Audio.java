package com.example.pcengine;
import com.example.engine.Sound;

import java.util.Vector;

public class Audio implements com.example.engine.Audio {
    private Vector<Sound> sounds;
    private Vector<String> ids;
    private int size = 100;

    public Audio() {
        super();
        sounds = new Vector<Sound>(size);
        ids = new Vector<String>(size);
    }

    @Override
    public Sound newSound(String filename) {
        Sound clip = new com.example.pcengine.Sound(filename);
        sounds.add(clip);
        ids.add(filename);

        return clip;
    }

    public void playSound(String id) {
        int n = ids.indexOf(id);
        sounds.get(n).play();
    }

    public void stopSound(String id) {
        int n = ids.indexOf(id);
        sounds.get(n).stop();
    }
}
