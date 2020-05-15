package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallGenerator {

   /* public List<Ball> generate(int ballCount) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < ballCount; i++) {
            double xPos = random(30, 300);
            double yPos = random(30, 300);
            double xVelocity = random(-10, 10);
            double yVelocity = random(-10, 10);

            Ball ball = new Ball(xPos, yPos, xVelocity, yVelocity);
            result.add(ball);
        }

        return result;
    }
*/
    private int random(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
