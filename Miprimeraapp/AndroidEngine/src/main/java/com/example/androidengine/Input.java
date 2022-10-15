package com.example.androidengine;

import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Input implements com.example.engine.Input, View.OnTouchListener {
    ArrayList<TouchEvent> events;

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
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
