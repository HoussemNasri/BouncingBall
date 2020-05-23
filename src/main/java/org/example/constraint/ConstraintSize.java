package org.example.constraint;

public class ConstraintSize extends Constraint<Size> {
    @Override
    public boolean inspect(Size value) {
        return false;
    }

    @Override
    protected Constraint<Size> instance() {
        return this;
    }
}
