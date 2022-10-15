package com.example.engine;

import java.util.ArrayList;

public interface Input {
    ArrayList<TouchEvent> getTouchEvents();

    class TouchEvent {
        enum Type { PRESS, RELEASE, DRAG };
        Engine.Vector2 pos;
        int id;
    }

}
