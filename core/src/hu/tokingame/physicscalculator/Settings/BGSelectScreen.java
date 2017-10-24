package hu.tokingame.physicscalculator.Settings;

import com.badlogic.gdx.Gdx;

import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.MyGdxGame;

/**
 * Created by M on 10/24/2017.
 */

public class BGSelectScreen extends MyScreen {
    protected BGSelectStage bgSelectStage;



    public BGSelectScreen(MyGdxGame game) {
        super(game);
        bgSelectStage = new BGSelectStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(bgSelectStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        bgSelectStage.act(delta);
        bgSelectStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        bgSelectStage.refresh();
    }

    @Override
    public void dispose() {
        super.dispose();
        bgSelectStage.dispose();
    }
}
