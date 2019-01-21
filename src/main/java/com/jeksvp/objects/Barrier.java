package com.jeksvp.objects;

import com.jeksvp.engine.GameObject;
import com.jeksvp.engine.GameWorld;
import javafx.scene.input.KeyEvent;

public class Barrier extends GameObject {

    private int canvasWidth;

    public Barrier(int x, int y, int width, int height, int canvasWidth) {
        super(x, y, width, height);
        this.canvasWidth = canvasWidth;
    }


    @Override
    public void onUpdate() {
        if (getX() < 0) {
            setX(canvasWidth);
        }
        setX(getX() - 1);
    }

    @Override
    public void onKeyPressed(KeyEvent event) {

    }
}
