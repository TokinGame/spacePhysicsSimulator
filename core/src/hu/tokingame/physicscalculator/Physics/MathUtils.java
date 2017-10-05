package hu.tokingame.physicscalculator.Physics;

/**
 * Created by m on 10/5/2017.
 */

public class MathUtils {
    public static float dToF(double n){
        return (float) n;
    }

    public static double fToD(float n){
        return (double)n;
    }

    public static float sqr(float n){
        return dToF(Math.pow(fToD(n), 2));
    }
}
