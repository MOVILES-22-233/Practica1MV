package com.example.engine;

import java.util.ArrayList;

public interface Input {
    ArrayList<TouchEvent> getTouchEvents();

    public void addEvent(TouchEvent e);

    public class TouchEvent {
        public enum Type { PRESS, RELEASE, DRAG };

        public Type type;
        public Engine.Vector2 pos;
        public int id;

        public TouchEvent(Type type, Engine.Vector2 pos, int id) {
            this.type = type;
            this.pos = pos;
            this.id = id;
        }
    }

}
