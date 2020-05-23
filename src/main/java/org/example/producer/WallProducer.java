package org.example.producer;

import javafx.scene.paint.Color;
import org.example.components.obstacles.WallComponent;
import org.example.config.PConfiguration;
import org.example.config.Theme;
import org.example.config.ThemeFactory;
import org.example.config.Themed;
import org.example.constraint.ConstraintColor;
import org.example.constraint.ConstraintSize;
import org.example.constraint.Size;

import java.util.List;

public class WallProducer extends Themed implements Producer<WallComponent> {

    public WallProducer(Theme theme) {
        super(theme);
    }

    public WallProducer() {
        super();
    }

    @Override
    public List<WallComponent> produce(int seedCount, ConstraintSize seedSizeConstraint,
                                       ConstraintColor seedColorConstraint) {

        return null;
    }
}
