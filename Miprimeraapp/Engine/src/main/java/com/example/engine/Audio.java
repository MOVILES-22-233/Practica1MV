package com.example.engine;

public interface Audio {
    Sound newSound(String filename);
    void playSound(String id);
    void stopSound(String id);
}
