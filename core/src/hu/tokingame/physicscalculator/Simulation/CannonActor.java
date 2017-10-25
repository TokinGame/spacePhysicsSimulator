package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by M on 10/25/2017.
 */

public class CannonActor extends OneSpriteStaticActor {

    final CannonActor cannon = this;

    public CannonActor() {
        super(Assets.manager.get(Assets.CANNON));
    }

    public void rotateTo(float degrees, final ProjectileActor proj){
        final RotateToAction rotateToAction = new RotateToAction();
        rotateToAction.setDuration(0.5f);
        rotateToAction.setRotation(degrees);
        this.addAction(sequence(rotateToAction, run(new Runnable() {
            public void run () {
                cannon.removeAction(rotateToAction);
                proj.startSpinning();
            }
        })));
    }
}
