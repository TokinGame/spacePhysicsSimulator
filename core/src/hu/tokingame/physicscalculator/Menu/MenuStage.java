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
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteActor;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

/**
 * Created by davim on 2016. 10. 07..
 */

public class MenuStage extends MyStage {

    OneSpriteStaticActor kacsa;
    float elapsedtime = 0;
    ArrayList<OneSpriteStaticActor> piciKacsak = new ArrayList<OneSpriteStaticActor>();

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }


    public MenuStage(Viewport viewport, Batch batch, Game game) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);

        kacsa = new OneSpriteStaticActor(Assets.manager.get(Assets.DUCK));
        addActor(kacsa);
        kacsa.setSize(100, 100);
        kacsa.setPosition((Globals.WORLD_WIDTH/2)-(kacsa.getWidth()/2), (Globals.WORLD_HEIGHT/2)-(kacsa.getHeight()/2));
        this.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                kacsa.setPosition(x-(kacsa.getWidth()/2),y-(kacsa.getHeight()/2));
            }
        });
        kacsa.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                piciKacsak.add(new OneSpriteStaticActor(Assets.manager.get(Assets.DUCK)){
                    @Override
                    protected void init() {
                        super.init();
                        setSize(50, 50);
                        setPosition(rand(50, Globals.WORLD_WIDTH-50), rand(50, Globals.WORLD_HEIGHT-50));
                    }
                });
                addActor(piciKacsak.get(piciKacsak.size()-1));
            }
        });

    }


    public void refresh() {
        //backGround.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
           //game.setScreen(new ExitScreen(game));
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
        kacsa.setRotation(-elapsedtime*60);
        for (OneSpriteActor kaccss: piciKacsak) {
            kaccss.setRotation(-elapsedtime*60);
        }
    }

    public void init(){














        refresh();
    }
}

