package com.jeksvp;

import com.jeksvp.engine.Canvas;
import com.jeksvp.engine.GameWorld;
import com.jeksvp.objects.Player;

public class ScenePainter {

    private GameWorld gameWorld;

    public ScenePainter(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public String draw() {
        Canvas canvas = gameWorld.update();
        return buildString(canvas);
    }

    private String buildString(Canvas canvas) {
        Character[][] coordinates = canvas.getCoordinates();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                sb.append(coordinates[i][j]);
            }
        }
        return sb.toString();
    }
}
