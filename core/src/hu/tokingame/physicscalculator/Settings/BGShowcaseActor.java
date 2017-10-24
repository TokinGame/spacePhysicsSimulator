package hu.tokingame.physicscalculator.Settings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by M on 10/24/2017.
 */

public class BGShowcaseActor extends OneSpriteStaticActor {

    private final BGShowcaseActor bgShowcaseActor = this;

    public BGShowcaseActor(Texture texture) {
        super(texture);
        this.setVisible(false);
        this.setSize(400,225);
        this.setPosition(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT/2 - this.getHeight()/2);
    }

    public void show(){
        if(!this.isVisible()){
            this.setVisible(true);
            final MoveToAction moveToAction = new MoveToAction();
            moveToAction.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, this.getY());
            moveToAction.setDuration(1.2f);
            this.addAction(sequence(moveToAction, run(new Runnable() {
                @Override
                public void run() {
                    bgShowcaseActor.removeAction(moveToAction);
                }
            })));

        }
    }


    public void hide(final float posX, final float waitX){
        final MoveToAction moveToAction = new MoveToAction();
        moveToAction.setPosition(posX, this.getY());
        moveToAction.setDuration(1.2f);
        this.addAction(sequence(moveToAction, run(new Runnable() {
            @Override
            public void run() {
                bgShowcaseActor.removeAction(moveToAction);
                bgShowcaseActor.setVisible(false);
                bgShowcaseActor.setPosition(waitX, bgShowcaseActor.getY());
            }
        })));

    }
}
