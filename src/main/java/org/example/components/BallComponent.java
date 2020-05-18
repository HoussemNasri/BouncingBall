package org.example.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.config.PConfiguration;
import org.example.config.PlaygroundConfig;
import org.example.behaviour.Movable;
import org.example.collision.PlaygroundCollider;
import org.example.config.PlaygroundFactory;

public class BallComponent extends BaseComponent<Circle> implements Movable, PlaygroundCollider {
    private double radius;
    private double xVelocity = DEFAULT_X_VELOCITY;
    private double yVelocity = DEFAULT_Y_VELOCITY;
    private final PlaygroundConfig playgroundConfig = PlaygroundFactory.instance(PConfiguration.DEFAUlT);
    private double mass;

    public BallComponent(double posX, double posY, double radius, Color color) {
        super(posX, posY, radius * 2, radius * 2, color);
        this.radius = radius;
        this.mass = radius * 2;
        node = new Circle();

        setPosX(posX);
        setPosY(posY);
        node.setRadius(radius);
        setColor(color);
    }

    public BallComponent(double posX, double posY, double radius) {
        this(posX, posY, radius, Color.BLACK);
    }

    public BallComponent(double posX, double posY) {
        this(posX, posY, 10.0d, Color.BLACK);
    }


    @Override
    public void setColor(Color color) {
        node.setFill(color);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void move() {
        posX = posX + xVelocity;
        posY = posY + yVelocity;
        setPosX(posX);
        setPosY(posY);

        if (hasReachedTopBorder() || hasReachedBottomBorder()) {
            onReachVerticalBorder();
        }

        if (hasReachedLeftBorder() || hasReachedRightBorder()) {
            onReachHorizontalBorder();
        }
    }

    @Override
    public double xVelocity() {
        return xVelocity;
    }

    @Override
    public double yVelocity() {
        return yVelocity;
    }

    @Override
    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    @Override
    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }


    @Override
    public void onReachVerticalBorder() {
        setYVelocity(yVelocity() * -1);
    }

    @Override
    public void onReachHorizontalBorder() {
        if (getPosX() < radius)
            setPosX(radius);
        if (posX > playgroundConfig.getWidth() - radius)
            setPosX(playgroundConfig.getWidth() - radius);
        setXVelocity(xVelocity * -1);
    }

    @Override
    public boolean hasReachedTopBorder() {
        return posY - radius < 0;
    }

    @Override
    public boolean hasReachedRightBorder() {
        return posX + radius >= playgroundConfig.getWidth();
    }

    @Override
    public boolean hasReachedBottomBorder() {
        return posY + radius > playgroundConfig.getHeight();
    }

    @Override
    public boolean hasReachedLeftBorder() {
        return posX - radius < 0;
    }


    public double getMass() {
        return mass;
    }
}
