package hu.tokingame.physicscalculator.Physics;

import static hu.tokingame.physicscalculator.Physics.MathUtils.sqr;
import static hu.tokingame.physicscalculator.Physics.MathUtils.dToF;
import static hu.tokingame.physicscalculator.Physics.MathUtils.fToD;

/**
 * Created by m on 10/5/2017.
 */

public class CalculatorBase {
    private final float g = dToF(9.81);
    private float x;
    private float y;
    private float alpha;
    private float v0;

    public CalculatorBase(float v0) {
        this.v0 = v0;
    }

    public float calcX(float t){
        return v0 * t * dToF(Math.cos(fToD(alpha)));
    }

    public float calcY(float t){
        return (v0 * t * dToF(Math.sin(fToD(alpha))))-((g/2) * sqr(t));
    }

    public float calcAlphaFromX(float x, float t){
        float szor = v0 * t;
        return dToF(Math.acos(x/szor));
    }

    public float calcAlphaFromY(float y){
        return dToF(0.0);
    }





}
