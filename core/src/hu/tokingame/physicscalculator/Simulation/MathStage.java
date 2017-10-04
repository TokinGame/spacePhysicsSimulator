package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

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

    MyLabel input1, input2, input3, input4;
    InputButtons input;
    float var1 = 0, var2 = 0, var3 = 0, var4 = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }


    MathStage stage;

    public MathStage(Viewport viewport, Batch batch, final MyGdxGame game) {

        super(viewport, batch, game);
        stage = this;
        Gdx.input.setCatchBackKey(true);

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
        addActor(input1 = new MyLabel(var1+" m/s", MyLabel.style));
        addActor(input2 = new MyLabel(var2+"°", MyLabel.style));
        addActor(input3 = new MyLabel(var3+" m", MyLabel.style));
        addActor(input4 = new MyLabel(var4+" m", MyLabel.style));
        input1.setPosition(100, 600);
        input2.setPosition(100, 500);
        input3.setPosition(100, 400);
        input4.setPosition(100, 300);


        input1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stage.addActor(input = new InputButtons(stage));
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

