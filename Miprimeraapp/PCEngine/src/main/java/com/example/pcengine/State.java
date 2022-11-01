package com.example.pcengine;

import com.example.engine.Graphics;

import java.awt.image.BufferStrategy;
import java.nio.Buffer;

import javax.swing.JFrame;

public class State {// implements com.example.engine.State, Runnable {
    /*private Thread renderThread;
    private boolean running;

    private JFrame myView;
    private BufferStrategy bufferStrategy;

    public State(JFrame myView_) {
        myView = myView_;
        bufferStrategy = myView.getBufferStrategy();
    }

    @Override
    public void update(double deltaTime) {
        // Bucle principal
        long lastFrameTime = System.nanoTime();
        while(true) {
            long currentTime = System.nanoTime();
            long nanoDelta = currentTime - lastFrameTime;
            lastFrameTime = currentTime;
            logic.handleInput();
            logic.update((double) nanoDelta / 1.0E9);

            // Render single frame
            do {
                do {
                    graphics = bufferStrategy.getDrawGraphics();
                    engine.getGraphics().setGraphics(graphics);
                    logic.render();
                    graphics.dispose();
                    // Repeat the rendering if the drawing buffer contents were restored
                } while (bufferStrategy.contentsRestored());

                // Display the buffer
                bufferStrategy.show();
                // Repeat the rendering if the drawing buffer was lost
            } while(bufferStrategy.contentsLost());
        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void run() {
        if (renderThread != Thread.currentThread()) {
            // Evita que cualquiera que no sea esta clase llame a este Runnable en un Thread
            // Programación defensiva
            throw new RuntimeException("run() should not be called directly");
        }

        // Si el Thread se pone en marcha
        // muy rápido, la vista podría todavía no estar inicializada.
        while(running && myView.getWidth() == 0);
        // Espera activa. Sería más elegante al menos dormir un poco.

        long lastFrameTime = System.nanoTime();

        long informePrevio = lastFrameTime; // Informes de FPS
        int frames = 0;

        // Bucle de juego principal.
        while(running) {
            long currentTime = System.nanoTime();
            long nanoElapsedTime = currentTime - lastFrameTime;
            lastFrameTime = currentTime;

            // Informe de FPS
            double elapsedTime = (double) nanoElapsedTime / 1.0E9;
            update(elapsedTime);
            if (currentTime - informePrevio > 1000000000l) {
                long fps = frames * 1000000000l / (currentTime - informePrevio);
                System.out.println("" + fps + " fps");
                frames = 0;
                informePrevio = currentTime;
            }
            ++frames;

            // Pintamos el frame
            do {
                do {
                    java.awt.Graphics graphics = bufferStrategy.getDrawGraphics();
                    try {

                    }
                    finally {
                        graphics.dispose(); //Elimina el contexto gráfico y libera recursos del sistema realacionado
                    }
                } while(bufferStrategy.contentsRestored());
                bufferStrategy.show();
            } while(bufferStrategy.contentsLost());
    }*/
}
