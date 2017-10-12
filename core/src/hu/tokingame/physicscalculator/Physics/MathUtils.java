package hu.tokingame.physicscalculator.Physics;

import java.util.Random;

/**
 * Created by m on 10/5/2017.
 */

public class MathUtils {
    private static Random random = new Random();

    public static float dToF(double n){
        return (float) n;
    }

    public static double fToD(float n){
        return (double)n;
    }

    public static float sqr(float n){
        return dToF(Math.pow(fToD(n), 2));
    }

    public static int getRandom(int a, int b){
        return random.nextInt(b - a) + a;
    }

}
