package org.example.behaviour;

import javafx.collections.ObservableList;
import org.example.components.BallComponent;

import java.util.List;

public interface BallAware {
    void handleBallCollision();

    ObservableList<BallComponent> getBalls();
}
