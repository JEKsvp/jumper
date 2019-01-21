package com.jeksvp.engine;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "intersections")
public abstract class GameObject {
    private int width;
    private int height;
    private int x;
    private int y;
    private Set<GameObject> intersections = new HashSet<>();
    private boolean isPhysical;

    public GameObject(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public GameObject(int width, int height, int x, int y, boolean isPhysical) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.isPhysical = isPhysical;
    }

    public void addIntersection(GameObject gameObject){
        this.intersections.add(gameObject);
    }

    public void addIntersections(List<GameObject> gameObjects){
        this.intersections.addAll(gameObjects);
    }

    public abstract void onUpdate();
}
