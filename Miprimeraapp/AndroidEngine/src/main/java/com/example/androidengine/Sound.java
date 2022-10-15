package com.example.androidengine;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;

import java.io.IOException;

public class Sound implements com.example.engine.Sound {
    private MediaPlayer mPlayer;

    public Sound(String filename, AssetManager assetManager) {
        super();
        try {
            AssetFileDescriptor afd = assetManager.openFd(filename);
            mPlayer.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(), afd.getLength());
            mPlayer.prepare();
            mPlayer.setLooping(true);
        }
        catch (IOException e) {
            System.err.println("Couldn't load file " + filename);
            e.printStackTrace();
        }
    }

    @Override
    public void play() {
        mPlayer.start();
    }

    @Override
    public void stop() {
        if (mPlayer.isPlaying())
            mPlayer.stop();
    }
}
