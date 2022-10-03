package com.example.myfirstjava;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFirstPCApp extends JFrame implements MouseListener {
    Button button;
    TextField field;

    public MyFirstPCApp()
    {
        super("Hello World");
        initComponents();
        setSize(480,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComponents()
    {
        field = new TextField(5);
        button= new Button("Send");

        setLayout(new FlowLayout());
        add(button);
        add(field);

        button.addMouseListener(this);
    }

    public static void main(String[] args) {
        //new MyFirstPCApp().setVisible(true);
        JFrame renderView = new JFrame("Mi aplicación");

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
            System.err.println("No pude crear la BufferStrategy");
            return;
        }
        else {
            // En "modo debug" podríamos querer escribir esto.
            //System.out.println("BufferStrategy tras " + (100 - intentos) + " intentos.");
        }

        MyScene scene = new MyScene();

        MyRenderClass render = new MyRenderClass(renderView);
        scene.init(render);
        render.setScene(scene);
        render.resume();
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JOptionPane.showMessageDialog(this, field.getText());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}