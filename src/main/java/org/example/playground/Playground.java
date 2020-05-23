package org.example.playground;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import org.example.components.BallComponent;
import org.example.components.obstacles.WallComponent;

public interface Playground {
    double width();

    double height();

    Point2D startPoint();

    ObservableList<WallComponent> obstacles();

    ObservableList<BallComponent> balls();
}
