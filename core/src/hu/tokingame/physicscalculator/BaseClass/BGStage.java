package hu.tokingame.physicscalculator.BaseClass;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.MyGdxGame;

import static hu.tokingame.physicscalculator.BaseClass.Globals.bgIndex;
import static hu.tokingame.physicscalculator.BaseClass.Globals.bgs;

/**
 * Created by M on 10/25/2017.
 */

public class BGStage extends MyStage {
    private OneSpriteStaticActor bg;

    public BGStage(MyGdxGame game) {
        super(game);
    }

    public BGStage(Viewport viewport, MyGdxGame game) {
        super(viewport, game);
    }

    public BGStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    public void updateBG(){
        bg.setTexture(Assets.manager.get(bgs[bgIndex]));
    }

    @Override
    protected void init() {
        addActor(bg = new OneSpriteStaticActor(Assets.manager.get(bgs[bgIndex])){
            @Override
            protected void init() {
                super.init();
                this.setPosition(0,0);
                this.setSize(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT);
            }
        });
    }
}
