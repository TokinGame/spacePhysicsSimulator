package hu.tokingame.physicscalculator.Settings;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.BGStage;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Simulation.MathScreen;

/**
 * Created by davim on 2016. 10. 07..
 */

public class SettingsStage extends BGStage {

    float elapsedtime = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }


    public SettingsStage(Viewport viewport, Batch batch,final MyGdxGame game) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);

        addActor(new MyTextButton("vissza he"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });

        addActor(new MyTextButton("bg"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2 - this.getWidth()/2, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new BGSelectScreen(game),true);
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });


        addActor(new MyTextButton("Kell zene?"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 450);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MathScreen(game, 1), true);
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });


    }


    public void refresh() {
        //backGround.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreenBackByStackPop();
        }
        return false;
    }


    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedtime += delta;

    }

    @Override
    public void init(){
        super.init();
        refresh();
    }
}

