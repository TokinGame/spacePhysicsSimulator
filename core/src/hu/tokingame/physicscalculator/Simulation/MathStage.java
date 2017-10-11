package hu.tokingame.physicscalculator.Simulation;

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
import hu.tokingame.physicscalculator.MyGdxGame;

/**
 * Created by davim on 2016. 10. 07..
 */

public class MathStage extends MyStage {

    float elapsedtime = 0;

    MyLabel szam1, szam2, eredmeny1, eredmeny2;
    MyTextButton szovegcucc, szovegcucc2;
    InputButtons inputButtons;
    float var1 = 0, var2 = 0, var3 = 0, var4 = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    int mode;

    float[] vegeredmeny = new float[2];


    MathStage stage;

    public MathStage(Viewport viewport, Batch batch, final MyGdxGame game, int mode) {

        super(viewport, batch, game);
        stage = this;
        this.mode = mode;
        Gdx.input.setCatchBackKey(true);


        stage.addActor(inputButtons = new InputButtons(stage));
        inputButtons.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
        inputButtons.setPosition(1280,0);


        addActor(new MyTextButton("nem"){
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
            }
        });
        addActor(szam1 = new MyLabel("", MyLabel.style));
        addActor(szam2 = new MyLabel("", MyLabel.style));
        addActor(eredmeny1 = new MyLabel("Erő: "+var3+" n", MyLabel.style));
        addActor(eredmeny2 = new MyLabel("Szög: "+var4+" °", MyLabel.style));


        addActor(szovegcucc = new MyTextButton("Távolság: ", null));
        szovegcucc.setPosition(50, 600);
        szovegcucc.setTexture(Assets.manager.get(Assets.BUTTONBG));
        addActor(szovegcucc2 = new MyTextButton("Magasság: ", null));
        szovegcucc2.setPosition(50, 500);
        szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTONBG));
        MyLabel ered;
        addActor(ered = new MyLabel("Eredmények: ", MyLabel.style));
        ered.setPosition(50, 300);



        if(mode == 1){
            szam1.setPosition(300, 600);
            szam2.setPosition(300, 500);
            szam1.setSize(210, 60);
            szam2.setSize(210, 60);
            eredmeny1.setPosition(100, 200);
            eredmeny2.setPosition(100, 100);
            szovegcucc.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam1);
                    szovegcucc.enableTexture(true);
                    szovegcucc2.enableTexture(false);
                }
            });
            szovegcucc2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam2);
                    szovegcucc.enableTexture(false);
                    szovegcucc2.enableTexture(true);
                }
            });
        }else{

        }






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

    public void disableButtons(){
        szovegcucc.enableTexture(false);
        szovegcucc2.enableTexture(false);
    }

    public void init(){



        refresh();
        setDebugAll(true);
    }
}

