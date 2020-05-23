package org.example.producer;

import javafx.scene.paint.Color;
import org.example.components.BaseComponent;
import org.example.constraint.ConstraintColor;
import org.example.constraint.ConstraintSize;
import org.example.constraint.Size;

import java.util.List;

public interface Producer<T extends BaseComponent> {
    List<T> produce(int seedCount, ConstraintSize seedSizeConstraint, ConstraintColor seedColorConstraint);

    //Overloading
    default List<T> produce(int seedCount, ConstraintSize seedSizeConstraint) {
        return produce(seedCount, seedSizeConstraint, null);
    }

    default List<T> produce(int seedCount) {
        return produce(seedCount, null, null);
    }
}
