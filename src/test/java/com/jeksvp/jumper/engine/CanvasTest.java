package com.jeksvp.jumper.engine;


import javafx.scene.input.KeyEvent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

    private Canvas canvas;

    @Before
    public void init(){
        this.canvas = new Canvas(10, 10);
        this.canvas.setBackgroundChar('0');
        this.canvas.setObjectChar('1');
        this.canvas.clean();
    }

    @Test
    public void addGameObject() {
        GameObject gameObject = new GameObject(2, 5, 3, 3) {
            @Override
            public void onUpdate() {
            }

            @Override
            public void onKeyPressed(KeyEvent event) {

            }
        };
        canvas.addGameObject(gameObject);
        char[][] expected =
                        {{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1', '0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1', '0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}};
        assertArrayEquals(expected, canvas.getCoordinates());
    }

    @Test
    public void intersectionsTest(){
        GameObject gameObject = new GameObject(2, 5, 3, 3) {
            @Override
            public void onUpdate() {
            }

            @Override
            public void onKeyPressed(KeyEvent event) {

            }
        };
        GameObject gameObject2 = new GameObject(2, 4, 2, 2) {
            @Override
            public void onUpdate() {
            }

            @Override
            public void onKeyPressed(KeyEvent event) {

            }
        };
        GameObject gameObject3 = new GameObject(6, 8, 2, 2) {
            @Override
            public void onUpdate() {
            }

            @Override
            public void onKeyPressed(KeyEvent event) {

            }
        };
        canvas.addGameObject(gameObject);
        canvas.addGameObject(gameObject2);
        canvas.addGameObject(gameObject3);

        for (int i = 0; i < canvas.getCoordinates().length; i++) {
            for (int j = 0; j < canvas.getCoordinates()[i].length; j++) {
                System.out.print(canvas.getCoordinates()[i][j] + " ");
            }
            System.out.println();
        }
        assertEquals(1, gameObject.getIntersections().size());
        assertEquals(1, gameObject2.getIntersections().size());
        assertEquals(0, gameObject3.getIntersections().size());
    }
}
