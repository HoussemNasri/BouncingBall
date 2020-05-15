package org.example.components.obstacles;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import org.example.components.Component;

public class ObstacleComponent<T extends Node> extends Component<T> {

    public ObstacleComponent(double posX, double posY, double width, double height, Color color) {
        super(posX, posY, width, height, color);
    }

    @Override
    public void setColor(Color color) {

    }
}
