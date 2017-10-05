package hu.tokingame.physicscalculator.Physics;

import static hu.tokingame.physicscalculator.Physics.MathUtils.sqr;
import static hu.tokingame.physicscalculator.Physics.MathUtils.dToF;
import static hu.tokingame.physicscalculator.Physics.MathUtils.fToD;

/**
 * Created by m on 10/5/2017.
 */

public class Calculator {
    public final float g = dToF(9.81);
    private float alpha;
    private float v0;
    private float d;
    private float th;

    // Ezzel lehet olyat számolni ami adott távolságra megy
    public Calculator(float v0, float d) {
        this.v0 = v0;
        this.d = d;
        this.alpha = calcAlpha();
        this.th = calcTimeH();
    }

    public float calcX(float t){
        return v0 * t * dToF(Math.cos(fToD(alpha)));
    }

    public float calcY(float t){
        return (v0 * t * dToF(Math.sin(fToD(alpha))))-((g/2) * sqr(t));
    }

    public float calcTimeH(){
        return dToF((2*v0*Math.sin(alpha))/g);
    }

    public float calcAlpha(){
        return dToF(Math.asin((d*g)/v0)/2.0);
    }



}
