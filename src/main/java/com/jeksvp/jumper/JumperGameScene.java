package com.jeksvp.jumper;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JumperGameScene {

    private static final String TITLE = "Jumper";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FONT = 18;

    private VBox root;
    private TextArea textArea;

    public JumperGameScene(Stage primaryStage) {
        this.root = createRoot(primaryStage);
        root.getChildren().add(createMainTextArea());
    }

    private VBox createRoot(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        return root;
    }

    private Node createMainTextArea() {
        this.textArea = new TextArea();
        this.textArea.setMinWidth(WIDTH);
        this.textArea.setMinHeight(HEIGHT);
        this.textArea.setMaxWidth(WIDTH);
        this.textArea.setMaxHeight(HEIGHT);
        this.textArea.setWrapText(true);
        this.textArea.setFont(Font.font("Monospaced", FONT));
        return this.textArea;
    }

    public VBox getRoot() {
        return root;
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
