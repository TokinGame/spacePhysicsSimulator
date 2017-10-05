package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;

/**
 * Created by davimatyi on 2017. 10. 04..
 */

public class InputButtons extends Group {

    MyTextButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;

    MyLabel var;


    public InputButtons(MathStage stage) {
        setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);

        //TODO add gombok








    }




    public void show(MyLabel szoveg){
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

        b1.setPosition(800, 600);
        b2.setPosition(900, 600);
        b3.setPosition(1000, 600);
        b4.setPosition(800, 500);
        b5.setPosition(900, 500);
        b6.setPosition(1000, 500);
        b7.setPosition(800, 400);
        b8.setPosition(900, 400);
        b9.setPosition(1000, 400);
        b0.setPosition(900, 300);

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

        var = szoveg;

        b0.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"0");
            }
        });
        b1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"1");
            }
        });
        b2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"2");
            }
        });
        b3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"3");
            }
        });
        b4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"4");
            }
        });
        b5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"5");
            }
        });
        b6.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"6");
            }
        });
        b7.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"7");
            }
        });
        b8.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"8");
            }
        });
        b9.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                var.setText(var.getText()+"9");
            }
        });


    }

}
