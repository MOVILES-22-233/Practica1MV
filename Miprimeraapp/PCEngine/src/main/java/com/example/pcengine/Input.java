package com.example.pcengine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Input implements com.example.engine.Input, MouseListener {
    private ArrayList<TouchEvent> events;

    public Input() {
        super();
        events = new ArrayList<TouchEvent>();
    }

    @Override
    public ArrayList<TouchEvent> getTouchEvents() {
        return events;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

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
