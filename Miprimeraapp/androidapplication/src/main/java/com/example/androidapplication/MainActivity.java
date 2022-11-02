package com.example.androidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import com.example.androidengine.Engine;
import com.example.nonograma.Logic;

public class MainActivity extends AppCompatActivity {
    protected MySurfaceView renderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        renderView = new MySurfaceView(this);
        setContentView(renderView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        renderView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        renderView.pause();
    }

    class MySurfaceView extends SurfaceView implements Runnable {
        SurfaceHolder holder;
        Thread renderThread;
        volatile boolean running = false;
        private Logic logic;
        private Engine engine;
        int WIN_WIDTH;
        int WIN_HEIGHT;

        public MySurfaceView(Context context) {
            super(context);
            holder = getHolder();
            WIN_WIDTH = context.getResources().getDisplayMetrics().widthPixels;
            WIN_HEIGHT = context.getResources().getDisplayMetrics().heightPixels;
            engine = new Engine(context, WIN_WIDTH, WIN_HEIGHT);
            //setOnTouchListener((OnTouchListener)engine.getInput());
            logic = new Logic(engine, WIN_WIDTH, WIN_HEIGHT);
        }

        public void resume() {
            if (!running) {
                running = true;
                renderThread = new Thread(this);
                renderThread.start();
            }
        }

        public void pause() {
            if (running) {
                running =  false;
                while (true) {
                    try {
                        renderThread.join();
                        renderThread = null;
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void run() {
            if (renderThread != Thread.currentThread()) {
                throw new RuntimeException("run() should not be called directly");
            }

            // Espera activa
            while(running && getWidth() == 0);

            long lastFrameTime = System.nanoTime();

            // Bucle principal.
            while(running) {
                // deltaTime
                long currentTime = System.nanoTime();
                long nanoElapsedTime = currentTime - lastFrameTime;
                lastFrameTime = currentTime;

                double deltaTime = (double)nanoElapsedTime / 1.0E9;

                // Se maneja el input y el update del juego
                logic.handleInput();
                logic.update(deltaTime);

                // Pintamos el frame
                while (!holder.getSurface().isValid());

                Canvas canvas = holder.lockCanvas();
                engine.getGraphics().setCanvas(canvas);
                engine.getGraphics().clear(new com.example.engine.Engine.Color(255, 255, 255));
                logic.render();
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
