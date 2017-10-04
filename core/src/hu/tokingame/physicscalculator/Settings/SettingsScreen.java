package hu.tokingame.physicscalculator.Settings;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.Menu.MenuStage;
import hu.tokingame.physicscalculator.MyGdxGame;

/**
 * Created by davim on 2016. 10. 07..
 */

public class SettingsScreen extends MyScreen {
    protected SettingsStage settingsStage;



    public SettingsScreen(MyGdxGame game) {
        super(game);
        settingsStage = new SettingsStage(viewport, spriteBatch, game);
        Gdx.input.setInputProcessor(settingsStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        settingsStage.act(delta);
        settingsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        settingsStage.refresh();
    }

    @Override
    public void dispose() {
        super.dispose();
        settingsStage.dispose();
    }
}
