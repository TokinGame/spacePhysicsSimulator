package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;

import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Physics.Calculator;

/**
 * Created by davim on 2016. 10. 07..
 */

public class SimulationScreen extends MyScreen {
    protected SimulationStage simulationStage;



    public SimulationScreen(MyGdxGame game, Calculator calculator) {
        super(game);
        simulationStage = new SimulationStage(viewport, spriteBatch, game, calculator);
        Gdx.input.setInputProcessor(simulationStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        simulationStage.act(delta);
        simulationStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        simulationStage.refresh();
    }

    @Override
    public void dispose() {
        super.dispose();
        simulationStage.dispose();
    }
}
