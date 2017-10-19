package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

/**
 * Created by davim on 2017. 10. 12..
 */

public class Potato extends OneSpriteStaticActor {

    float elapsedTime = 0;
    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }
    int x;

    public Potato(float x, float y) {
        super(Assets.manager.get(Assets.POTATO));
        setPosition(x, y);
        setSize(50, 50);
        x = rand(-10, 10);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;
        setRotation(elapsedTime*x);
    }

    @Override
    protected void init() {
        super.init();

    }
}
