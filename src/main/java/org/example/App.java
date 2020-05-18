package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.config.PConfiguration;
import org.example.config.PlaygroundConfig;
import org.example.config.PlaygroundFactory;

/**
 * JavaFX App
 */
public class App extends Application {
    private PlaygroundConfig config = PlaygroundFactory.instance(PConfiguration.DEFAUlT);

    @Override
    public void start(Stage stage) {
        BallCollisionDemo ballCollisionDemo = new BallCollisionDemo();
        Button action = new Button("Action");
        Playground root = new Playground();
        action.setOnMouseClicked(event -> root.start());

        root.getChildren().add(action);
        var scene = new Scene(root, config.getWidth(), config.getHeight());
        root.setBackground(new Background(new BackgroundFill(config.getBackgroundColor(), null, null)));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}