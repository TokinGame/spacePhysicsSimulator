package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.xml.bind.annotation.XmlElementDecl;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.Menu.MenuScreen;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Physics.Calculator;


public class SimulationStage extends MyStage {

    float elapsedtime = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    Calculator calculator;
    OneSpriteStaticActor grafikon;
    Potato potato;
    Pixmap pixmap;

    int h = 1000;

    int duration, step, dots = 20;

    public SimulationStage(Viewport viewport, Batch batch, final MyGdxGame game, Calculator calc) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
        calculator = calc;



        try{
            duration = (int)(calculator.getDuration(1)*1000);
            System.out.println(duration);
            step = duration/dots;

            pixmap = new Pixmap(duration, h, Pixmap.Format.RGBA8888);
            pixmap.setColor(8, 0, 0, 8);
        }catch(Exception e){
            e.printStackTrace();
        }


        for(int i = 0; i < dots; i++){
            try{
                rajzol(i*step, calculator.getHeight(i, 1));
            }catch(Exception e){
                e.printStackTrace();
            }
        }



    }




    void rajzol(double dx, double dy){
        int x = (int)dx, y = (int)dy;

        pixmap.fillCircle(x, h-y, 10);

        grafikon = new OneSpriteStaticActor(new Texture(pixmap));
        grafikon.setPosition(0,0);
        grafikon.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
        addActor(grafikon);

        System.out.println("dot at "+x+";"+y);



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

    }

    public void init(){














        refresh();
    }
}
