package org.example;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import org.example.components.Component;

public class Playground extends AnchorPane {
    Playground() {
        setup();
        setupAnimation(120000000L);
    }



    void setup() {

    }

    void draw() {

    }

    void setupAnimation(long sleep) {
        AnimationTimer timer = new AnimationTimer() {
            private long before = -1;

            @Override
            public void handle(long now) {
                if (now - before >= sleep) {
                    before = now;
                    draw();
                }
            }
        };
    }

    public void addComponent(Component component) {
        getChildren().add(component.getNode());
    }

    public boolean removeComponent() {
        return true;
    }
}
