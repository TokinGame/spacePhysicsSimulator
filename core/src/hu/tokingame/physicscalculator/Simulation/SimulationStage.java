package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.BGStage;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.Menu.MenuScreen;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Physics.Calculator;

import static hu.tokingame.physicscalculator.BaseClass.Globals.IS_DEBUG;


public class SimulationStage extends BGStage {

    float elapsedtime = 0, p1Ftime = 0, p2Ftime = 0;

    private float timeOfSpinning = 0;

    private float pixmapWidht = 1280;
    private float pixmapHeight = 720;

    public float getScale() {
        return scale;
    }

    float scale;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    Calculator calculator;
    OneSpriteStaticActor grafikon;
    ProjectileActor potato1, potato2;
    Pixmap pixmap;
    TargetActor target;
    CannonActor cannon;
    MyLabel p1Time, p2Time;

    private final float rotationOffset = 45;

    int h = 1000;

    int duration, step, dots = 200;

    public SimulationStage(Viewport viewport, Batch batch, final MyGdxGame game, final Calculator calc) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
        calculator = calc;


        try{
            pixmap = new Pixmap((int)pixmapWidht, (int)pixmapHeight, Pixmap.Format.RGBA8888);
            //pixmap.setColor(1, 1, 1, 1);
            //pixmap.fill();
            //pixmap.setColor(8, 0, 0, 8);
        }catch(Exception e){
            e.printStackTrace();
        }


        float duration;
        try {
            scale = Math.min(Math.min(((float)pixmap.getHeight())/calculator.getMaxHeight(1), ((float)pixmap.getWidth())/calculator.getX()), Math.min(((float)pixmap.getHeight())/calculator.getMaxHeight(2), ((float)pixmap.getWidth())/calculator.getX()));
            scale *= 0.9f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(IS_DEBUG){
            System.out.println("-Scale-");
            System.out.println(scale);
        }
        int pmheight = pixmap.getHeight();
        int pmwidth = pixmap.getWidth();
        try {
            float f = 0;
            duration = calculator.getDuration(1);
            //System.out.println(calculator.getDuration(index));
            pixmap.setColor(0,1,0,1);
            for(f = 0; f<=duration; f+=duration/pixmapWidht){
                pixmap.fillCircle((int)(calculator.getWidth(f, 1)*scale), pmheight - (int)(calculator.getHeight(f, 1)*scale), 1);
            }
            pixmap.setColor(0,0.2f,0,1);
            while ((int)(calculator.getWidth(f, 1)*scale)<pmwidth && (int)(calculator.getHeight(f, 1)*scale)>0){
                f+=duration/pixmapWidht;
                pixmap.fillCircle((int)(calculator.getWidth(f, 1)*scale), pmheight - (int)(calculator.getHeight(f, 1)*scale), 1);
            }


            pixmap.setColor(1,0,0,1);
            duration = calculator.getDuration(2);
            for(f = 0; f<=duration; f+=duration/pixmapWidht){
                pixmap.fillCircle((int)(calculator.getWidth(f, 2)*scale), pmheight - (int)(calculator.getHeight(f, 2)*scale), 1);
            }

            pixmap.setColor(0.2f,0,0,1);
            while ((int)(calculator.getWidth(f, 2)*scale)<pmwidth && (int)(calculator.getHeight(f, 2)*scale)>0){
                f+=duration/pixmapWidht;
                pixmap.fillCircle((int)(calculator.getWidth(f, 2)*scale), pmheight - (int)(calculator.getHeight(f, 2)*scale), 1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            grafikon = new OneSpriteStaticActor(new Texture(pixmap));
            grafikon.setPosition(0,0);
            if(IS_DEBUG){
                grafikon.debug();
                setDebugAll(true);
            }
            target = new TargetActor(calculator.getX()*getScale(), calculator.getY()*getScale());
            addActor(target);
            grafikon.setSize(pixmap.getWidth(), pixmap.getHeight());
            addActor(grafikon);
            addActor(potato1 = new ProjectileActor(0,0));
            addActor(potato2 = new ProjectileActor(0,0));
            potato2.setVisible(false);
            addActor(cannon = new CannonActor(){
                @Override
                protected void init() {
                    super.init();
                    setSize(100, 100);
                    setOrigin(0,0);
                    setPosition(0, 0);
                    setRotation(0-rotationOffset);
                }
            });
            cannon.rotateTo(calc.getAlpha()[0]-rotationOffset, potato1);
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.CANNONBASE)){
                @Override
                protected void init() {
                    super.init();
                    setSize(100,100);
                    setPosition(0,0);
                }
            });


            addActor(new MyLabel("\u03B1\u2081: " + Math.round(calculator.getAlpha()[0]* 100) / 100.0f + "°", MyLabel.style4){
                @Override
                protected void init() {
                    super.init();
                    try {
                        setPosition(calculator.getWidth(calculator.getDuration(1)/2.0f,1) * scale, calculator.getHeight(calculator.getDuration(1)/2.0f,1) * scale);
                        setScale(0.75f);
                        setFontScale(0.75f);
                        setSize(getWidth() * 0.75f, getHeight() * 0.75f);
                    }catch (Exception e){}
                }
            });

            addActor(new MyLabel("\u03B1\u2082: " + Math.round(calculator.getAlpha()[1]* 100) / 100.0f + "°", MyLabel.style4){
                @Override
                protected void init() {
                    super.init();
                    try {
                        setPosition(calculator.getWidth(calculator.getDuration(2)/2.0f,2) * scale, calculator.getHeight(calculator.getDuration(2)/2.0f,2) * scale);
                        setScale(0.75f);
                        setFontScale(0.75f);
                        setSize(getWidth() * 0.75f, getHeight() * 0.75f);
                    }catch (Exception e){}
                }
            });

            addActor(new MyLabel("X: "+(int)calc.getX()+"m; Y: "+(int)calc.getY()+"m", MyLabel.style4){
                @Override
                protected void init() {
                    super.init();
                    setPosition(target.getX()+target.getWidth()/2-this.getWidth()/2, target.getY()+target.getHeight());
                    setScale(0.75f);
                    setFontScale(0.75f);
                    setSize(getWidth() * 0.75f, getHeight() * 0.75f);
                }
            });

            addActor(p1Time = new MyLabel("0.0 s", MyLabel.style4){
                @Override
                protected void init() {
                    super.init();
                    setPosition(potato1.getX(), potato1.getY());
                    setScale(0.75f);
                    setFontScale(0.75f);
                    setSize(getWidth() * 0.75f, getHeight() * 0.75f);
                }
            });
            addActor(p2Time = new MyLabel("0.0 s", MyLabel.style4){
                @Override
                protected void init() {
                    super.init();
                    setPosition(potato1.getX(), potato1.getY());
                    setScale(0.75f);
                    setFontScale(0.75f);
                    setSize(getWidth() * 0.75f, getHeight() * 0.75f);
                }
            });

            addActor(new MyTextButton("Vissza"){
                @Override
                protected void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, Globals.WORLD_HEIGHT-this.getHeight()-10);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            game.setScreenBackByStackPop();
                        }
                    });
                }
            });
            addActor(new MyTextButton("Újra"){
                @Override
                protected void init() {
                    super.init();
                    setPosition(10, Globals.WORLD_HEIGHT-this.getHeight()-10);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            game.setScreen(new SimulationScreen(game, calculator), false);
                        }
                    });
                }
            });
        }
