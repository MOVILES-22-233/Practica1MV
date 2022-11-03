package com.example.pcengine;

import com.example.engine.Engine;

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
    public void addEvent(TouchEvent e) {
        events.add(e);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int id = events.size();
        TouchEvent.Type type = TouchEvent.Type.PRESS;
        Engine.Vector2 pos = new Engine.Vector2(mouseEvent.getX(), mouseEvent.getY());

        TouchEvent event = new TouchEvent(type, pos, id);
        addEvent(event);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        // nada
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        // nada
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        // nada
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        // nada
    }
}
