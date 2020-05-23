package org.example.behaviour;

import javafx.collections.ObservableList;
import org.example.components.obstacles.WallComponent;

public interface ObstacleAware {
    void handleObstacleCollision();

    boolean isCollidingWithObstacle(WallComponent wallComponent);

    ObservableList<WallComponent> getObstacles();
}
