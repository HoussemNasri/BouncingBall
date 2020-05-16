package org.example.collision;

public interface CollisionHandler {

    void onReachVerticalBorder();

    void onReachHorizontalBorder();

    boolean hasReachedTopBorder();

    boolean hasReachedRightBorder();

    boolean hasReachedBottomBorder();

    boolean hasReachedLeftBorder();
}
