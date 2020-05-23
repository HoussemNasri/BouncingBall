package org.example.config;

import javafx.scene.paint.Color;

public class DefaultTheme implements Theme {

    DefaultTheme() {

    }

    @Override
    public Color getBackgroundColor() {
        return Color.CYAN;
    }

    @Override
    public Color getBallBackgroundColor() {
        return Color.RED;
    }
}
