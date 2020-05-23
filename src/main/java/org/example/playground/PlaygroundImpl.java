package org.example.playground;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import org.example.components.BallComponent;
import org.example.components.obstacles.WallComponent;
import org.example.util.PlaygroundUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PlaygroundImpl extends AnchorPane implements Playground {

    private BallComponent ball1;
    private BallComponent ball2;
    private AnimationTimer timer;
    private ObservableList<BallComponent> ballComponents;
    private ObservableList<WallComponent> wallComponents;

    public PlaygroundImpl() {
        setup();
        setupAnimation(12000000L);
    }

    private void setup() {
        ball1 = new BallComponent(this, 100, 200, 20, Color.ORANGE);
        ball2 = new BallComponent(this, 400, 200, 50, Color.BLUE);
        ballComponents = FXCollections.observableArrayList(ball1, ball2);
        getChildren().addAll(ball1.getComponentNode(), ball2.getComponentNode());
        List<Node> obsNode =
                PlaygroundUtils.generateObstacles(5, width(), height()).stream()
                        .map((WallComponent obstacleComponent) -> obstacleComponent.getComponentNode()).collect(Collectors.toList());

        getChildren().addAll(obsNode);

        ball1.setXVelocity(5);
        ball1.setYVelocity(0);

        ball2.setXVelocity(-3);
        ball2.setYVelocity(0);
    }

    private void draw() {
        ball1.move();
        ball2.move();
        if (detectBallCollision(ball1, ball2)) {
            ball2.setPosX(ball1.getPosX() + ball1.getRadius() + ball2.getRadius());
            System.out.println("Detected");
            double[] finalVelocity = resolveBallCollision(ball1.getMass(), ball2.getMass(), ball1.xVelocity(), ball2.xVelocity());
            ball1.setXVelocity(-finalVelocity[0]);
            ball2.setXVelocity(finalVelocity[1]);
        }
    }

    public void start() {
        timer.start();
    }

    void setupAnimation(long sleep) {
        timer = new AnimationTimer() {
            private long before = -1;

            @Override
            public void handle(long now) {
                //if (now - before >= sleep) {
                //before = now;
                draw();
                // }
            }
        };
    }

    public double[] resolveBallCollision(double m1, double m2, double v1, double v2) {
        double[] finalVelocity = new double[2];
        v1 = Math.abs(v1);
        v2 = Math.abs(v2);

        double v1Final = ((m1 - m2) * v1 + (2 * m2 * v2)) / (m1 + m2);
        double v2Final = ((m2 - m1) * v2 + (2 * m1 * v1)) / (m1 + m2);
        System.out.println("v1Final : " + v1Final + "\n" + "v2Final : " + v2Final + "\n");

        return new double[]{v1Final, v2Final};
    }

    public boolean detectBallCollision(BallComponent ball1, BallComponent ball2) {
        return Math.abs(ball1.getPosX() - ball2.getPosX()) < ball1.getRadius() + ball2.getRadius();
    }

    @Override
    public double width() {
        return 800.0d;
    }

    @Override
    public double height() {
        return 600.0d;
    }

    @Override
    public Point2D startPoint() {
        return null;
    }

    @Override
    public ObservableList<WallComponent> obstacles() {
        return null;
    }

    @Override
    public ObservableList<BallComponent> balls() {
        return null;
    }
}
