package hu.tokingame.physicscalculator.BaseClass;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.MyGdxGame;


/**
 * Created by M on 2016. 09. 30..
 */
abstract public class MyStage extends Stage {
    public final MyGdxGame game;

    public MyStage(MyGdxGame game) {
        this.game = game;
        init();
    }

    public MyStage(Viewport viewport, MyGdxGame game) {
        super(viewport);
        this.game = game;
        init();
    }

    public MyStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch);
        this.game = game;
        init();
    }

    abstract protected void init();

    public void addBackEventStackListener()    {
        addListener(new InputListener() {

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode== Input.Keys.BACK || keycode == Input.Keys.ESCAPE) {
                    game.setScreenBackByStackPop();
                }
                return true;
            }
        });
    }

}
