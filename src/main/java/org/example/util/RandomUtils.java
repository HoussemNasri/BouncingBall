package org.example.util;

import java.util.List;
import java.util.Random;

public class RandomUtils {
    public static double randomWithExclude(double from, double to) {

        double number = (new Random().nextFloat() * (to - from)) + from;
        System.out.println(new Random().nextFloat() + " : " + number);
        number = Math.abs(number);

        return number;
    }
}
