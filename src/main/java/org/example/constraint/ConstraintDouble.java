package org.example.constraint;

public class ConstraintDouble extends Constraint<Double> {

    public ConstraintDouble() {
        super();
        from = 0.0;
        to = 0.0;
    }

    @Override
    public boolean inspect(Double value) {
        return value >= from && value <= to;
    }

    @Override
    protected Constraint<Double> instance() {
        return this;
    }

}
