package hu.tokingame.physicscalculator.Physics;

import sun.nio.cs.Surrogate;

import static hu.tokingame.physicscalculator.Physics.MathUtils.sqr;
import static hu.tokingame.physicscalculator.Physics.MathUtils.dToF;
import static hu.tokingame.physicscalculator.Physics.MathUtils.fToD;

/**
 * Created by m on 10/5/2017.
 */

public class Calculator {
    public static final float g = dToF(9.81);


    public static float[] calcAlpha(float v0, float x, float y){
        double sqrt = Math.pow(v0,4)-g*(g*Math.pow(x,2) + 2*y*Math.pow(v0,2));
        if(Math.signum(sqrt) < 0) return new float[] {(float)-666.0,(float)-666.0};
        double alpha1 = Math.toDegrees(Math.atan((Math.pow(v0,2) + Math.sqrt(sqrt))/(g*x)));
        double alpha2 = Math.toDegrees(Math.atan((Math.pow(v0,2) - Math.sqrt(sqrt))/(g*x)));
        return new float[] {(float)alpha1,(float)alpha2};
    }

/*
    public float calcX(float t){
        return v0 * t * dToF(Math.cos(fToD(alpha)));
    }

    public float calcY(float t){
        return (v0 * t * dToF(Math.sin(fToD(alpha))))-((g/2) * sqr(t));
    }

    public float calcTimeH(){
        return dToF((2*v0*Math.sin(alpha))/g);
    }

    */




}
