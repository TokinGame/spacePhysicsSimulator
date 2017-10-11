package hu.tokingame.physicscalculator.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteActor;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.Exit.ExitScreen;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Settings.SettingsScreen;
import hu.tokingame.physicscalculator.Simulation.MathScreen;

/**
 * Created by davim on 2016. 10. 07..
 */

public class MenuStage extends MyStage {

    float elapsedtime = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }


    MyLabel szoveg;

    public MenuStage(Viewport viewport, Batch batch,final MyGdxGame game) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);

        addActor(new MyTextButton("Egy"){
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
            }
        });
        addActor(new MyTextButton("Kettő"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MathScreen(game,2), true);
                    }
                });
            }
        });

        addActor(new MyTextButton("nem segg"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new SettingsScreen(game), true);
                    }
                });
            }
        });


        addActor(new MyTextButton("Exit"){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game), true);
                    }
                });
            }
        });

    }


    public void refresh() {
        //backGround.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
           game.setScreen(new ExitScreen(game), true);
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

    public void init(){














        refresh();
    }
}

