package com.jeksvp.jumper.engine;

import javafx.scene.input.KeyEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "intersections")
@ToString(exclude = "intersections")
public abstract class GameObject {

    private int width;
    private int height;
    private int x;
    private int y;
    private Set<GameObject> intersections = new HashSet<>();

    public GameObject(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }


    public void addIntersection(GameObject gameObject) {
        this.intersections.add(gameObject);
    }

    public void addIntersections(List<GameObject> gameObjects) {
        this.intersections.addAll(gameObjects);
    }

    public abstract void onUpdate();

    public abstract void onKeyPressed(KeyEvent event);

    public void clearIntersections(){
        this.intersections.clear();
    }
}
