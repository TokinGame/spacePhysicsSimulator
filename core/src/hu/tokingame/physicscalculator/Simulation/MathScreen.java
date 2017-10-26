package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;

import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.MyGdxGame;

/**
 * Created by davim on 2016. 10. 07..
 */

public class MathScreen extends MyScreen {
    protected MathStage mathStage;



    public MathScreen(MyGdxGame game) {
        super(game);
        mathStage = new MathStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(mathStage);
    }

    @Override
    public void backFromStack() {
        super.backFromStack();
        mathStage.setValuesBack();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        mathStage.act(delta);
        mathStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        mathStage.refresh();
    }

    @Override
    public void dispose() {
        super.dispose();
        mathStage.dispose();
    }
}
