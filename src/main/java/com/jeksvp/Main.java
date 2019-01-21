package com.jeksvp;

import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new GameSceneBuilder().build(primaryStage);
        primaryStage.show();
        TextArea textArea = (TextArea) root.getChildren().get(0);
        ScenePainter scenePainter = new ScenePainter();
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
