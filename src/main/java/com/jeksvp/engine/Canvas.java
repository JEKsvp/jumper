package com.jeksvp.engine;


import javafx.util.Pair;
import lombok.Getter;

import java.util.*;

@Getter
public class Canvas {

    private Character[][] coordinates;
    private Character backgroundChar = '0';
    private Character objectChar = '1';

    private Map<Pair<Integer, Integer>, List<GameObject>> intersectionObjects = new HashMap<>();

    public Canvas(int width, int height) {
        this.coordinates = new Character[height][width];
    }

    public void clean() {
        this.intersectionObjects.clear();
        fillBackground();
    }

    private void fillBackground() {
        for (int i = 0; i < this.coordinates.length; i++) {
            for (int j = 0; j < this.coordinates[i].length; j++) {
                this.coordinates[i][j] = backgroundChar;
            }
        }
    }

    public void addGameObject(GameObject gameObject) {
        gameObject.setClearIntersections();
        Map<Integer, List<Integer>> coordinates = getCoordinates(gameObject);
        for (int i = 0; i < this.coordinates.length; i++) {
            for (int j = 0; j < this.coordinates[i].length; j++) {
                if (coordinates.containsKey(j) && coordinates.get(j).contains(i)) {
                    if (i < this.coordinates.length && j < this.coordinates[i].length) {
                        this.coordinates[i][j] = objectChar;
                        if (hasIntersections(i, j, intersectionObjects)) {
                            addIntersections(i, j, intersectionObjects, gameObject);
                        }
                        addToMap(i, j, intersectionObjects, gameObject);
                    }
                }
            }
        }
    }

    private void addIntersections(int i, int j, Map<Pair<Integer, Integer>, List<GameObject>> intersectionObjects, GameObject gameObject) {
        Pair<Integer, Integer> coordinates = new Pair<>(i, j);
        List<GameObject> gameObjects = intersectionObjects.get(coordinates);
        for (GameObject go : intersectionObjects.get(coordinates)) {
            go.addIntersection(gameObject);
        }
        gameObject.addIntersections(gameObjects);
    }

    private boolean hasIntersections(int i, int j, Map<Pair<Integer, Integer>, List<GameObject>> intersectionObjects) {
        List<GameObject> gameObjects = intersectionObjects.get(new Pair<>(i, j));
        return gameObjects != null;
    }

    private void addToMap(int i, int j, Map<Pair<Integer, Integer>, List<GameObject>> intersectionObjects, GameObject gameObject) {
        Pair<Integer, Integer> coordinates = new Pair<>(i, j);
        if (intersectionObjects.containsKey(coordinates)) {
            intersectionObjects.get(coordinates).add(gameObject);
        } else {
            intersectionObjects.put(coordinates, new ArrayList<>(Collections.singletonList(gameObject)));
        }
    }

    private Map<Integer, List<Integer>> getCoordinates(GameObject gameObject) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        Map<Integer, List<Integer>> coordinates = new HashMap<>();
        for (int i = 0; i < gameObject.getWidth(); i++) {
            int tempY = y;
            for (int j = 0; j < gameObject.getHeight(); j++) {
                if (coordinates.containsKey(x)) {
                    coordinates.get(x).add(tempY);
                } else {
                    coordinates.put(x, new ArrayList<>(Collections.singletonList(tempY)));
                }
                tempY++;
            }
            x++;
        }
        return coordinates;
    }


    public void setBackgroundNumber(Character backgroundChar) {
        this.backgroundChar = backgroundChar;
    }

    public void setObjectChar(Character objectChar) {
        this.objectChar = objectChar;
    }
}

