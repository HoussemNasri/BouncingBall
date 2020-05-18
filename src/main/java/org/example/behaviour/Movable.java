package org.example.behaviour;

public interface Movable {
    void move();

    public static final double DEFAULT_X_VELOCITY = 5;
    public static final double DEFAULT_Y_VELOCITY = 10;


    double xVelocity();

    double yVelocity();

    void setXVelocity(double xVelocity);

    void setYVelocity(double yVelocity);
}
