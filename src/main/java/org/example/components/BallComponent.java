package org.example.components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.Contained;
import org.example.behaviours.Movable;

public class BallComponent extends Component<Circle> implements Movable, Contained {
    private double radius;
    private double xVelocity = DEFAULT_X_VELOCITY;
    private double yVelocity = DEFAULT_Y_VELOCITY;
    private double containerWidth;
    private double containerHeight;

    public BallComponent(double containerWidth, double containerHeight, double posX, double posY, double radius, Color color) {
        super(posX, posY, radius * 2, radius * 2, color);
        this.radius = radius;
        this.containerWidth = containerWidth;
        this.containerHeight = containerHeight;
        node = new Circle();

        setPosX(posX);
        setPosY(posY);
        node.setRadius(radius);
        setColor(color);
    }

    public BallComponent(double containerWidth, double containerHeight, double posX, double posY, double radius) {
        this(containerWidth, containerHeight, posX, posY, radius, Color.BLACK);
    }

    public BallComponent(double containerWidth, double containerHeight, double posX, double posY) {
        this(containerWidth, containerHeight, posX, posY, 10.0d, Color.BLACK);
    }

    public BallComponent(double containerWidth, double containerHeight) {
        this(containerWidth, containerHeight, 100.0d, 100.0d);
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
        setXVelocity(xVelocity * -1);
    }

    @Override
    public boolean hasReachedTopBorder() {
        System.out.println(posX);
        return posY - radius <= 0;
    }

    @Override
    public boolean hasReachedRightBorder() {
        return posX + radius >= containerWidth;
    }

    @Override
    public boolean hasReachedBottomBorder() {
        return posY + radius >= containerHeight;
    }

    @Override
    public boolean hasReachedLeftBorder() {
        return posX - radius <= 0;
    }

    @Override
    public double getContainerWidth() {
        return containerWidth;
    }

    @Override
    public double getContainerHeight() {
        return containerHeight;
    }
}
