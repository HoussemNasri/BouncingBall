package org.example;

public interface Contained {
    double getContainerWidth();

    double getContainerHeight();

    void onReachVerticalBorder();

    void onReachHorizontalBorder();

    boolean hasReachedTopBorder();

    boolean hasReachedRightBorder();

    boolean hasReachedBottomBorder();

    boolean hasReachedLeftBorder();
}
