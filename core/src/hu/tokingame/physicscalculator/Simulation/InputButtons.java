package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.scenes.scene2d.Group;

import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;

/**
 * Created by davimatyi on 2017. 10. 04..
 */

public class InputButtons extends Group {


    public InputButtons(MathStage stage){
        setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);

        //TODO add gombok

        addActor(new MyLabel("aggyá ide gombokt", MyLabel.style2){
            @Override
            public void setPosition(float x, float y) {
                super.setPosition(800, 600);
            }
        });
    }
}
