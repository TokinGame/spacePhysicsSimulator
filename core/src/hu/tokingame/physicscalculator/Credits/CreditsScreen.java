package hu.tokingame.physicscalculator.Credits;

import com.badlogic.gdx.Gdx;

import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.MyGdxGame;


public class CreditsScreen extends MyScreen {
    protected CreditsStage creditsStage;



    public CreditsScreen(MyGdxGame game) {
        super(game);
        creditsStage = new CreditsStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(creditsStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        creditsStage.act(delta);
        creditsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        creditsStage.refresh();
    }

    @Override
    public void dispose() {
        super.dispose();
        creditsStage.dispose();
    }
}
