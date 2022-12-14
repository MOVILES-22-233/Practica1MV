package com.example.myfirstjava;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferStrategy;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyRenderClass implements Runnable {
    private JFrame myView;
    private BufferStrategy bufferStrategy;
    private Graphics2D graphics2D;
    private Font javaFont;

    private Thread renderThread;

    private boolean running;

    private MyScene scene;

    public MyRenderClass(JFrame myView){
        this.myView = myView;
        this.myView.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                //Component c = (Component)evt.getSource();
                System.out.println("componentResized: "+evt.getSource());
                graphics2D.dispose();

                bufferStrategy.show();
                graphics2D = (Graphics2D) bufferStrategy.getDrawGraphics();
            }
        });

        this.bufferStrategy = this.myView.getBufferStrategy();
        this.graphics2D = (Graphics2D) bufferStrategy.getDrawGraphics();

        try {
            InputStream is = new FileInputStream("data/Montserrat-Regular.otf");
            Font f = Font.createFont(Font.TRUETYPE_FONT, is);
            javaFont = f.deriveFont(Font.BOLD, 40);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        graphics2D.setFont(javaFont);

    }

    public int getWidth(){
        return this.myView.getWidth();
    }

    public int getHeight(){
        return this.myView.getHeight();
    }

    @Override
    public void run() {
        if (renderThread != Thread.currentThread()) {
            // Evita que cualquiera que no sea esta clase llame a este Runnable en un Thread
            // Programaci??n defensiva
            throw new RuntimeException("run() should not be called directly");
        }

        // Si el Thread se pone en marcha
        // muy r??pido, la vista podr??a todav??a no estar inicializada.
        while(this.running && this.myView.getWidth() == 0);
        // Espera activa. Ser??a m??s elegante al menos dormir un poco.

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
            this.update(elapsedTime);
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
                    Graphics graphics = this.bufferStrategy.getDrawGraphics();
                    try {
                        this.render();
                    }
                    finally {
                        graphics.dispose(); //Elimina el contexto gr??fico y libera recursos del sistema realacionado
                    }
                } while(this.bufferStrategy.contentsRestored());
                this.bufferStrategy.show();
            } while(this.bufferStrategy.contentsLost());

            /*
            // Posibilidad: cedemos algo de tiempo. Es una medida conflictiva...
            try { Thread.sleep(1); } catch(Exception e) {}
            */
        }
    }

    protected void update(double deltaTime) {
        this.scene.update(deltaTime);
    }

    public void setScene(MyScene scene) {
        this.scene = scene;
    }

    protected void renderCircle(float x, float y, float r){
        this.graphics2D.setColor(Color.red);
        this.graphics2D.fillOval((int)x, (int)y, (int)r*2, (int)r*2);
        this.graphics2D.setPaintMode();
    }

    protected void render() {
        // "Borramos" el fondo.
        this.graphics2D.setColor(Color.BLUE);
        this.graphics2D.fillRect(0,0, this.getWidth(), this.getHeight());
        // Pintamos la escena
        this.scene.render();
    }

    protected void drawText(int x, int y, String text) {
        this.graphics2D.setColor(Color.orange);
        this.graphics2D.drawString(text, x, y);
        this.graphics2D.setPaintMode();
    }

    protected void drawImage(int x, int y, String path){
        Image img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(img, x, y, null);
    }

    public void resume() {
        if (!this.running) {
            // Solo hacemos algo si no nos est??bamos ejecutando ya
            // (programaci??n defensiva)
            this.running = true;
            // Lanzamos la ejecuci??n de nuestro m??todo run() en un nuevo Thread.
            this.renderThread = new Thread(this);
            this.renderThread.start();
        }
    }

    public void pause() {
        if (this.running) {
            this.running = false;
            while (true) {
                try {
                    this.renderThread.join();
                    this.renderThread = null;
                    break;
                } catch (InterruptedException ie) {
                    // Esto no deber??a ocurrir nunca...
                }
            }
        }
    }
}
