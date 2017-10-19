package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
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

    public float getScale() {
        return scale;
    }

    float scale;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    Calculator calculator;
    OneSpriteStaticActor grafikon;
    Potato potato1, potato2;
    Pixmap pixmap;
    Target target;


    int h = 1000;

    int duration, step, dots = 200;

    public SimulationStage(Viewport viewport, Batch batch, final MyGdxGame game, Calculator calc) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
        calculator = calc;


        try{
            pixmap = new Pixmap(1024, 576, Pixmap.Format.RGBA8888);
            //pixmap.setColor(1, 1, 1, 1);
            //pixmap.fill();
            //pixmap.setColor(8, 0, 0, 8);
        }catch(Exception e){
            e.printStackTrace();
        }


        float duration;
        try {
            scale = Math.min(Math.min(((float)pixmap.getHeight())/calculator.getMaxHeight(1), ((float)pixmap.getWidth())/calculator.getX()), Math.min(((float)pixmap.getHeight())/calculator.getMaxHeight(2), ((float)pixmap.getWidth())/calculator.getX()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-Scale-");
        System.out.println(scale);
        int pmheight = pixmap.getHeight();
        int pmwidth = pixmap.getWidth();
        try {
            float f = 0;
            duration = calculator.getDuration(1);
            //System.out.println(calculator.getDuration(index));
            pixmap.setColor(0,1,0,1);
            for(f = 0; f<=duration; f+=duration/1024f){
                pixmap.fillCircle((int)(calculator.getWidth(f, 1)*scale), pmheight - (int)(calculator.getHeight(f, 1)*scale), 1);
            }
            pixmap.setColor(0,0.2f,0,1);
            while ((int)(calculator.getWidth(f, 1)*scale)<pmwidth && (int)(calculator.getHeight(f, 1)*scale)>0){
                f+=duration/1024f;
                pixmap.fillCircle((int)(calculator.getWidth(f, 1)*scale), pmheight - (int)(calculator.getHeight(f, 1)*scale), 1);
            }


            pixmap.setColor(1,0,0,1);
            duration = calculator.getDuration(2);
            for(f = 0; f<=duration; f+=duration/1024f){
                pixmap.fillCircle((int)(calculator.getWidth(f, 2)*scale), pmheight - (int)(calculator.getHeight(f, 2)*scale), 1);
            }

            pixmap.setColor(0.2f,0,0,1);
            while ((int)(calculator.getWidth(f, 2)*scale)<pmwidth && (int)(calculator.getHeight(f, 2)*scale)>0){
                f+=duration/1024f;
                pixmap.fillCircle((int)(calculator.getWidth(f, 2)*scale), pmheight - (int)(calculator.getHeight(f, 2)*scale), 1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            grafikon = new OneSpriteStaticActor(new Texture(pixmap));
            grafikon.setPosition(0,0);
            if(Globals.IS_DEBUG){
                grafikon.debug();
                setDebugAll(true);
            }
            target = new Target(calculator.getX()*getScale(), calculator.getY()*getScale());
            addActor(target);
            grafikon.setSize(pixmap.getWidth(), pixmap.getHeight());
            addActor(grafikon);
            addActor(potato1 = new Potato(0,0));
            addActor(potato2 = new Potato(0,0));

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
            if(elapsedtime < calculator.getDuration(1)){
                potato1.setPosition(calculator.getWidth(elapsedtime, 1)*scale, calculator.getHeight(elapsedtime, 1)*scale);
            }else potato1.stopSpinning();
            if(elapsedtime < calculator.getDuration(2)){
                potato2.setPosition(calculator.getWidth(elapsedtime, 2)*scale, calculator.getHeight(elapsedtime, 2)*scale);
            }else potato2.stopSpinning();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void init(){
        refresh();
    }
}
