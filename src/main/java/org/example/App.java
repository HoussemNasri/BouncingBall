package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import org.example.config.PConfiguration;
import org.example.config.Theme;
import org.example.config.ThemeFactory;
import org.example.playground.PlaygroundImpl;
import org.example.producer.BallProducer;
import org.example.producer.Producer;

/**
 * JavaFX App
 */
public class App extends Application {
    private Theme playgroundTheme = ThemeFactory.instance(PConfiguration.DEFAUlT);

    @Override
    public void start(Stage stage) {
        BallCollisionDemo ballCollisionDemo = new BallCollisionDemo();
        Button action = new Button("Action");
        PlaygroundImpl root = new PlaygroundImpl();
        Producer producer = new BallProducer(ThemeFactory.instance(PConfiguration.DEFAUlT));
        action.setOnMouseClicked(event -> root.start());

        root.getChildren().add(action);
        var scene = new Scene(root, root.width(), root.height());
        root.setBackground(new Background(new BackgroundFill(playgroundTheme.getBackgroundColor(), null, null)));
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }

}