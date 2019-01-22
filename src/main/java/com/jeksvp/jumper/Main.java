package com.jeksvp.jumper;

import com.jeksvp.jumper.engine.GameWorld;
import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        JumperGameScene gameScene = new JumperGameScene(primaryStage);
        VBox root = gameScene.getRoot();
        primaryStage.show();

        TextArea textArea = gameScene.getTextArea();
        GameWorld gameWorld = new GameWorldConstructor().buildJumperGameWorld();
        textArea.setOnKeyPressed(gameWorld::keyPressed);

        ScenePainter scenePainter = new ScenePainter(gameWorld);
        new Thread(() -> {
            while (true) {
                textArea.setText(scenePainter.draw());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
