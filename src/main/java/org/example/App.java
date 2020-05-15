package org.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.components.BallComponent;

import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button action = new Button("Action");

        AnimationTimer timer = new AnimationTimer() {
            private long before = -1;

            @Override
            public void handle(long now) {
                if (now - before >= 12000000) {
                    before = now;
                }
            }
        };

        action.setOnMouseClicked(mouseEvent -> {
            timer.start();
        });

        Container container = new Container();
        container.getChildren().add(action);
        BallComponent component = new BallComponent(600, 600);

        container.addComponent(component);
        action.setOnMouseClicked(event -> component.move());

        var scene = new Scene(container, 600, 600);

        scene.setFill(Color.LIGHTBLUE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}