/*
        System.out.println("---------");
        try {
            System.out.println(calculator.getDuration(index));
            System.out.println("---------MAX");
            System.out.println(calculator.getMaxHeight(index));
            System.out.println("---------");
            for(float f = 0; f<=duration; f+=duration/30){
                System.out.println("time:" + f +" X:" + calculator.getWidth(f,index) + " Y:" + calculator.getHeight(f,index));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

    }







    public void refresh() {


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




        try {
            if(potato1.isSpinning()){
                timeOfSpinning += delta;
                p1Ftime += delta;
                potato1.setPosition(calculator.getWidth(timeOfSpinning, 1)*scale, calculator.getHeight(timeOfSpinning, 1)*scale);
                p1Time.setPosition(potato1.getX(), potato1.getY()+potato1.getHeight());
                p1Time.setText(Math.floor(p1Ftime*10)/10f+" s");
                //p1Time.setSize(p1Time.getWidth() * 0.75f, p1Time.getHeight() * 0.75f);
                if(timeOfSpinning > calculator.getDuration(1)) {
                    potato1.stopSpinning();
                    timeOfSpinning = 0;
                    cannon.rotateTo(calculator.getAlpha()[1]-rotationOffset,potato2);
                    potato2.setVisible(true);
                }
            }
            if(potato2.isSpinning()){
                timeOfSpinning += delta;
                p2Ftime += delta;
                potato2.setPosition(calculator.getWidth(timeOfSpinning, 2)*scale, calculator.getHeight(timeOfSpinning, 2)*scale);
                p2Time.setPosition(potato2.getX(), potato2.getY()+potato2.getHeight());
                p2Time.setText(Math.floor(p2Ftime*10)/10f+" s");
               // p2Time.setSize(p2Time.getWidth() * 0.75f, p2Time.getHeight() * 0.75f);
                if(timeOfSpinning > calculator.getDuration(2)){
                    potato2.stopSpinning();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void init() {
        super.init();
        refresh();
    }
}
