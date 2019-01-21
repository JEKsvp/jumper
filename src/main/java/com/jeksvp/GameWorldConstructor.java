package com.jeksvp;

import com.jeksvp.engine.Canvas;
import com.jeksvp.engine.GameWorld;
import com.jeksvp.objects.Barrier;
import com.jeksvp.objects.Player;

public class GameWorldConstructor {

    private static int WIDTH = 71;
    private static int HEIGHT = 25;

    public GameWorld buildJumperGameWorld() {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        canvas.setBackgroundNumber('.');
        canvas.setObjectChar('|');
        GameWorld gameWorld = new GameWorld(canvas);
        gameWorld.addGameObject(new Player(30, 17, 4, 8, true));
        gameWorld.addGameObject(new Barrier(25, 20, 3, 5, WIDTH));
        gameWorld.addGameObject(new Barrier(5, 20, 3, 5, WIDTH));
        gameWorld.addGameObject(new Barrier(50, 20, 3, 5, WIDTH));
        return gameWorld;
    }
}
