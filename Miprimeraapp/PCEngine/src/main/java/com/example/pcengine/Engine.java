package com.example.pcengine;

import com.example.engine.Audio;
import com.example.engine.Graphics;
import com.example.engine.State;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JFrame;


public class Engine implements com.example.engine.Engine {
    private com.example.pcengine.Graphics graphics;
    private com.example.pcengine.Audio audio;
    private Input input;
    private com.example.pcengine.State state;

    private MyWindow myWin;
    private BufferStrategy bufferStrategy;

    private int WIDTH, HEIGHT;

    public Engine(int win_width, int win_height) {
        super();
        WIDTH = win_width;
        HEIGHT = win_height;

        input = new Input();

        myWin = new MyWindow("Nonograma", WIDTH, HEIGHT, input);
        bufferStrategy = myWin.getBufferStrategy();

        graphics = new com.example.pcengine.Graphics(myWin, this);
        audio = new com.example.pcengine.Audio();
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public State getState() {
        return state;
    }

    public InputStream readInputStream(String filename) throws FileNotFoundException {
        return new FileInputStream(filename);
    }

    public class MyWindow extends JFrame {
        public MyWindow(String name, int width, int height, Input listener) {
            super(name);
            setSize(width, height);
            setLayout(new java.awt.GridLayout(1, 1));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            getContentPane().setBackground(java.awt.Color.WHITE);
            this.addMouseListener(listener);
        }
    }
}
