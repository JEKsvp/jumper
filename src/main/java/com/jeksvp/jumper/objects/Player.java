package com.jeksvp.jumper.objects;

import com.jeksvp.jumper.engine.GameObject;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Player extends GameObject {

    private static final int JUMP_HEIGHT = 10;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.startY = y;
        this.min = startY - JUMP_HEIGHT;
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
