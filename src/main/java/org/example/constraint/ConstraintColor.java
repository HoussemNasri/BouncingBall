package org.example.constraint;

import javafx.scene.paint.Color;

public class ConstraintColor extends Constraint<Color> {
    @Override
    public boolean inspect(Color value) {
        return false;
    }

    @Override
    protected Constraint<Color> instance() {
        return this;
    }
}
