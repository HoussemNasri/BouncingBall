package org.example.config;

import javafx.scene.paint.Color;

public class DefaultPlaygroundConfig implements PlaygroundConfig {

    DefaultPlaygroundConfig() {

    }

    @Override
    public Color getBackgroundColor() {
        return Color.CYAN;
    }

    @Override
    public double getWidth() {
        return 800.0d;
    }

    @Override
    public double getHeight() {
        return 600.0d;
    }

    @Override
    public Color getBallBackgroundColor() {
        return Color.RED;
    }
}
