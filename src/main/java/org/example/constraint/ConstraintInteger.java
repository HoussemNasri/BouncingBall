package org.example.constraint;

public class ConstraintInteger extends Constraint<Integer> {

    @Override
    public boolean inspect(Integer value) {
        return value >= from && value <= to;
    }

    @Override
    protected Constraint<Integer> instance() {
        return this;
    }

    ConstraintInteger() {
        super();
        from = 0;
        to = 0;
    }
}
