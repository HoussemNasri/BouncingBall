package org.example.components.obstacles;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import org.example.components.BaseComponent;

public abstract class WallComponent<T extends Node> extends BaseComponent<T> {

    public WallComponent(double posX, double posY, double width, double height, Color color) {
        super(posX, posY, width, height, color);
    }

    abstract WallType getObstacleType();
}
