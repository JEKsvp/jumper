package com.jeksvp.objects;

import com.jeksvp.engine.GameObject;

public class Player extends GameObject{

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Player(int width, int height, int x, int y, boolean isPhysical) {
        super(width, height, x, y, isPhysical);
    }

    @Override
    public void onUpdate() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() + 1);
    }
}
