package org.example.behaviour;

import org.example.components.obstacles.WallComponent;

public interface EnvironmentAware extends PlaygroundAware, ObstacleAware, BallAware {
    public default void detectAndHandleObstacleCollision() {
        // detecting collision with obstacles
        for (WallComponent obstacle : getObstacles())
            if (isCollidingWithObstacle(obstacle))
                handleObstacleCollision();
    }
}
