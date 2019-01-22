package com.jeksvp.jumper;

import com.jeksvp.jumper.engine.Canvas;
import com.jeksvp.jumper.engine.GameWorld;
import com.jeksvp.jumper.objects.Barrier;
import com.jeksvp.jumper.objects.Player;

public class GameWorldConstructor {

    private final static int WIDTH = 71;
    private final static int HEIGHT = 25;
    private final static char BACKGROUND = '.';
    private final static char OBJECT = '|';

    public GameWorld buildJumperGameWorld() {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        canvas.setBackgroundChar(BACKGROUND);
        canvas.setObjectChar(OBJECT);
        GameWorld gameWorld = new GameWorld(canvas);
        gameWorld.addGameObject(new Player(30, 17, 4, 8));
        gameWorld.addGameObject(createBarrier(25, 20));
        gameWorld.addGameObject(createBarrier(5, 20));
        gameWorld.addGameObject(createBarrier(50, 20));
        return gameWorld;
    }

    private Barrier createBarrier(int x, int y) {
        return new Barrier(x, y, 3, 5, WIDTH);
    }
}
