package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

/**
 * Created by M on 10/19/2017.
 */

public class TargetActor extends OneSpriteStaticActor {
    float elapsedTime = 0;


    public TargetActor(float x , float y) {
        super(Assets.manager.get(Assets.TARGET));
        setSize(160, 87.5f);
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;

    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x - this.getWidth()/2f, y - this.getHeight()/2f);
    }

    @Override
    protected void init() {
        super.init();

    }
}
