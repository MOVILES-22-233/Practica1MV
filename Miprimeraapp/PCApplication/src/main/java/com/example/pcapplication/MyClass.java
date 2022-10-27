package com.example.pcapplication;

import com.example.nonograma.Logic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        //new MyFirstPCApp().setVisible(true);
        JFrame renderView = new JFrame("NonoGram");

        renderView.setSize(600, 400);
        renderView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderView.setIgnoreRepaint(true);

        renderView.setVisible(true);
        // Intentamos crear el buffer strategy con 2 buffers.
        int intentos = 100;
        while(intentos-- > 0) {
            try {
                renderView.createBufferStrategy(2);
                break;
            }
            catch(Exception e) {
            }
        } // while pidiendo la creación de la buffeStrategy
        if (intentos == 0) {
            System.err.println("Couldnt create BufferStrategy");
            return;
        }
        else {
            // En "modo debug" podríamos querer escribir esto.
            //System.out.println("BufferStrategy tras " + (100 - intentos) + " intentos.");
        }

        MyScene scene = new MyScene();

        Engine engine = new Engine(WIN_WIDTH, WIN_HEIGHT);
        logic = new Logic(engine);

        MyRenderClass render = new MyRenderClass(renderView);
        scene.init(render);
        render.setScene(scene);
        render.resume();
    }
}
