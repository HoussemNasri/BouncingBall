package org.example.behaviour;

import org.example.playground.Playground;

public interface PlaygroundAware {

    void handlePlaygroundTopBottomCollision();

    void handlePlaygroundLeftRightCollision();

    boolean isCollidingWithPlaygroundTop();

    boolean isCollidingWithPlaygroundRight();

    boolean isCollidingWithPlaygroundBottom();

    boolean isCollidingWithPlaygroundLeft();

    Playground getPlayground();
}
