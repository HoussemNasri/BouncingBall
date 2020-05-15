package org.example.components.obstacles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareObstacleComponent extends ObstacleComponent<Rectangle> {

    SquareObstacleComponent(double posX, double posY, double width, double height, Color color) {
        super(posX, posY, width, height, color);

    }

    @Override
    public void setColor(Color color) {

    }
}
