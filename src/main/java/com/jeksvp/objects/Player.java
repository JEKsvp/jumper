package com.jeksvp.objects;

import com.jeksvp.engine.GameObject;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;


public class Player extends GameObject {

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.startY = y;
        this.min = startY + 10;
    }

    public Player(int x, int y, int width, int height, boolean isPhysical) {
        super(x, y, width, height, isPhysical);
        this.startY = y;
        this.min = startY - 10;
    }

    private boolean isJumping = false;
    private Direction direction = Direction.UP;
    private int startY;
    private int min;

    @Override
    public void onUpdate() {
        if (!getIntersections().isEmpty()) {
            System.exit(0);
        }
        if (isJumping) {
            if (direction == Direction.UP) {
                setY(getY() - 1);
            } else if (direction == Direction.DOWN) {
                setY(getY() + 1);
            }
            if (getY() <= min) {
                direction = Direction.DOWN;
            }
            if (getY() >= startY) {
                isJumping = false;
                direction = Direction.UP;
            }
        }
    }

    @Override
    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.CONTROL) {
            jump();
        }
    }

    private void jump() {
        isJumping = true;
    }

    private enum Direction {
        UP,
        DOWN
    }
}
