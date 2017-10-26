package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

import static hu.tokingame.physicscalculator.BaseClass.Globals.bgIndex;
import static hu.tokingame.physicscalculator.BaseClass.Globals.bgs;

/**
 * Created by davim on 2017. 10. 12..
 */

public class ProjectileActor extends OneSpriteStaticActor {

    float elapsedTime = 0;
    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }
    int x = rand(-100,100);
    boolean spinning = false;

    public ProjectileActor(float x, float y) {
        super(Assets.manager.get(Assets.POTATO));
        setSize(50, 50);
        setPosition(x, y);
        if(bgs[bgIndex] == Assets.SPOOKY_BG){
            this.setTexture(Assets.manager.get(Assets.SPOOKY_TARGET));
        }
    }
    public void stopSpinning(){
        spinning = false;
    }
    public void startSpinning(){ spinning = true;}

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;
        if(spinning)setRotation(elapsedTime*x);

    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x - this.getWidth()/2f, y - this.getHeight()/2f);
    }

    @Override
    protected void init() {
        super.init();

    }

    boolean isSpinning(){
        return spinning;
    }
}
