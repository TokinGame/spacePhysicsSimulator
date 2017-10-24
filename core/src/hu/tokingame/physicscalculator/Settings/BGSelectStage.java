package hu.tokingame.physicscalculator.Settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Simulation.MathScreen;

/**
 * Created by M on 10/24/2017.
 */

public class BGSelectStage extends MyStage {
    float elapsedtime = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    //// TODO: 10/24/2017 Normális hátterek
    private AssetDescriptor<Texture>[] bgs = new AssetDescriptor[]{Assets.POTATO, Assets.STEELBUTTON};

    private ArrayList<BGShowcaseActor> actors = new ArrayList<BGShowcaseActor>();

    private int index = 0;

    private OneSpriteStaticActor bgActor;

    private MyTextButton leftButton, rightButton;

    public BGSelectStage(Viewport viewport, Batch batch, final MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
        this.setDebugAll(true);

        addActor(bgActor = new OneSpriteStaticActor(Assets.manager.get(bgs[index])){
            @Override
            protected void init() {
                super.init();
                this.setPosition(0,0);
                this.setSize(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT);
            }
        });

        addBGShowCase();

        actors.get(index).setVisible(true);

        addActor(new MyTextButton("<--"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-250-this.getWidth(), Globals.WORLD_HEIGHT/2 - this.getHeight()/2);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        if(index - 1 >= 0){
                            index--;
                            actors.get(index + 1).hide(Globals.WORLD_WIDTH,Globals.WORLD_WIDTH);
                            changeBg();
                        }else{

                        }
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });

        addActor(new MyTextButton("-->"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2+250, Globals.WORLD_HEIGHT/2 - this.getHeight()/2);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        if(index + 1 <= bgs.length-1){
                            index++;
                            actors.get(index-1).hide(0-actors.get(index-1).getWidth(),0);
                            changeBg();
                        }else{

                        }
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });


        addActor(new BGShowcaseActor(Assets.manager.get(bgs[index])));

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


    }


    public void addBGShowCase(){
        for (AssetDescriptor<Texture> bg: bgs) {
            BGShowcaseActor actor = new BGShowcaseActor(Assets.manager.get(bg));
            actors.add(actor);
            addActor(actor);
        }
    }

    public void changeBg(){
        //bgActor.setTexture(Assets.manager.get(bgs[index]));
        actors.get(index).show();
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
