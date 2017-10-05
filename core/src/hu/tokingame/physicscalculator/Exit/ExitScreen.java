package hu.tokingame.physicscalculator.Exit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.MyGdxGame;



public class ExitScreen extends MyScreen {
    protected ExitStage exitStage;



    public ExitScreen(MyGdxGame game) {
        super(game);
        exitStage = new ExitStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(exitStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        exitStage.act(delta);
        exitStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        exitStage.refresh();
    }

    @Override
    public void dispose() {
        super.dispose();
        exitStage.dispose();
    }
}
