package com.jeksvp.engine;

import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    private Canvas canvas;
    private List<GameObject> gameObjects = new ArrayList<>();

    public GameWorld(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.onUpdate();
        }
        canvas.clean();
        updateCanvas(gameObjects);
        return canvas;
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    private void updateCanvas(List<GameObject> gameObjects) {
        for (GameObject gameObject : gameObjects) {
            canvas.addGameObject(gameObject);
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void keyPressed(KeyEvent event) {
        for (GameObject gameObject : gameObjects) {
            gameObject.onKeyPressed(event);
        }
    }
}
