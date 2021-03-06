package hu.tokingame.physicscalculator.Physics;

import hu.tokingame.physicscalculator.BaseClass.Globals;
import sun.nio.cs.Surrogate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static hu.tokingame.physicscalculator.BaseClass.Globals.IS_DEBUG;
import static hu.tokingame.physicscalculator.BaseClass.Globals.bgIndex;
import static hu.tokingame.physicscalculator.BaseClass.Globals.gForces;
import static hu.tokingame.physicscalculator.Physics.MathUtils.sqr;
import static hu.tokingame.physicscalculator.Physics.MathUtils.dToF;
import static hu.tokingame.physicscalculator.Physics.MathUtils.fToD;

/**
 * Created by m on 10/5/2017.
 */

public class Calculator {
    private static float g = gForces[bgIndex];

    float v0 = 0f;
    float x = 0f;

    public static float getG() {
        return g;
    }

    public float getV0() {
        return v0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static void setG(float g) {
        Calculator.g = g;
    }

    float y = 0f;
    float[] alpha;


    public Calculator() {
        try {
            calcAlpha(v0, x, y);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Calculator(float v0, float x, float y) throws  Exception{
        calcAlpha(v0,x,y);
    }

    private void calcAlpha(float v0, float x, float y) throws Exception {

        double sqrt = Math.pow(v0,4)-g*(g*Math.pow(x,2) + 2*y*Math.pow(v0,2));

        if(Math.signum(sqrt) < 0){
            throw new Exception("Az értékek alapján a pálya nem határozható meg.");
        }

        this.v0 = v0;
        this.x = x;
        this.y = y;

        double alpha1 = Math.toDegrees(Math.atan((Math.pow(v0,2) + Math.sqrt(sqrt))/(g*x)));
        double alpha2 = Math.toDegrees(Math.atan((Math.pow(v0,2) - Math.sqrt(sqrt))/(g*x)));
        alpha = new float[] {(float)alpha1,(float)alpha2};
    }

    public void setV0(float v0) throws Exception {
        calcAlpha(v0, x, y);
        onChanged();
    }

    public void setX(float x) throws Exception {
        calcAlpha(v0, x, y);
        onChanged();
    }

    public void setY(float y) throws Exception {
        calcAlpha(v0, x, y);
        onChanged();
    }

    public void set(float v0, float x, float y) throws Exception {
        calcAlpha(v0, x, y);
        onChanged();
    }

    public float[] getAlpha(){
        return alpha;
    }

    protected void onChanged(){

    }

    public float getHeight(float time, int index) throws Exception{
        float a = 0f;
        switch (index){
            case 1: a = (float) Math.toRadians(alpha[0]); break;
            case 2: a = (float) Math.toRadians(alpha[1]); break;
            default: throw new Exception("Huehue nem 1 és 2 között van");
        }
        return (float)(v0 * time * Math.sin(a) - 0.5f * g * time*time);
    }

    public float getWidth(float time, int index) throws Exception{
        float a = 0f;
        switch (index){
            case 1: a = (float) Math.toRadians(alpha[0]); break;
            case 2: a = (float) Math.toRadians(alpha[1]); break;
            default: throw new Exception("Huehue nem 1 és 2 között van");
        }
        return (float)(v0 * time * Math.cos(a));
    }

    public float getMaxHeight(int index) throws Exception{
        float a = 0f;
        switch (index){
            case 1: a = (float) Math.toRadians(alpha[0]); break;
            case 2: a = (float) Math.toRadians(alpha[1]); break;
            default: throw new Exception("Huehue nem 1 és 2 között van");
        }
        float krumpli = (float)((v0 * v0 * Math.sin(a) * Math.sin(a)) / (2 * g));
        return krumpli > getHeight(getDuration(index),index) ? krumpli : getHeight(getDuration(index),index);
    }

    public float getDuration(int index) throws Exception{
        float a = 0f;
        switch (index){
            case 1: a = (float) Math.toRadians(alpha[0]); break;
            case 2: a = (float) Math.toRadians(alpha[1]); break;
            default: throw new Exception("Huehue nem 1 és 2 között van");
        }
        if(IS_DEBUG) {
            System.out.println(v0);
            System.out.println(x);
            System.out.println(Math.cos(a));
        }
        return (float) (x / (v0 * Math.cos(a)));
    }


/*
    public float calcX(float t){
        return v0 * t * dToF(Math.cos(fToD(alpha)));
    }

    public float calcY(float t){
        return (v0 * t * dToF(Math.sin(fToD(alpha))))-((g/2) * sqr(t));
    }

    public float calcTimeH(){
        return dToF((2*v0*Math.sin (alpha))/g);
    }

    */

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator(150, 14, 3);
        if(IS_DEBUG)System.out.println("---------");
        int index = 1;
        float duration = calculator.getDuration(index);
        if(IS_DEBUG) {
            System.out.println(calculator.getDuration(index));
            System.out.println("---------MAX");
            System.out.println(calculator.getMaxHeight(index));
            System.out.println("---------");
        }
        for(float f = 0; f<=duration; f+=duration/30){
            if(IS_DEBUG)System.out.println("time:" + f +" X:" + calculator.getWidth(f,index) + " Y:" + calculator.getHeight(f,index));
        }

    }


}
