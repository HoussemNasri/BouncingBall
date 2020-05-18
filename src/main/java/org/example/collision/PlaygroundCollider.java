package org.example.collision;

public interface PlaygroundCollider {

    void onReachVerticalBorder();

    void onReachHorizontalBorder();

    boolean hasReachedTopBorder();

    boolean hasReachedRightBorder();

    boolean hasReachedBottomBorder();

    boolean hasReachedLeftBorder();
}
