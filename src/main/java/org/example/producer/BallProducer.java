package org.example.producer;


import org.example.components.BallComponent;
import org.example.config.Theme;
import org.example.config.Themed;
import org.example.constraint.ConstraintColor;
import org.example.constraint.ConstraintSize;

import java.util.List;

public class BallProducer extends Themed implements Producer<BallComponent> {
    public BallProducer(Theme theme) {
        super(theme);
    }

    public BallProducer() {
        super();
    }

    @Override
    public List<BallComponent> produce(int seedCount, ConstraintSize seedSizeConstraint,
                                       ConstraintColor seedColorConstraint) {

        return null;
    }

}
