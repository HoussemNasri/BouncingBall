package org.example.constraint;

import java.util.ArrayList;
import java.util.List;

abstract class Constraint<T> {
    protected T from;
    protected T to;
    protected List<T> blacklist;

    public abstract boolean inspect(T value);

    protected abstract Constraint<T> instance();

    Constraint() {
        blacklist = new ArrayList<>();
    }

    class Builder {
        private Constraint constraint = instance();

        public Constraint from(T from) {
            constraint.from = from;
            return constraint;
        }

        public Constraint to(T to) {
            constraint.to = to;
            return constraint;
        }

        public Constraint except(T... elements) {
            constraint.blacklist = List.of(elements);
            return constraint;
        }

    }
}
