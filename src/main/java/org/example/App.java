package org.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        BallCollisionDemo ballCollisionDemo = new BallCollisionDemo();
        Group root = ballCollisionDemo.start();

        Button action = new Button("Action");
        root.getChildren().add(action);
        var scene = new Scene(root, 600, 600);
        scene.setFill(Color.DIMGRAY);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}