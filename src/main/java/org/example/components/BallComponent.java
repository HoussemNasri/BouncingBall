package org.example.components;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.example.behaviour.EnvironmentAware;
import org.example.components.obstacles.WallComponent;
import org.example.config.PConfiguration;
import org.example.config.Theme;
import org.example.behaviour.Movable;
import org.example.config.ThemeFactory;
import org.example.playground.Playground;

public class BallComponent extends BaseComponent<Circle> implements Movable, EnvironmentAware {
    private double radius;
    private double xVelocity = DEFAULT_X_VELOCITY;
    private double yVelocity = DEFAULT_Y_VELOCITY;
    private final Theme theme = ThemeFactory.instance(PConfiguration.DEFAUlT);
    private double mass;
    private final Playground playground;

    public BallComponent(Playground playground, double posX, double posY, double radius, Color color) {
        super(posX, posY, radius * 2, radius * 2, color);
        this.radius = radius;
        this.mass = radius * 2;

        componentNode = new Circle(radius);
        setPosX(posX);
        setPosY(posY);
        this.playground = playground;

        setColor(color);
    }

    public BallComponent(Playground playground, double posX, double posY, double radius) {
        this(playground, posX, posY, radius, Color.BLACK);
    }

    public BallComponent(Playground playground, double posX, double posY) {
        this(playground, posX, posY, 10.0d, Color.BLACK);
    }

    @Override
    public void setColor(Color color) {
        componentNode.setFill(color);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void move() {
        setPosX(posX + xVelocity);
        setPosY(posY + yVelocity);

        if (isCollidingWithPlaygroundTop() || isCollidingWithPlaygroundBottom()) {
            handlePlaygroundTopBottomCollision();
        }

        if (isCollidingWithPlaygroundLeft() || isCollidingWithPlaygroundRight()) {
            handlePlaygroundLeftRightCollision();
            System.out.println(playground.width());
        }

        //detectAndHandleObstacleCollision();

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
    public void handlePlaygroundTopBottomCollision() {
        setYVelocity(yVelocity() * -1);
    }

    @Override
    public void handlePlaygroundLeftRightCollision() {
        if (getPosX() < radius)
            setPosX(radius);
        if (posX > playground.width() - radius)
            setPosX(playground.width() - radius);
        setXVelocity(xVelocity * -1);
    }

    @Override
    public boolean isCollidingWithPlaygroundTop() {
        return posY - radius < 0;
    }

    @Override
    public boolean isCollidingWithPlaygroundRight() {
        return posX + radius > playground.width();
    }

    @Override
    public boolean isCollidingWithPlaygroundBottom() {
        return posY + radius > playground.height();
    }

    @Override
    public boolean isCollidingWithPlaygroundLeft() {
        return posX - radius < 0;
    }

    @Override
    public Playground getPlayground() {
        return this.playground;
    }


    public double getMass() {
        return mass;
    }

    @Override
    public void handleObstacleCollision() {
        this.xVelocity = xVelocity * -1;
        this.yVelocity = yVelocity * -1;
    }

    @Override
    public boolean isCollidingWithObstacle(WallComponent wallComponent) {
        return this.componentNode.intersects(wallComponent.componentNode.getBoundsInLocal());
    }

    @Override
    public ObservableList<WallComponent> getObstacles() {
        return playground.obstacles();
    }

    @Override
    public void handleBallCollision() {

    }

    @Override
    public ObservableList<BallComponent> getBalls() {
        return playground.balls();
    }
}
