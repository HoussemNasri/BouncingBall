package org.example.components.obstacles;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareWall extends WallComponent<Rectangle> {

    public SquareWall(double posX, double posY, double width, double height, Color color) {
        super(posX, posY, width, height, color);
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        componentNode = new Rectangle(posX, posY, width, height);
        setColor(color);
    }

    @Override
    WallType getObstacleType() {
        return WallType.SQUARE;
    }

    @Override
    public void setColor(Color color) {
        componentNode.setFill(color);
    }
}
