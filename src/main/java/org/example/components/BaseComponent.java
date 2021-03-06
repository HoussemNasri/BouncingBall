package org.example.components;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public abstract class BaseComponent<T extends Node> {
    protected T componentNode;
    protected Color color;
    protected double posX;
    protected double posY;
    protected double getWidth;
    private double getHeight;

    public BaseComponent(double posX, double posY, double width, double height, Color color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
        componentNode.setLayoutX(posX);
    }

    public void setPosY(double posY) {
        this.posY = posY;
        componentNode.setLayoutY(posY);

    }

    public Color getColor() {
        return color;
    }

    public T getComponentNode() {
        return componentNode;
    }

    public double getGetWidth() {
        return getWidth;
    }

    public double getGetHeight() {
        return getHeight;
    }

    public abstract void setColor(Color color);


}
