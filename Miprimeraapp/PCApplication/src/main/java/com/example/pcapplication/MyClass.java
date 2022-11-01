package com.example.pcapplication;

import com.example.nonograma.Logic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import com.example.pcengine.Engine;

public class MyClass extends JFrame {
    public static Logic logic;
    private static int WIN_WIDTH = 600, WIN_HEIGHT = 400;

    public MyClass() {
        super("NonoGram Desktop Application");
        setSize(480,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Engine engine = new Engine(WIN_WIDTH, WIN_HEIGHT);

        BufferStrategy bufferStrategy = engine.GetBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        engine.getGraphics().setGraphics(graphics);

        logic = new Logic(engine, WIN_WIDTH, WIN_HEIGHT);

        // BUCLE PRINCIPAL DEL JUEGO (TEMPORAL)
        long lastFrameTime = System.nanoTime();
        while(true) {
            long currentTime = System.nanoTime();
            long nanoDelta = currentTime - lastFrameTime;
            lastFrameTime = currentTime;
            //logic.handleInput();
            logic.update((double) nanoDelta / 1.0E9);

            // Render single frame
            do {
                do {
                    graphics = bufferStrategy.getDrawGraphics();
                    //engine.getGraphics().setGraphics(graphics);
                    logic.render();
                    graphics.dispose();
                    // Repeat the rendering if the drawing buffer contents were restored
                } while (bufferStrategy.contentsRestored());

                // Display the buffer
                bufferStrategy.show();
                // Repeat the rendering if the drawing buffer was lost
            } while(bufferStrategy.contentsLost());
        }

        /*MyRenderClass render = new MyRenderClass(renderView);
        scene.init(render);
        render.setScene(scene);
        render.resume();*/
    }
}
