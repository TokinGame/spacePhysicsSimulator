package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

import static hu.tokingame.physicscalculator.BaseClass.Globals.bgIndex;
import static hu.tokingame.physicscalculator.BaseClass.Globals.bgs;

/**
 * Created by M on 10/19/2017.
 */

public class TargetActor extends OneSpriteStaticActor {
    float elapsedTime = 0;


    public TargetActor(float x , float y) {
        super(Assets.manager.get(Assets.TARGET));
        setSize(150, 150);
        setOrigin(getWidth()/2, getHeight()/2);
        setPosition(x, y);
        if(bgs[bgIndex] == Assets.SPOOKY_BG){
            this.setTexture(Assets.manager.get(Assets.SPOOKY_PROJ));
            this.setSize(200,200);
        }
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
