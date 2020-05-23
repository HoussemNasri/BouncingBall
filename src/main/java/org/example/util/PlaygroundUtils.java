package org.example.util;

import javafx.scene.paint.Color;
import org.example.components.obstacles.WallComponent;
import org.example.components.obstacles.SquareWall;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundUtils {
    public static List<WallComponent> generateObstacles(int n, double width, double height) {
        List<WallComponent> obstacles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double posx = RandomUtils.randomWithExclude(0, width);
            double posy = RandomUtils.randomWithExclude(0, height);
            obstacles.add(new SquareWall(posx, posy, 30, 30, Color.CORAL));
        }

        return obstacles;
    }


}

