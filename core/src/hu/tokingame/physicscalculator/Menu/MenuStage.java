package hu.tokingame.physicscalculator.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.Credits.CreditsScreen;
import hu.tokingame.physicscalculator.Exit.ExitScreen;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Physics.Calculator;
import hu.tokingame.physicscalculator.Settings.BGSelectScreen;
import hu.tokingame.physicscalculator.Simulation.MathScreen;
import hu.tokingame.physicscalculator.Simulation.SimulationScreen;

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
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENUBACKGROUND)){
            @Override
            protected void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENUBACKGROUND2)){
            @Override
            protected void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new MyTextButton("Kilövés"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 300);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MathScreen(game), true);
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });



        if(Globals.IS_DEBUG){
            addActor(new MyTextButton("Debug"){
                @Override
                protected void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 150);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            try{
                                Calculator clac = new Calculator(15f,5f,3f);
                                game.setScreen(new SimulationScreen(game, clac), true);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                    setTexture(Assets.manager.get(Assets.STEELBUTTON));
                    enableTexture(true);
                }
            });
        }

        addActor(new MyTextButton("Beállítások"){

            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new BGSelectScreen(game), true);
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });


        addActor(new MyTextButton(""){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 50);
                setSize(150, 150);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game), true);
                    }
                });
                setTexture(Assets.manager.get(Assets.EXITSIGN));
                enableTexture(true);
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MUSIC_ON)){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 260);
                setSize(150,150);
                if(Globals.sounds) setTexture(Assets.manager.get(Assets.MUSIC_ON));
                else Assets.manager.get(Assets.MUSIC_OFF);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.sounds = !Globals.sounds;
                        if(Globals.sounds) {
                            setTexture(Assets.manager.get(Assets.MUSIC_ON));
                            Assets.manager.get(Assets.MAIN_MUSIC).play();
                        }
                        else {
                            setTexture(Assets.manager.get(Assets.MUSIC_OFF));
                            Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        }
                    }
                });
            }
        });
        addActor(new MyTextButton("Készítők"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 300);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new CreditsScreen(game));
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

