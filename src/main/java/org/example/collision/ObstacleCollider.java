package org.example.collision;

import org.example.components.BaseComponent;
import org.example.components.obstacles.ObstacleComponent;

import java.util.List;

public interface ObstacleCollider {
    void handleObstacleCollision(BaseComponent component, List<ObstacleComponent> obstacleComponentList);
}
