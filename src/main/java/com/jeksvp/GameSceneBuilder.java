package com.jeksvp;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameSceneBuilder {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int FONT = 18;

    public VBox build(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Jumper");
        primaryStage.setScene(scene);
        root.getChildren().add(createMainTextArea());
        return root;
    }

    private Node createMainTextArea() {
        TextArea textArea = new TextArea();
        textArea.setMinWidth(WIDTH);
        textArea.setMinHeight(HEIGHT);
        textArea.setMaxWidth(WIDTH);
        textArea.setMaxHeight(HEIGHT);
        textArea.setWrapText(true);
        textArea.setFont(Font.font("Monospaced", FONT));
        return textArea;
    }
}
