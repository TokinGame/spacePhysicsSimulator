package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by davimatyi on 2017. 10. 04..
 */

public class InputButtons extends Group {

    MyTextButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, close, delete;

    MyLabel var;

    MathStage mathStage;

    private boolean kellMozgatni = false;

    private int initialX = Globals.WORLD_WIDTH;

    private final InputButtons btns = this;



    public InputButtons(MathStage stage) {
        this.setVisible(false);
        setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);

        mathStage = stage;

        //TODO add gombok

        b1 = new MyTextButton("1");
        b2 = new MyTextButton("2");
        b3 = new MyTextButton("3");
        b4 = new MyTextButton("4");
        b5 = new MyTextButton("5");
        b6 = new MyTextButton("6");
        b7 = new MyTextButton("7");
        b8 = new MyTextButton("8");
        b9 = new MyTextButton("9");
        b0 = new MyTextButton("0");
        close = new MyTextButton("Bezár");
        //TODO jobb felirat
        delete = new MyTextButton("Backspace");

        b1.setPosition(800, 500);
        b2.setPosition(900, 500);
        b3.setPosition(1000, 500);
        b4.setPosition(800, 400);
        b5.setPosition(900, 400);
        b6.setPosition(1000, 400);
        b7.setPosition(800, 300);
        b8.setPosition(900, 300);
        b9.setPosition(1000, 300);
        b0.setPosition(900, 200);

        b1.setSize(100,100);
        b2.setSize(100,100);
        b3.setSize(100,100);
        b4.setSize(100,100);
        b5.setSize(100,100);
        b6.setSize(100,100);
        b7.setSize(100,100);
        b8.setSize(100,100);
        b9.setSize(100,100);
        b0.setSize(100,100);

        close.setPosition(800, 100);
        delete.setPosition(1000, 100);

        addActor(b1);
        addActor(b2);
        addActor(b3);
        addActor(b4);
        addActor(b5);
        addActor(b6);
        addActor(b7);
        addActor(b8);
        addActor(b9);
        addActor(b0);
        addActor(close);
        addActor(delete);


        b0.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("0");
            }
        });
        b1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("1");
            }
        });
        b2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("2");
            }
        });
        b3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("3");
            }
        });
        b4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("4");
            }
        });
        b5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("5");
            }
        });
        b6.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("6");
            }
        });
        b7.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("7");
            }
        });
        b8.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("8");
            }
        });
        b9.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("9");
            }
        });
        close.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                hide();
                mathStage.disableButtons();
            }
        });
        delete.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                iras("bsp");
            }
        });
    }

    void iras(String t){
        if(var != null){
            if(var.getText().length() < Globals.maximumInputLength){
                if(t.equals("bsp")){
                    if(var.getText().length < 1) return;
                    var.setText(var.getText().substring(0,var.getText().length()-1));
                    return;
                }
                if(t.equals("0")){
                    if(var.getText().length() != 0) var.setText(var.getText()+t);
                }else {
                    var.setText(var.getText()+t);
                }

            }
        }
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void show(MyLabel szoveg){
        var = szoveg;
        if(!this.isVisible()){
            this.setVisible(true);
            this.setPosition(Globals.WORLD_WIDTH-750,0);
            final MoveToAction moveToAction = new MoveToAction();
            moveToAction.setPosition(0,0);
            moveToAction.setDuration(1.2f);
            this.addAction(sequence(moveToAction, run(new Runnable() {
                @Override
                public void run() {
                    btns.removeAction(moveToAction);
                }
            })));

        }
    }


    public void hide(){
        final MoveToAction moveToAction = new MoveToAction();
        moveToAction.setPosition(Globals.WORLD_WIDTH-750,0);
        moveToAction.setDuration(1.2f);
        this.addAction(sequence(moveToAction, run(new Runnable() {
            @Override
            public void run() {
                btns.removeAction(moveToAction);
                btns.setVisible(false);
            }
        })));

    }

}
