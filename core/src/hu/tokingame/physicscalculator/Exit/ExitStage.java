package hu.tokingame.physicscalculator.Exit;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.Menu.MenuScreen;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Settings.SettingsScreen;
import hu.tokingame.physicscalculator.Simulation.MathScreen;


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
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteActor;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Settings.SettingsScreen;
import hu.tokingame.physicscalculator.Simulation.MathScreen;



public class ExitStage extends MyStage {

    float elapsedtime = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }
    MyLabel uzi;

    public ExitStage(Viewport viewport, Batch batch, final MyGdxGame game) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);

        addActor(uzi=new MyLabel("Biztosan hátra akarod hagyni az űrkutatást?",MyLabel.style));
        uzi.setPosition(Globals.WORLD_WIDTH/2-uzi.getWidth()/2f, Globals.WORLD_HEIGHT/2-uzi.getHeight()/2f+200);

        addActor(new MyTextButton("Nem"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game), true);
                    }
                });
            }
        });

        addActor(new MyTextButton("Igen"){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Assets.unload();
                        System.exit(0);
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

    public void init(){














        refresh();
    }
}
