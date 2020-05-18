package org.example;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import org.example.components.BallComponent;
import org.example.components.BaseComponent;
import org.example.config.DefaultPlaygroundConfig;
import org.example.config.PConfiguration;
import org.example.config.PlaygroundConfig;
import org.example.config.PlaygroundFactory;

public class Playground extends AnchorPane {

    private BallComponent ball1;
    private BallComponent ball2;
    private AnimationTimer timer;

    public Playground() {
        setup();
        setupAnimation(12000000L);
    }

    private void setup() {
        ball1 = new BallComponent(50, 200, 20, Color.ORANGE);
        ball2 = new BallComponent(300, 200, 150, Color.BLUE);

        getChildren().addAll(ball1.getNode(), ball2.getNode());

        ball1.setXVelocity(5);
        ball1.setYVelocity(0);

        ball2.setXVelocity(-4);
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
}
