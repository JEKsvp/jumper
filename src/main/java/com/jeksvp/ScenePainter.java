package com.jeksvp;

import com.jeksvp.engine.Canvas;
import com.jeksvp.engine.GameWorld;
import com.jeksvp.objects.Player;

public class ScenePainter {

    private static int WIDTH = 71;
    private static int HEIGHT = 25;

    private GameWorld gameWorld = new GameWorld(new Canvas(WIDTH, HEIGHT));

    public ScenePainter() {
        gameWorld.addGameObject(new Player(0,0, 5, 2));
    }

    public String draw() {
        Canvas canvas = gameWorld.update();
        return buildString(canvas);
    }

    private String buildString(Canvas canvas) {
        int[][] coordinates = canvas.getCoordinates();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                sb.append(coordinates[i][j]);
            }
        }
        return sb.toString();
    }
}
