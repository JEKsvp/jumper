package com.jeksvp.engine;


import javafx.util.Pair;
import lombok.Getter;

import java.util.*;

@Getter
public class Canvas {

    private int[][] coordinates;

    private Map<Pair<Integer, Integer>, List<GameObject>> gameObjectMap = new HashMap<>();

    public Canvas(int width, int height) {
        this.coordinates = new int[height][width];
    }

    public void clean() {
        this.gameObjectMap = new HashMap<>();
        fillZeros();
    }

    private void fillZeros() {
        for (int i = 0; i < this.coordinates.length; i++) {
            for (int j = 0; j < this.coordinates[i].length; j++) {
                this.coordinates[i][j] = 0;
            }
        }
    }

    public void addGameObject(GameObject gameObject) {
        Map<Integer, List<Integer>> coordinates = getCoordinates(gameObject);
        for (int i = 0; i < this.coordinates.length; i++) {
            for (int j = 0; j < this.coordinates[i].length; j++) {
                if (j < this.coordinates.length && i < this.coordinates[j].length) {
                    if (coordinates.containsKey(i) && coordinates.get(i).contains(j)) {
                        this.coordinates[j][i] = 1;
                        if (hasIntersections(i, j, gameObjectMap, gameObject)) {
                            addIntersections(i, j, gameObjectMap, gameObject);
                        }
                        addToMap(i, j, gameObjectMap, gameObject);
                    }
                }
            }
        }
    }

    private void addIntersections(int i, int j, Map<Pair<Integer, Integer>, List<GameObject>> gameObjectMap, GameObject gameObject) {
        Pair<Integer, Integer> coordinates = new Pair<>(i, j);
        List<GameObject> gameObjects = gameObjectMap.get(coordinates);
        for (GameObject go : gameObjectMap.get(coordinates)) {
            go.addIntersection(gameObject);
        }
        gameObject.addIntersections(gameObjects);
    }

    private boolean hasIntersections(int i, int j, Map<Pair<Integer, Integer>, List<GameObject>> gameObjectMap, GameObject gameObject) {
        List<GameObject> gameObjects = gameObjectMap.get(new Pair<>(i, j));
        return gameObjects != null;
    }

    private void addToMap(int i, int j, Map<Pair<Integer, Integer>, List<GameObject>> gameObjectMap, GameObject gameObject) {
        Pair<Integer, Integer> coordinates = new Pair<>(i, j);
        if (gameObjectMap.containsKey(coordinates)) {
            gameObjectMap.get(coordinates).add(gameObject);
        } else {
            gameObjectMap.put(coordinates, new ArrayList<>(Collections.singletonList(gameObject)));
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

}
