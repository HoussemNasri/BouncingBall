package org.example;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class BallCollisionDemo {
    //Properties
    private static final Color PRIMARY_BALL1_COLOR = Color.ORANGE;
    private static final Color PRIMARY_BALL2_COLOR = Color.ROYALBLUE;

    //Views
    private Circle ball1;
    private Circle ball2;
    private Line connection;
    private Group root;


    private void makeBallsMovable() {
        ball1.setOnMouseDragged(event -> {
            ball1.setCenterX(event.getX());
            ball1.setCenterY(event.getY());
            if (detectBallsCollision())
                onCollisionState();
            else if (ball1.getFill() != PRIMARY_BALL1_COLOR || ball2.getFill() != PRIMARY_BALL2_COLOR)
                onDefaultState();


        });

        ball2.setOnMouseDragged(event -> {
            ball2.setCenterX(event.getX());
            ball2.setCenterY(event.getY());
            if (detectBallsCollision())
                onCollisionState();
            else if (ball1.getFill() != PRIMARY_BALL1_COLOR || ball2.getFill() != PRIMARY_BALL2_COLOR)
                onDefaultState();

        });
    }

    public void onDefaultState() {
        ball1.setFill(Color.ORANGE);
        ball2.setFill(Color.ROYALBLUE);
        ball1.setStrokeWidth(0);
        ball2.setStrokeWidth(0);
    }

    public void onCollisionState() {
        ball1.setFill(Color.TRANSPARENT);
        ball2.setFill(Color.TRANSPARENT);
        ball1.setStroke(Color.WHITE);
        ball1.setStrokeWidth(3);
        ball2.setStroke(Color.WHITE);
        ball2.setStrokeWidth(3);
    }

    private void addConnectionLine() {
        connection = new Line(ball1.getCenterX(), ball1.getCenterY(), ball2.getCenterX(), ball2.getCenterY());
        connection.setStroke(Color.WHITE);
        connection.setStrokeWidth(2);

        connection.startXProperty().bind(ball1.centerXProperty());
        connection.startYProperty().bind(ball1.centerYProperty());

        connection.endXProperty().bind(ball2.centerXProperty());
        connection.endYProperty().bind(ball2.centerYProperty());

        root.getChildren().add(connection);
    }

    private boolean detectBallsCollision() {
        return calculateDistance(connection.getStartX(), connection.getStartY(),
                connection.getEndX(), connection.getEndY()) <= ball1.getRadius() + ball2.getRadius();
    }

    private double calculateDistance(double startX, double startY, double endX, double endY) {
        double vectorX = Math.abs(endX - startX);
        double vectorY = Math.abs(endY - startY);
        return Math.sqrt(vectorX * vectorX + vectorY * vectorY);
    }

    public Group start() {
        root = new Group();

        //Init Balls
        ball1 = new Circle(150, 90, 70);
        ball1.setFill(Color.ORANGE);
        ball2 = new Circle(400, 350, 70);
        ball2.setFill(Color.ROYALBLUE);

        root.getChildren().addAll(ball1, ball2);

        makeBallsMovable();
        addConnectionLine();

        return root;
    }

}
