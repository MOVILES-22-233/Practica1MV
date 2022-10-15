package com.example.androidengine;

import android.content.res.AssetManager;

import com.example.engine.Sound;

import java.util.Vector;

public class Audio implements com.example.engine.Audio {
    private Vector<Sound> sounds;
    private Vector<String> ids;
    private int size = 100;

    private AssetManager assetManager;

    public Audio(AssetManager assetManager_) {
        super();
        assetManager = assetManager_;
        sounds = new Vector<Sound>(size);
        ids = new Vector<String>(size);
    }

    @Override
    public Sound newSound(String filename) {
        Sound mPlayer = new com.example.androidengine.Sound(filename, assetManager);
        sounds.add(mPlayer);
        ids.add(filename);

        return mPlayer;
    }

    @Override
    public void playSound(String id) {
        int n = ids.indexOf(id);
        sounds.get(n).play();
    }

    @Override
    public void stopSound(String id) {
        int n = ids.indexOf(id);
        sounds.get(n).stop();
    }
}
